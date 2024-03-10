package com.example.event_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateEvent extends AppCompatActivity {

    private EditText eventNameEdt, eventDateEdt , eventTimeEdt  , eventNumber1Edt, eventNumber2Edt ;
    private Button btnUpdate, btnDelete;
    private DBHandler dbHandler;
    String eventName, eventDate, eventTime, eventNum1 , eventNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_event);


        eventNameEdt = findViewById(R.id.txtUname);
        eventDateEdt = findViewById(R.id.txtUdate);
        eventTimeEdt = findViewById(R.id.txtUtime);
        eventNumber1Edt = findViewById(R.id.txtUCall1);
        eventNumber2Edt = findViewById(R.id.txtUCall2);
        btnUpdate = findViewById(R.id.updateBtn);
        btnDelete = findViewById(R.id.btnAdd);

        dbHandler = new DBHandler(updateEvent.this);


        eventName = getIntent().getStringExtra("name");
        eventDate = getIntent().getStringExtra("date");
        eventTime = getIntent().getStringExtra("time");
        eventNum1 = getIntent().getStringExtra("number1");
        eventNum2 = getIntent().getStringExtra("number2");


        eventNameEdt.setText(eventName);
        eventDateEdt.setText(eventDate);
        eventTimeEdt.setText(eventTime);
        eventNumber1Edt.setText(eventNum1);
        eventNumber2Edt.setText(eventNum2);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbHandler.updateEvent(eventName, eventNameEdt.getText().toString(), eventDateEdt.getText().toString(), eventTimeEdt.getText().toString(), eventNumber1Edt.getText().toString(), eventNumber2Edt.getText().toString());


                Toast.makeText(updateEvent.this, "Event Updated..", Toast.LENGTH_SHORT).show();


                Intent i = new Intent(updateEvent.this, MainActivity.class);
                startActivity(i);
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.deleteEvent(eventName);
                Toast.makeText(updateEvent.this, "Deleted the event", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(updateEvent.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
