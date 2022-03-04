package com.example.timetabledimo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registeration extends AppCompatActivity {

    private TextView tv_login;
    private EditText username;
    private EditText edt_email;
    private EditText edt_password;
    private EditText repassword;
    private Button btn_signup;
    DBHelper DB;

    //firebase
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        setupVariables();       //Calling function to set up variables
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Login_activity.class);
                startActivity(intent);
            }
        });
        //Registration
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String my_username = username.getText().toString();
                String my_email = edt_email.getText().toString();
                String my_password = edt_password.getText().toString();
                String my_confirm_password = repassword.getText().toString();
                if (my_username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please enter user name", Toast.LENGTH_LONG).show();
                } else if (my_email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please enter email", Toast.LENGTH_LONG).show();
                } else if (my_password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please enter password", Toast.LENGTH_LONG).show();
                } else if (my_confirm_password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please confirm password", Toast.LENGTH_LONG).show();
                } else if (my_password.length()<7){
                    Toast.makeText(getApplicationContext(), "Password should be greater than 7", Toast.LENGTH_LONG).show();
                }
                else {
                    //register to firebase
                    firebaseAuth.createUserWithEmailAndPassword(my_email,my_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
                                sendEmailVerification();
                            }else{
                                Toast.makeText(getApplicationContext(), "Failed to register", Toast.LENGTH_LONG).show();

                            }

                        }
                    });
                }

            }

        });
    }
    private void sendEmailVerification(){
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(), "Verification email is sent, Verify and login again", Toast.LENGTH_LONG).show();
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(Registeration.this,Login_activity.class));
                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(), "Failed to send verification email", Toast.LENGTH_LONG).show();

        }
    }

    public void setupVariables(){

        username=findViewById(R.id.edt_username);
        edt_email=findViewById(R.id.edt_email_signup);
        edt_password=findViewById(R.id.edt_password_signup);
        repassword=findViewById(R.id.edt_confirm_password);
        btn_signup=findViewById(R.id.btn_signup);
        tv_login = findViewById(R.id.tv_login);
        DB=new DBHelper(this);

        //*******
        firebaseAuth=FirebaseAuth.getInstance();

    }
}