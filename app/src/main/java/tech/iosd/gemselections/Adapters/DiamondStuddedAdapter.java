package tech.iosd.gemselections.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import tech.iosd.gemselections.AuthRelated.LoginActivity;
import tech.iosd.gemselections.DataProviders.DiamondStuddeddProvider;
import tech.iosd.gemselections.DataProviders.Victorian;
import tech.iosd.gemselections.Models.OrderModel;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

/**
 * Created by SAM33R on 24-03-2018.
 */

public class DiamondStuddedAdapter extends  RecyclerView.Adapter<DiamondStuddedAdapter.ViewHolder> {
    StorageReference mStorageRef;
    DatabaseReference reference;
    SharedPreferences sharedPreferences;
    private Context context;
    private List<DiamondStuddeddProvider> victorianList;

    public DiamondStuddedAdapter(Context context, List<DiamondStuddeddProvider> victorianList, StorageReference mStorageRef) {
        this.context = context;
        this.victorianList = victorianList;
        this.mStorageRef = mStorageRef;
        reference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public DiamondStuddedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jewellery_items, parent, false);

        sharedPreferences = context.getSharedPreferences(SharedPreferencesUtils.prefsUserName, Context.MODE_PRIVATE);

        return new DiamondStuddedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DiamondStuddedAdapter.ViewHolder holder, final int position) {
        mStorageRef.child(victorianList.get(position).getDownloadUrl1() + ".png")
                .getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(context.getApplicationContext())
                        .load(uri.toString())
                        .into(holder.img1);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prompt(victorianList.get(position).getDownloadUrl1(), victorianList.get(position).getDownloadUrl1(), position);
            }
        });


        mStorageRef.child(victorianList.get(position).getDownloadUrl2() + ".png")
                .getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
//                Log.d("TAGGER", uri.toString());

                Picasso.with(context.getApplicationContext())
                        .load(uri.toString())
                        .into(holder.img2);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
        holder.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prompt(victorianList.get(position).getDownloadUrl2(), victorianList.get(position).getDownloadUrl2(), position);
            }
        });

        mStorageRef.child(victorianList.get(position).getDownloadUrl3() + ".png")
                .getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(context.getApplicationContext())
                        .load(uri.toString())
                        .into(holder.img3);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

        holder.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prompt(victorianList.get(position).getDownloadUrl3(), victorianList.get(position).getDownloadUrl3(), position);
            }
        });
    }


    private void prompt(final String url, final String code, final int position) {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_order_layout);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());

        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        dialog.getWindow().setAttributes(params);

        dialog.show();

        EditText _code = dialog.findViewById(R.id.prompt_code);
        _code.setText(code);

        EditText nameEditText = dialog.findViewById(R.id.prompt_name);

        nameEditText.setText(sharedPreferences.getString(SharedPreferencesUtils.prefsUserName, ""));

        EditText emailEditText = dialog.findViewById(R.id.prompt_email);

        emailEditText.setText(sharedPreferences.getString(SharedPreferencesUtils.prefsUserEmail, ""));

        final EditText phoneEditText = dialog.findViewById(R.id.prompt_mobile);

        final EditText prompt_remarks = dialog.findViewById(R.id.prompt_remarks);
        prompt_remarks.setText("");

        phoneEditText.setText(sharedPreferences.getString(SharedPreferencesUtils.prefsUserNumber, ""));

        final ImageView img = (ImageView) dialog.findViewById(R.id.prompt_image);

        mStorageRef.child(url + ".png").getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.with(context.getApplicationContext())
                                .load(uri.toString())
                                .into(img);
                    }
                });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            img.setImageDrawable(context.getDrawable(R.drawable.ic_thankyou));
        }

        Button submit = dialog.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                final ProgressDialog progressDialog = new ProgressDialog(context);
//                progressDialog.setMessage("Please wait...");
//                progressDialog.setTitle("Uploading");
                Toast.makeText(context, "Sending Request", Toast.LENGTH_SHORT).show();
                Log.d("TAGER", "Sending Request");
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


                if (sharedPreferences.getBoolean(SharedPreferencesUtils.prefsLoggedIn, false)) {

//                    Log.d("TAGER", "Firebase called");
                    OrderModel orderModel = new OrderModel(simpleDateFormat.format(calendar.getTime())
                            , code
                            , url
                            , prompt_remarks.getText().toString()
                            , "Pending"
                            , sharedPreferences.getString(SharedPreferencesUtils.prefsUserEmail, "")
                            , sharedPreferences.getString(SharedPreferencesUtils.prefsUserName, "")
                            , phoneEditText.getText().toString()
                    );

                    reference.child("orders")
                            .child(sharedPreferences.getString(SharedPreferencesUtils.prefsUserName, "") + code)
                            .setValue(orderModel)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        dialog.dismiss();

                                        Toast.makeText(context, "Thank You. We have received your requirement.", Toast.LENGTH_LONG).show();
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                                      @Override
                                                      public void onFailure(@NonNull Exception e) {
                                                          e.printStackTrace();
                                                          Log.d("TAGER", e.getMessage());
                                                      }
                                                  }
                            );

                } else {
                    dialog.dismiss();

                    Log.d("TAGER", "Failed");
                    Snackbar.make(phoneEditText, "Please log in to place an order.", Snackbar.LENGTH_LONG)
                            .setAction("Login", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    context.startActivity(new Intent(context, LoginActivity.class));
                                }
                            });
                    Toast.makeText(context, "Not sent.", Toast.LENGTH_SHORT).show();



                }


            }
        });


        /* LOAD IMAGE FROM URL HERE */


    }

    @Override
    public int getItemCount() {
        return victorianList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img1, img2, img3;

        public ViewHolder(View itemView) {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.jewel_image);
            img2 = (ImageView) itemView.findViewById(R.id.jewel_image1);
            img3 = (ImageView) itemView.findViewById(R.id.jewel_image2);
        }
    }
}
