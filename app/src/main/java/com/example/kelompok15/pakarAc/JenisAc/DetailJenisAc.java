package com.example.kelompok15.pakarAc.JenisAc;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.kelompok15.pakarAc.R;

public class DetailJenisAc extends AppCompatActivity {

    private static final String TAG = "DetailJenisAc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jenis_ac);

        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();

        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(DetailJenisAc.this, JenisAcAct.class);
                startActivity(gotohome);
            }
        });
    }

    private void getIncomingIntent(){

        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("desc_bunny")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String descBunny = getIntent().getStringExtra("desc_bunny");

            setImage(imageUrl, imageName, descBunny);
        }
    }


    private void setImage(String imageUrl, String imageName, String descBunny){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.tv_judul_det);
        name.setText(imageName);

        TextView descbunny = findViewById(R.id.tv_definisi_det);
        descbunny.setText(descBunny);

        ImageView image = findViewById(R.id.iv_image_det);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

}
