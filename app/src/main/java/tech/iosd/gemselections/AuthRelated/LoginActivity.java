package tech.iosd.gemselections.AuthRelated;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tech.iosd.gemselections.MainContent.MainActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.InternetConnectivity;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener,GoogleApiClient.OnConnectionFailedListener{

    private FirebaseAuth mAuth;
    private EditText _email, _password;
    private Button _login, _signup,btFb;
    private TextView _forgetPass;

    private String email, password;

    private ProgressDialog dialog;

    private SharedPreferences sharedPreferences;
    private SignInButton _googleLogin;
    GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 101;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;
    private CallbackManager mCallbackManager;
    public static final String TAG = "facelog";
    LoginButton loginButton;
    Context context;
    FirebaseUser currentUser;
    int n=0;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        _email = (EditText) findViewById(R.id.email);
        _email.setOnFocusChangeListener(this);
        _password = (EditText) findViewById(R.id.pass);

        _login = (Button) findViewById(R.id.login_button);
        _login.setOnClickListener(this);
        _signup = (Button) findViewById(R.id.signup_button);
        _signup.setOnClickListener(this);

        _forgetPass = (TextView) findViewById(R.id.forget_pass);
        _forgetPass.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(SharedPreferencesUtils.prefsUserName, MODE_PRIVATE);

        _googleLogin= (SignInButton) findViewById(R.id.btn_google_login);
        _googleLogin.setOnClickListener(this);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//btFb=findViewById(R.id.fblogin);
//btFb.setOnClickListener(this);
//fb login

        loginButton=findViewById(R.id.login_button_fb);
        //loginButton.setOnClickListener(this);
        mCallbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.login_button_fb);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
                n=1;
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
            }
        });
    }

    @Override
    public void onClick(View v) {
//        if(v==btFb){
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction =
//                    fragmentManager.beginTransaction();
//            facebookLogin fb=new facebookLogin();
//            fragmentTransaction.replace(R.id.login_container,fb);
//            fragmentTransaction.commit();
//        }

        if (v == _googleLogin) {
            GoogleSignIn();
        }

        if (v == _login) {
            loginfunc();
        }

        if (v == _signup) {
            finish();
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        }

        if (v == _forgetPass) {
            try {
                _forgetPass.animate().translationY(8f).setDuration(300).start();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish();
            startActivity(new Intent(LoginActivity.this, ForgetPassActivity.class));
        }



    }

    private void GoogleSignIn() {

        Boolean loginReady=true;
        if (!InternetConnectivity.ISCONNECTED) {
            Toast toast = Toast.makeText(LoginActivity.this, "Internet Connection Not Available", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            loginReady = false;
        }
        if(loginReady==true){
            Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
            finish();
            startActivityForResult(intent,RC_SIGN_IN);
        }}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
if(user !=null) {
    mCallbackManager.onActivityResult(requestCode, resultCode, data);

}


    }

    private void handleResult(GoogleSignInResult result){

        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            String name=account.getDisplayName();
            String email=account.getEmail();
            Intent i=new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("GoogleUserName", name);
            bundle.putString("GoogleEmail",email);



            i.putExtras(bundle);


            sharedPreferences.edit()
                    .putBoolean(SharedPreferencesUtils.prefsLoggedIn,true)
                    .apply();

            startActivity(i);

            finish();
        }

    }


    private void loginfunc() {
        email = _email.getText().toString();
        password = _password.getText().toString();

        boolean login_ready = true;

        if (!isEmailValid(email)) {
            login_ready = false;
            _email.setError("Email address not correct");
        }
        if (!isPassValid(password)) {
            login_ready = false;
            _password.setError("Password length should be greater than 6 characters");
        }
        if (!InternetConnectivity.ISCONNECTED) {
            Toast toast = Toast.makeText(LoginActivity.this, "Internet Connection Not Available", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            login_ready = false;
        }

        if (login_ready) {
            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setMessage("Please wait while we log you in....");
            dialog.show();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialog.dismiss();

                            if (!task.isSuccessful()) {
                                Snackbar.make(getCurrentFocus(), "Login Failed. Check Email/Password", Snackbar.LENGTH_LONG)
                                        .setAction("TRY AGAIN", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                loginfunc();
                                            }
                                        })
                                        .show();
                            } else {

                                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                                String name="";
                                String contact = "";

                                if (firebaseUser != null) {
                                    name = firebaseUser.getDisplayName();
                                    contact = firebaseUser.getPhoneNumber();

                                }
                                sharedPreferences.edit()
                                        .putBoolean(SharedPreferencesUtils.prefsLoggedIn, true)
                                        .putString(SharedPreferencesUtils.prefsUserName, name)
                                        .putString(SharedPreferencesUtils.prefsUserEmail, email)
                                        .putString(SharedPreferencesUtils.prefsUserNumber, contact)
                                        .apply();


                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            }
                        }
                    });

        } else {
            Toast.makeText(LoginActivity.this, "Check Login Credentials", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            if (v == _email) {
                if (!isEmailValid(_email.getText().toString())) {
                    _email.setError("Email Address Not Valid");
                }
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            updateUI();
        }


    }

    private void updateUI() {

        Toast.makeText(context, "You are loged in", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @SuppressLint("NewApi")
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                             user = mAuth.getCurrentUser();
                            updateUI();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());

                            Toast.makeText(context, "Authentication failed", Toast.LENGTH_SHORT).show();

                            updateUI();
                        }

                        // ...
                    }
                });
    }

}
