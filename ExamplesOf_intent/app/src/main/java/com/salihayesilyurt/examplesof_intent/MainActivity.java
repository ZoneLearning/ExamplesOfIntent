package com.salihayesilyurt.examplesof_intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText etHour;
    private EditText etMinute;
    private Button btnAlarmKur;

    private EditText etSayac;
    private Button btnSayac;

    private Button btnEtkinlikOlustur;
    private Button btnResimVideoCek;

    private ImageView img;
    private Button btnResimCek;
    private ResimVideoCek resimVideoCek;

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
/*----------------------------------------------------------------------------------*/
        resimVideoCek = new ResimVideoCek(this, img, btnResimVideoCek);
    }

    private void initialize() {

        etHour = (EditText) findViewById(R.id.et_hour);
        etMinute = (EditText) findViewById(R.id.et_minute);
        btnAlarmKur = (Button) findViewById(R.id.btn_alarmkur);
        etSayac = (EditText) findViewById(R.id.et_sayac);
        btnSayac = (Button) findViewById(R.id.btn_sayac);
        btnEtkinlikOlustur = (Button) findViewById(R.id.btn_etkinlikolustur);
        btnResimVideoCek = (Button) findViewById(R.id.btnFotoVideo);
        btnResimCek = (Button) findViewById(R.id.btnFotoVideo);
        img = (ImageView) findViewById(R.id.imgFotoVideo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resimVideoCek.getKod() == requestCode && resultCode == RESULT_OK) {
            //  reqCode == CAMERA_REQ_CODE && resCode ==)
            //req 1 dönüyor eger kameramdan donenle 1se o zaman doğru
            //Kaydete bastı mı yoksa direkt mi çıktı sorununu .çzmek için
            //Bitmap thumb = (Bitmap)intent.getExtras().get("data");
            //rsm.setResim(thumb);

            Bitmap thump = null;
            try {
                thump = MediaStore.Images.Media.getBitmap(getContentResolver(), resimVideoCek.getUri());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            resimVideoCek.setResim(thump);
        }
    }
}
