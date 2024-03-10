package com.example.event_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class viewEvent extends AppCompatActivity {

    private ArrayList<eventModal> eventModalArrayList;
    private DBHandler dbHandler;
    private Adapter eventAdapter;
    private RecyclerView eventRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        eventModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(viewEvent.this);


        eventModalArrayList = dbHandler.readEvents();


        eventAdapter = new Adapter(eventModalArrayList, viewEvent.this);
        eventRv = findViewById(R.id.recyclerView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewEvent.this, RecyclerView.VERTICAL, false);
        eventRv.setLayoutManager(linearLayoutManager);

        eventRv.setAdapter(eventAdapter);

    }
}