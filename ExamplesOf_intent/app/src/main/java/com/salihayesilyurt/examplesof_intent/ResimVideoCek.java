package com.salihayesilyurt.examplesof_intent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

/**
 * Created by SalihaYesilyurt on 25.2.2016.
 * Kaynaklar: https://developer.android.com/training/camera/photobasics.html#TaskCaptureIntent
 * https://guides.codepath.com/android/Accessing-the-Camera-and-Stored-Media
 *
 */
public class ResimVideoCek implements View.OnClickListener {

    private Activity act;
    private Button btn;
    private ImageView img;
    private final int CAMERA_REQ_CODE = 1;
    private Uri imgUri;

    public ResimVideoCek(Activity activity,ImageView ImageView, Button button){

        // Context in amacı Activity yi kullanabilmek.
        //Context Activity ile değiltirildi
        act = activity;
        btn = button;
        img = ImageView;
        btn.setOnClickListener(this);
        imgUri=makeUri("resim");
    }


    @Override
    public void onClick(View v) {

        if (btn.getId() == v.getId()) {
            Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //Resim çekip getirecek olan kapalı intent
            //Kamerayı açtırıyor
            //Uri imageUri =makeUri("ressam");// imgUri yapınca gerek kalmadı

            if(imgUri!=null) {
                cameraintent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
                //Uri oluştur
            }

            act.startActivityForResult(cameraintent, CAMERA_REQ_CODE);
            //Con ile çağıramadık çünkü context ile arasında kalmış Context yerine activity alacagiz
        }

    }

    public Uri makeUri(String fileName) {
        //içine dosya ismini alacak, uri yapıp geri döndürecek
        //Uri aracı

        try {
            File hafizakarti = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File image = null;
            image = File.createTempFile(fileName, ".jpg", hafizakarti);
            return Uri.fromFile(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* finally {
            return null;
            //En son null döndüyoruz kod derlesin diye

        }*/
        return null;
    }

    public int getKod (){
        return CAMERA_REQ_CODE; //Diğer tarafa reg codu alabilcek
    }

    public Uri getUri () {
        return imgUri;
    }

    public void setResim(Bitmap resim) {
        img.setImageBitmap(resim);
    }
}
