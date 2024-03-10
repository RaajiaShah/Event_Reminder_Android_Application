package com.example.event_reminder;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<eventModal> eventModalArrayList;
    private Context context;

    public Adapter(ArrayList<eventModal> eventModalArrayList, Context context) {
        this.eventModalArrayList = eventModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position) {

        eventModal modal = eventModalArrayList.get(position);
        holder.eventNameCV.setText(modal.getEventName());
        holder.eventDateCV.setText(modal.getEventDate());
        holder.eventTimeCV.setText(modal.getEventTime());
        holder.eventNumber1CV.setText(modal.getEventNumber1());
        holder.eventNumber2CV.setText(modal.getEventNumber2());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, updateEvent.class);


                i.putExtra("name", modal.getEventName());
                i.putExtra("date", modal.getEventDate());
                i.putExtra("time", modal.getEventTime());
                i.putExtra("number1", modal.getEventNumber1());
                i.putExtra("number2", modal.getEventNumber2());

                context.startActivity(i);
            }
        });
    }

    public int getItemCount() {

        return eventModalArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView eventNameCV, eventDateCV, eventTimeCV, eventNumber1CV , eventNumber2CV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eventNameCV = itemView.findViewById(R.id.eventname);
            eventDateCV = itemView.findViewById(R.id.eventdate);
            eventTimeCV = itemView.findViewById(R.id.eventtime);
            eventNumber1CV = itemView.findViewById(R.id.addpeople1);
            eventNumber2CV = itemView.findViewById(R.id.addpeople2);
        }


    }
}
