package com.example.kelompok15.pakarAc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.kelompok15.pakarAc.JenisAc.JenisAcAct;
import com.example.kelompok15.pakarAc.JenisPenyakit.JenisPenyakitAct;
import com.example.kelompok15.pakarAc.Konsultasi.KonsultasiAct;
import com.example.kelompok15.pakarAc.R;

import static android.R.attr.x;
import static android.R.attr.y;

import androidx.appcompat.app.AppCompatActivity;

public class HomeAct extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        LinearLayout btn_konsultasi = findViewById(R.id.btn_konsultasi);
        btn_konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotokonsul = new Intent(HomeAct.this, KonsultasiAct.class);
                startActivity(gotokonsul);
            }
        });

        LinearLayout btn_jenis_kelinci = findViewById(R.id.btn_jenis_kelinci);
        btn_jenis_kelinci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojenis = new Intent(HomeAct.this, JenisAcAct.class);
                startActivity(gotojenis);
            }
        });

        LinearLayout btn_penyakit = findViewById(R.id.btn_penyakit);
        btn_penyakit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent gotopenyakit = new Intent(getApplicationContext(), JenisPenyakitAct.class);
                startActivity(gotopenyakit);
                Toast.makeText(HomeAct.this, "Ketuk Nama Kerusakan untuk Menampilkan Detail Informasi Kerusakan", Toast.LENGTH_LONG).show();
            }
        });


        LinearLayout btn_klinik = findViewById(R.id.btn_klinik);
        btn_klinik.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String uri = "geo:" + x + "," + y + "?q=Servis Ac dan peralatan panel Sorong";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
            }
        });

        LinearLayout about = findViewById(R.id.btn_tentang);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AboutAct.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Yakin mau keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed yes
                finishAffinity();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed no
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
