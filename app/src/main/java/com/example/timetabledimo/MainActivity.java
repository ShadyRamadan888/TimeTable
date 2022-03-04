package com.example.timetabledimo;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Days> daysList = new ArrayList<Days>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillDays();
        recyclerView=findViewById(R.id.my_recycle);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyDaysAdapter(daysList,MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void fillDays() {

        Days d0=new Days("Saturday",LocalDate.now().plusDays(4).toString());
        Days d1=new Days("Sunday",LocalDate.now().plusDays(5).toString());
        Days d2=new Days("Monday",LocalDate.now().plusDays(6).toString());
        Days d3=new Days("Tuesday",LocalDate.now().toString());
        Days d4=new Days("Wednesday",LocalDate.now().plusDays(1).toString());
        Days d5=new Days("Thursday",LocalDate.now().plusDays(2).toString());
        Days d6=new Days("Friday",LocalDate.now().plusDays(3).toString());
        daysList.addAll(Arrays.asList(new Days[]{d0,d1,d2,d3,d4,d5,d6}));
        Collections.sort(daysList, new Comparator<Days>() {
            @Override
            public int compare(Days days, Days t1) {
                return LocalDate.parse(days.getDate()).compareTo(LocalDate.parse(t1.getDate()));
            }
        });
    }
}