package com.example.event_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addEvent extends AppCompatActivity {

    private EditText eventNameEdt, eventDateEdt, eventTimeEdt, eventNumber1Edt, eventNumber2Edt;
    public Button addBtn;
    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        eventNameEdt = findViewById(R.id.txtUname);
        eventDateEdt = findViewById(R.id.txtUdate);
        eventTimeEdt = findViewById(R.id.txtUtime);
        eventNumber1Edt = findViewById(R.id.txtUCall1);
        eventNumber2Edt = findViewById(R.id.txtUCall2);
        addBtn = findViewById(R.id.btnAdd);


        dbHandler = new DBHandler(addEvent.this);


        addBtn.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String eventName = eventNameEdt.getText().toString();
                String eventDate = eventDateEdt.getText().toString();
                String eventTime = eventTimeEdt.getText().toString();
                String eventNumber1 = eventNumber1Edt.getText().toString();
                String eventNumber2 = eventNumber2Edt.getText().toString();


                if (eventName.isEmpty() && eventDate.isEmpty() && eventTime.isEmpty() && eventNumber1.isEmpty() && eventNumber2.isEmpty()) {
                    Toast.makeText(addEvent.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewEvent(eventName, eventDate, eventTime, eventNumber1, eventNumber2);


                Toast.makeText(addEvent.this, "Event has been saved.", Toast.LENGTH_SHORT).show();
                eventNameEdt.setText("");
                eventDateEdt.setText("");
                eventTimeEdt.setText("");
                eventNumber1Edt.setText("");
                eventNumber2Edt.setText("");



                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(eventNumber1, null, eventName , null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Message Sending Fail!", Toast.LENGTH_LONG).show();
                }

            }


        });

    }
}


