package tech.iosd.gemselections.JewelleryAlpha.DesignOwn;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tech.iosd.gemselections.BuildConfig;
import tech.iosd.gemselections.Models.CreateOwnModel;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

import static android.view.View.GONE;

/**
 * Created by anonymous on 28/8/17.
 */

public class DesignOwnActivity extends AppCompatActivity implements View.OnClickListener {

    private static String PATH;
    Uri uri;
    private ImageView to_upload;
    private Button submit, capture_image;
    private LinearLayout _submit_form;
    private EditText name, email, phone;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    private StorageReference photoRef;
    private StorageReference mStorageRef;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designown);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTitle("Design Your Own Jewellery!");
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("createownjewellery");

        sharedPreferences = getSharedPreferences(SharedPreferencesUtils.sharedPreferencesName, MODE_PRIVATE);

        _submit_form = (LinearLayout) findViewById(R.id.submit_form);
        to_upload = (ImageView) findViewById(R.id.custom_design_img);
        capture_image = (Button) findViewById(R.id.capture_img);
        capture_image.setOnClickListener(this);

        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.Email);
        phone = (EditText) findViewById(R.id.Mobile);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
        if (mAuth.getCurrentUser() == null) {
            //do nothing
        } else {
            FirebaseUser user = mAuth.getCurrentUser();
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
        }

    }

    @Override
    public void onClick(View v) {
        if (v == capture_image) {
            take_pictureALPA();
            capture_image.setText("Retake");
            to_upload.setVisibility(View.VISIBLE);
            _submit_form.setVisibility(View.VISIBLE);
        }

        if (v == submit) {
            final String __name = name.getText().toString();
            final String __email = email.getText().toString();
            final String __mobile = phone.getText().toString();

            if (!__name.isEmpty() && isEmailValid(__email) && !__mobile.isEmpty()) {

                try {

                    mStorageRef = FirebaseStorage.getInstance().getReference().child("orders");
                    photoRef = mStorageRef.child(System.currentTimeMillis() + "");

                    InputStream is = new FileInputStream(new File(PATH));
                    UploadTask uploadTask = photoRef.putStream(is);


                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Snackbar.make(getCurrentFocus(), "Upload Failed.", Snackbar.LENGTH_SHORT)
                                    .setAction("RETRY",
                                            new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
//
                                                }
                                            })
                                    .show();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {
                                Log.d("TAGGER", task.getResult().toString());
                                CreateOwnModel createOwnModel = new CreateOwnModel(__name
                                        , task.getResult().getDownloadUrl().toString()
                                        , __email
                                        , __mobile);

                                mRef.push().setValue(createOwnModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                            show_greet();

                                    }
                                });
//                                    public CreateOwnModel(String user_name, String image_url, String user_email, String user_umber) {
//
//                                this.user_name = user_name;
//                                this.image_url = image_url;
//                                this.user_email = user_email;
//                                this.user_umber = user_umber;
//                            }
                            }
                        }
                    });

                } catch (FileNotFoundException e) {

                }


            } else {
                Toast.makeText(DesignOwnActivity.this, "Enter Valid Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isEmailValid(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void show_greet() {
        new AlertDialog.Builder(DesignOwnActivity.this)
                .setMessage("Thank you for sharing your idea with us. Gemselections will analyse your design and send you the price quotation on your e-mail or phone within 3 working days. \n\n !!HAPPY SHOPPING!! \n\n ©Khanna Gems Pvt. Ltd.")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                        startActivity(getIntent());
                    }
                })
                .setIcon(R.drawable.ic_thankyou)
                .setTitle("THANK YOU")
                .create().show();
    }

    public void take_pictureALPA() {

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 3);


            } else {
                Toast.makeText(this, "Permission Denied. Could not proceed further", Toast.LENGTH_SHORT).show();
                if (_submit_form.getVisibility() == View.VISIBLE) {
                    _submit_form.setVisibility(GONE);
                    to_upload.setVisibility(GONE);

                }
            }
        }
        if (requestCode == 2) {
            if (grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap mustOpen = BitmapFactory.decodeFile(PATH, options);
                to_upload.setImageBitmap(mustOpen);
            }
        }
        if (requestCode == 3) {
            if (grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {

                String path = Environment.getExternalStorageDirectory().toString() + "/GemSelections";

                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdir();
                }

                String filename = "JPEG_" + new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date()) + ".jpg";

                File image = new File(dir, filename);

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                Uri photoURI = FileProvider.getUriForFile(DesignOwnActivity.this,
                        BuildConfig.APPLICATION_ID + ".provider",
                        image);


                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                intent.putExtra("return-data", true);
                try {
                    startActivityForResult(intent, 1);
                    PATH = image.getAbsolutePath();
                } catch (Exception e) {
                    Toast.makeText(this, "Please allow all permissions in settings", Toast.LENGTH_SHORT).show();

                }

                load_image();
            } else {
                Toast.makeText(this, "Please allow all permissions in settings", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void load_image() {

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 2);

    }


}


