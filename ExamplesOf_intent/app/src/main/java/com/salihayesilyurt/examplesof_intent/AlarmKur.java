package com.salihayesilyurt.examplesof_intent;

import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by SalihaYesilyurt on 25.2.2016.
 */
public class AlarmKur implements View.OnClickListener{

    private EditText etHour;
    private EditText etMinute;
    private Button btnAlarmKur;
    String alarmText;
    int hour;
    int minute;
    Context context;

    public AlarmKur(Context c, EditText hour, EditText minute,Button button){

        context = c;
        etHour = hour;
        etMinute = minute;
        btnAlarmKur = button;

        btnAlarmKur.setOnClickListener(this);
    }

    public void createAlarm(Context c,String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(c.getPackageManager()) != null) {
            c.startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        alarmText = "Hadi Uyan";

        try {
            hour = Integer.valueOf(etHour.getText().toString());
            minute = Integer.valueOf(etMinute.getText().toString());

        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }
        createAlarm(context,alarmText,hour,minute);
    }
}
