package com.salihayesilyurt.examplesof_intent;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

import java.util.GregorianCalendar;

/**
 * Created by SalihaYesilyurt on 25.2.2016.
 */
public class EtkinlikOlustur implements View.OnClickListener {
    Context con;
    Button btnEtkinlik;
    String title;
    String description;
    String location;
    int yil, ay, gun;


    public EtkinlikOlustur(Context c, Button button) {
        con = c;
        btnEtkinlik = button;
        btnEtkinlik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        title = " Pijama partisi";
        description = "Pijama partimize bekleriz. :) ";
        location = "Bizim ev";
        yil = 2016;
        ay = 2;
        gun = 5;


        Intent callIntent = new Intent(Intent.ACTION_INSERT);
        callIntent.setType("vnd.android.cursor.item/event");
        callIntent.putExtra(CalendarContract.Events.TITLE, title);
        callIntent.putExtra(CalendarContract.Events.DESCRIPTION, description);
        callIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, location);

        GregorianCalendar callDate = new GregorianCalendar(yil,ay,gun);
        callIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY,true);
        callIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,callDate.getTimeInMillis());
        callIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, callDate.getTimeInMillis()*5);
        con.startActivity(callIntent);
    }
}
