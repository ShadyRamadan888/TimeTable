package com.example.timetabledimo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyDaysAdapter extends RecyclerView.Adapter<MyDaysAdapter.ViewHolder> {
    List<Days> days;
    Context context;
    RecycleViewOnClick recycleViewOnClick;

    public MyDaysAdapter(List<Days> days, Context context) {
        this.days = days;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.days_structure,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.dayName.setText(days.get(position).getName());
        holder.date.setText(days.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayName;
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayName=itemView.findViewById(R.id.tv_day);
            date=itemView.findViewById(R.id.tv_date);

        }

    }
}
