package com.example.timetabledimo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    TabItem tabItemAll,tabItem1,tabItem2,tabItem3,tabItem4,tabItem5,tabItem6,tabItem7;
    TabLayout tabLayout;
    ViewPager viewPager;
    Button btn_add;
    pageAdapter pagerAdapter;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setUPVariables();
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6||tab.getPosition()==7) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, AddOne.class);
                startActivity(intent);
            }
        });
        Button popupbuttonlogout=findViewById(R.id.menupoplogout);
        popupbuttonlogout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu =new PopupMenu(view.getContext(),view);
                popupMenu.setGravity(Gravity.END);
                popupMenu.getMenu().add("Logout").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        firebaseAuth.signOut();
                        startActivity(new Intent(MainActivity2.this,Login_activity.class));
                        finish();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }


    void setUPVariables(){
        tabLayout=findViewById(R.id.tabLayout1);
        tabItemAll=findViewById(R.id.tabAll);
        tabItem1=findViewById(R.id.tab1);
        tabItem2=findViewById(R.id.tab2);
        tabItem3=findViewById(R.id.tab3);
        tabItem4=findViewById(R.id.tab4);
        tabItem5=findViewById(R.id.tab5);
        tabItem6=findViewById(R.id.tab6);
        tabItem7=findViewById(R.id.tab7);
        btn_add=findViewById(R.id.btn_add);
        viewPager=(ViewPager) findViewById(R.id.v_pager);
        pagerAdapter=new pageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        firebaseAuth=FirebaseAuth.getInstance();
    }
}