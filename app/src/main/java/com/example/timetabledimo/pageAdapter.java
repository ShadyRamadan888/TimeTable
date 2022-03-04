package com.example.timetabledimo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageAdapter extends FragmentPagerAdapter {
    int tabcount;
    public pageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new fall();
            case 1:return new ftabSaturday();
            case 2:return new ftabSunday();
            case 3:return new ftabMonday();
            case 4:return new ftabTuesday();
            case 5:return new ftabWednesday();
            case 6:return new ftabThursday();
            case 7:return new ftabFriday();
            default:return null;

        }
    }

        @Override
        public int getCount() {
            return tabcount;
        }

}