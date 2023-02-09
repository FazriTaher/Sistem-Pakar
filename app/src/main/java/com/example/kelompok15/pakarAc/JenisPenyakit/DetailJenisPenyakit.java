package com.example.kelompok15.pakarAc.JenisPenyakit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kelompok15.pakarAc.R;


public class DetailJenisPenyakit extends AppCompatActivity {

    private static final String TAG = "DetailJenisPenyakit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jenis_penyakit);

        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();

        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(DetailJenisPenyakit.this, JenisPenyakitAct.class);
                startActivity(gotohome);
            }
        });
    }

    private void getIncomingIntent(){

        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("nama_penyakit") && getIntent().hasExtra("definisi") && getIntent().hasExtra("gejala") && getIntent().hasExtra("solusi")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String NamaPenyakit = getIntent().getStringExtra("nama_penyakit");
            String DefPenyakit = getIntent().getStringExtra("definisi");
            String GejPenyakit = getIntent().getStringExtra("gejala");
            String SolPenyakit = getIntent().getStringExtra("solusi");

            setImage(NamaPenyakit, DefPenyakit, GejPenyakit, SolPenyakit);
        }
    }


    private void setImage(String NamaPenyakit, String DefPenyakit, String GejPenyakit, String SolPenyakit){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView nama_penyakit = findViewById(R.id.tv_judul_det);
        nama_penyakit.setText(NamaPenyakit);

        TextView def = findViewById(R.id.tv_definisi_det);
        def.setText(DefPenyakit);

        TextView gej = findViewById(R.id.tv_gejala_det);
        gej.setText(GejPenyakit);

        TextView sol = findViewById(R.id.tv_solusi_det);
        sol.setText(SolPenyakit);

    }
}
