package tech.iosd.gemselections.AuthRelated;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tech.iosd.gemselections.MainContent.MainActivity;
import tech.iosd.gemselections.Utils.InternetConnectivity;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private FirebaseUser user;

    private Button _sign_up;
    private EditText _name, _email, _contact, _pass;
    private TextView _already;

    private String name, email, contact, password;

    private SharedPreferences sharedPreferences;

    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();

        _sign_up = (Button) findViewById(tech.iosd.gemselections.R.id._signup_button);
        _sign_up.setOnClickListener(this);

        _already = (TextView) findViewById(tech.iosd.gemselections.R.id._signupregistered);

        sharedPreferences = getSharedPreferences(SharedPreferencesUtils.prefsUserName, MODE_PRIVATE);

        _already.setOnClickListener(this);
        _name = (EditText) findViewById(tech.iosd.gemselections.R.id._signupname);
        _email = (EditText) findViewById(tech.iosd.gemselections.R.id._signupemail);
        _contact = (EditText) findViewById(tech.iosd.gemselections.R.id._signupphone);
        _pass = (EditText) findViewById(tech.iosd.gemselections.R.id._signuppass);
    }

    @Override
    public void onClick(View v) {

        if (v == _sign_up) {
            signup_func();
        }
        if (v == _already) {
            try {
                _already.animate().translationY(4f).setDuration(300).start();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        }

    }

    private void signup_func() {
        name = _name.getText().toString();
        email = _email.getText().toString();
        contact = _contact.getText().toString();
        password = _pass.getText().toString();

        boolean signup_ready = true;

        if (!isEmailValid(email)) {
            signup_ready = false;
            _email.setError("Email address not correct");
        }
        if (!isPassValid(password)) {
            signup_ready = false;
            _pass.setError("Password length should be greater than 6 characters");
        }
        if (!isNameValid(name)) {
            signup_ready = false;
            _name.setError("Name Cannot be empty or numerical");
        }
        if (!isContactValid(contact)) {
            signup_ready = false;
            _contact.setError("Enter A Valid Mobile Number");
        }
        if (!InternetConnectivity.ISCONNECTED) {
            Toast toast = Toast.makeText(SignUpActivity.this, "Internet Connection Not Available", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            signup_ready = false;
        }

        if (signup_ready) {
            dialog = new ProgressDialog(SignUpActivity.this);
            dialog.setTitle("Please Wait");
            dialog.setMessage("Registering User...");
            dialog.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Sorry For Inconvenience", Toast.LENGTH_SHORT).show();

                                Snackbar.make(getCurrentFocus(), "Could Not Register This Time. ", Snackbar.LENGTH_SHORT)
                                        .setAction("TRY AGAIN", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                signup_func();
                                            }
                                        }).show();

                            } else {
                                user = mAuth.getCurrentUser();
                                assert user != null;
                                mRef.child("users").child(user.getUid()).setValue(new UserInfo(name, email, contact));

                                UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(name)
                                        .setPhotoUri(null)
                                        .build();
                                user.updateProfile(request)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                dialog.dismiss();

                                                if (!task.isSuccessful()) {
                                                    Toast.makeText(getApplicationContext(), "Could not update profile", Toast.LENGTH_SHORT).show();
                                                }

                                                sharedPreferences.edit()
                                                        .putBoolean(SharedPreferencesUtils.prefsLoggedIn, true)
                                                        .putString(SharedPreferencesUtils.prefsUserEmail, email)
                                                        .putString(SharedPreferencesUtils.prefsUserName,name)
                                                        .putString(SharedPreferencesUtils.prefsUserNumber,contact)
                                                        .apply();

                                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                                finish();
                                            }
                                        });
                            }
                        }
                    });
        }
    }

    private boolean isEmailValid(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isPassValid(String password) {
        return password.length() > 6;
    }

    private boolean isNameValid(String name) {
        return (!TextUtils.isDigitsOnly(name) && !name.isEmpty());
    }

    private boolean isContactValid(String phone) {
        return (TextUtils.isDigitsOnly(phone) && phone.length() == 10);
    }
}
