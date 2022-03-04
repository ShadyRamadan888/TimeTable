package com.example.timetabledimo;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOne extends AppCompatActivity {
    Button btn_add_on;
    List<Days>daysList;
    ////*******
    String[] strings ={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> stringArrayAdapter;

    EditText edt_title_add;
    TextView edt_date_one;
    Button btn_add_one;
    FirebaseAuth firebaseAuth ;
    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;

    //date
    TextView tvTimer;
    int t1Hour,t1Minute;
    DatePickerDialog.OnDateSetListener setListener;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_one);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_days, strings);
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        btn_add_on=findViewById(R.id.btn_add_one);
        tvTimer=findViewById(R.id.tv_timer1);
        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog =new TimePickerDialog(
                        AddOne.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                t1Hour=i;
                                t1Minute=i1;
                                Calendar calendar=Calendar.getInstance();
                                calendar.set(0,0,0,t1Hour,t1Minute);
                                tvTimer.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        },12,0,false
                );
                timePickerDialog.updateTime(t1Hour,t1Minute);
                timePickerDialog.show();
            }
        });

        setVariablesToAddOne();
        btn_add_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=edt_title_add.getText().toString().trim();
                String date=tvTimer.getText().toString().trim();
                String day=autoCompleteTextView.getText().toString().trim();
                if (title.isEmpty() || date.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Both field are require",Toast.LENGTH_SHORT).show();
                }else if(day.equals("Saturday".trim())) {
                    DocumentReference documentReference=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("MyTasks").document();
                    DocumentReference documentReference2=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("Saturday").document();
                    Map<String,Object> task=new HashMap<>();
                        task.put("title",title);
                        task.put("date",date);
                        //task.put("day",day);
                        documentReference.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                            @Override
                            public void onSuccess(Void aVoid){
                                Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AddOne.this,MainActivity2.class));

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                            }
                        });
                    documentReference2.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else if (day.equals("Sunday".trim())){
                    DocumentReference documentReference=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("MyTasks").document();
                    DocumentReference documentReference2=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("Sunday").document();
                    Map<String,Object> task=new HashMap<>();
                    task.put("title",title);
                    task.put("date",date);
                    //task.put("day",day);
                    documentReference.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                    documentReference2.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else if(day.equals("Monday".trim())){
                    DocumentReference documentReference=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("MyTasks").document();
                    DocumentReference documentReference2=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("Monday").document();
                    Map<String,Object> task=new HashMap<>();
                    task.put("title",title);
                    task.put("date",date);
                    //task.put("day",day);
                    documentReference.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                    documentReference2.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });

                }else if (day.equals("Thursday")){
                    DocumentReference documentReference=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("MyTasks").document();
                    DocumentReference documentReference2=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("Thursday").document();
                    Map<String,Object> task=new HashMap<>();
                    task.put("title",title);
                    task.put("date",date);
                    //task.put("day",day);
                    documentReference.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                    documentReference2.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if(day.equals("Wednesday".trim())){
                    DocumentReference documentReference=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("MyTasks").document();
                    DocumentReference documentReference2=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("Wednesday").document();
                    Map<String,Object> task=new HashMap<>();
                    task.put("title",title);
                    task.put("date",date);
                    //task.put("day",day);
                    documentReference.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                    documentReference2.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if (day.equals("Tuesday")){
                    DocumentReference documentReference=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("MyTasks").document();
                    DocumentReference documentReference2=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("Tuesday").document();
                    Map<String,Object> task=new HashMap<>();
                    task.put("title",title);
                    task.put("date",date);
                    //task.put("day",day);
                    documentReference.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                    documentReference2.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else if (day.equals("Friday")){
                    DocumentReference documentReference=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("MyTasks").document();
                    DocumentReference documentReference2=firebaseFirestore.collection("tasks").document(firebaseUser.getUid()).collection("Friday").document();
                    Map<String,Object> task=new HashMap<>();
                    task.put("title",title);
                    task.put("date",date);
                    //task.put("day",day);
                    documentReference.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                    documentReference2.set(task).addOnSuccessListener(new OnSuccessListener<Void>(){
                        @Override
                        public void onSuccess(Void aVoid){
                            Toast.makeText(getApplicationContext(),"Task Created Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddOne.this,MainActivity2.class));

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Task not created",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }

    void  setVariablesToAddOne(){
        edt_date_one=findViewById(R.id.tv_timer1);
        edt_title_add=findViewById(R.id.edt_title_add);
        btn_add_one=findViewById(R.id.btn_add_one);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}

