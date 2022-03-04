package com.example.timetabledimo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {

    private EditText edt_forgot_pass;
    private Button btn_reset_pass;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edt_forgot_pass=findViewById(R.id.edt_forgot_pass);
        btn_reset_pass=findViewById(R.id.btn_reset_pass);
        firebaseAuth=FirebaseAuth.getInstance();

        btn_reset_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=edt_forgot_pass.getText().toString().trim();
                if(mail.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter your email first",Toast.LENGTH_SHORT).show();
                }
                else{

                    // we have to send password

                    firebaseAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Mail sent,you can recover your password using mail",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(forgot_password.this,Login_activity.class));
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Email dose not exist",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });

    }
}