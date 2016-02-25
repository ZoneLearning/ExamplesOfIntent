package com.salihayesilyurt.examplesof_intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etHour;
    private EditText etMinute;
    private Button btnAlarmKur;

    private EditText etSayac;
    private Button btnSayac;

    private Button btnEtkinlikOlustur;
    private Button btnResimVideoCek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        //AlarmKur sınıfından nesne oluşturduk. Farklı bir class'a gonderdiğimiz için bu sınıfın context'ini this olarak gönderiyoruz.
        //xml ile bağladıgımız view ları bu sınıfa parametre olarajk gönderiyoruz. AlarmKur constructor ile bunları oaraya atıyoruz.
        AlarmKur alarmKur = new AlarmKur(this, etHour, etMinute, btnAlarmKur);
/*----------------------------------------------------------------------------------*/
        //SayacOlustur sınıfı 3 parameteli constructor'una gidiyor.
        SayacOlustur sayacOlustur = new SayacOlustur(this, etSayac, btnSayac);
/*----------------------------------------------------------------------------------*/
        EtkinlikOlustur etkinlikOlustur = new EtkinlikOlustur(this, btnEtkinlikOlustur);
        //ResimVideoCek resimvideocek = new ResimVideoCek(this,btnResimVideoCek);
    }

    private void initialize() {

        etHour = (EditText) findViewById(R.id.et_hour);
        etMinute = (EditText) findViewById(R.id.et_minute);
        btnAlarmKur = (Button) findViewById(R.id.btn_alarmkur);
        etSayac = (EditText) findViewById(R.id.et_sayac);
        btnSayac = (Button) findViewById(R.id.btn_sayac);
        btnEtkinlikOlustur = (Button) findViewById(R.id.btn_etkinlikolustur);
        btnResimVideoCek = (Button) findViewById(R.id.btnFotoVideo);
    }

}
