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

public class Login_activity extends AppCompatActivity {

    private Button login , goToSignup;
    private EditText edt_email;
    private EditText edt_pass;
    private TextView forgot_pass;
    private DBHelper myDB;
    //*********
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        goToSignup = findViewById(R.id.go_to_signup);
        login = findViewById(R.id.btn_login2);
        forgot_pass = findViewById(R.id.tvForgotPass);
        edt_email = findViewById(R.id.edt_email);
        edt_pass = findViewById(R.id.edt_password);
        myDB = new DBHelper(this);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            finish();
            startActivity(new Intent(Login_activity.this,MainActivity2.class));
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myEmail = edt_email.getText().toString().trim();
                String myPassword = edt_pass.getText().toString().trim();
                if (myEmail.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your email", Toast.LENGTH_LONG).show();
                } else if (myPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your password", Toast.LENGTH_LONG).show();
                } else {

                    //login user
                    firebaseAuth.signInWithEmailAndPassword(myEmail,myPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                checkmailverification();
                            }else {
                                Toast.makeText(getApplicationContext(),"Email dose not exist",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });

        goToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_activity.this, Registeration.class);
                startActivity(intent);
            }
        });
        forgot_pass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2 = new Intent(Login_activity.this, forgot_password.class);
            startActivity(intent2);
        }
    });

    }
    private void checkmailverification(){
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser.isEmailVerified()==true){
            Toast.makeText(getApplicationContext(),"Logged In",Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(Login_activity.this,MainActivity2.class));

        }else{
            Toast.makeText(getApplicationContext(),"Verify your mail first",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();

        }
    }
}