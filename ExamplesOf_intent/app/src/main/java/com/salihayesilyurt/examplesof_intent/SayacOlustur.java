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
public class SayacOlustur implements View.OnClickListener {
    private EditText etSayac;
    private Button btnSayac;
    Context context;
    String message;
    int seconds;

    public SayacOlustur(Context c, EditText editText, Button button) {

        context = c;
        etSayac = editText;
        btnSayac = button;

        btnSayac.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        message ="Sayac olusturuldu";
        //girilecek saniye degeri edittext ile kullanıcıdan istendi. O da Intger a çevrilerek
        //startTimer metodunun 3. parametresi olarak verildi.
        seconds = Integer.valueOf(etSayac.getText().toString());
        startTimer(context,message,seconds);


    }

    public void startTimer(Context c,String message, int seconds) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
