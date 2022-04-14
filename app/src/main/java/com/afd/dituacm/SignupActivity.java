package com.afd.dituacm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {

    EditText nameEt,emailEt,passEt,mobEt;
    Button BtnJoin;
    private FirebaseAuth mAuth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");
        progressDialog.setCancelable(false);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        nameEt = findViewById(R.id.name);
        emailEt = findViewById(R.id.email);
        passEt = findViewById(R.id.password);
        mobEt = findViewById(R.id.phone);
        BtnJoin = findViewById(R.id.sign_up);



        TextView myText = findViewById(R.id.loginText);


        myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        BtnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                signup();
            }
        });
    }

    private void signup() {
        String email = emailEt.getText().toString().trim();
        String password = passEt.getText().toString().trim();
        String name = nameEt.getText().toString().trim();
        String mobile = mobEt.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(name) || TextUtils.isEmpty(password) || TextUtils.isEmpty(mobile)) {
            progressDialog.dismiss();
            Toast.makeText(this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
        } else if(!email.matches(emailPattern)){
            progressDialog.dismiss();
            Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
        } else if(mobile.length()<10){
            progressDialog.dismiss();
            Toast.makeText(this, "Enter Valid mobile Number", Toast.LENGTH_SHORT).show();
        }else if(password.length()<8){
            progressDialog.dismiss();
            Toast.makeText(this, "Password should be atleast 8 characters long", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        DatabaseReference reference = database.getReference().child("All Users").child(mAuth.getUid());

                        AllMembers allMembers = new AllMembers(mAuth.getUid(),name,email,mobile);
                        reference.setValue(allMembers).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    progressDialog.dismiss();
                                    sendtomain();
                                } else {
                                    progressDialog.dismiss();
                                    Toast.makeText(SignupActivity.this, "Error in Registration"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            sendtomain();
        }
    }

    private void sendtomain() {
        Intent intent = new Intent(SignupActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
