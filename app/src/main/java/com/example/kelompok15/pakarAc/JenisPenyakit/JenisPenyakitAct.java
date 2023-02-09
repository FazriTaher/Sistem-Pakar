package com.example.kelompok15.pakarAc.JenisPenyakit;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelompok15.pakarAc.HomeAct;
import com.example.kelompok15.pakarAc.R;

import java.util.ArrayList;

public class JenisPenyakitAct extends AppCompatActivity {

    private static final String TAG = "JenisAcAct";

    //vars
    private ArrayList<String> mNamaPenyakit = new ArrayList<>();
    private ArrayList<String> mDefinisi = new ArrayList<>();
    private ArrayList<String> mGejala = new ArrayList<>();
    private ArrayList<String> mSolusi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_penyakit);

        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();

        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(JenisPenyakitAct.this, HomeAct.class);
                startActivity(gotohome);
            }
        });
    }

    private void initImageBitmaps(){
       // Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mNamaPenyakit.add("Proses Pendinginan Kurang maksimal");
        mDefinisi.add("Pendingin udara jika tidak dirawat tentu akan berkurang kemampuan pendinginannya dan hanya akan membuat penggunaan daya listrik meningkat.\n");
        mGejala.add("1.\tTekanan freon kurang.\n" +
                "2.\tBocor pada pipa sambungan.\n" +
                "3.\tKotor pada unit indoor.\n" +
                "4.\tAdanya Frozen pada pipa sambungan.\n");
        mSolusi.add("Memastikan kebocoran pada pipa sambungan dengan air sabun, jika keluar gelembung, maka lakukanlah pemvakuman.\n");

        mNamaPenyakit.add("Kerusakan Pada Indoor Unit");
        mDefinisi.add("Bagian penting dari indoor unit yang mengubah gas refrigeran menjadi cairan refrigeran. Kerusakan pada kompresor dapat menyebabkan sistem AC tidak berfungsi dengan baik atau tidak berfungsi sama sekali.\n");
        mGejala.add("1.\tKerusakan kipas swing Indoor.\n" +
                "2.\tAir menetes pada indoor.\n" +
                "3.\tSuara bising pada unit indoor.\n");
        mSolusi.add("Mengganti kapasitor baru, Menbersikan kotoran pada saluran air dengan cara di vakum jika diperlukan lakukan servis ac, Mengganti buring atau bering yang baru.\n");

        mNamaPenyakit.add("Kerusakan Pada Outdoor Unit");
        mDefinisi.add("Kerusakan AC ini perlu bantuan jasa teknisi AC untuk mengatasinya seperti kerusakan pada bagian kompresor.\n");
        mGejala.add("1.\tKerusakan pada Capasitor outdoor.\n" +
                "2.\tSuara bising pada unit Outdoor.\n" +
                "3.\tKompresor macet.\n");
        mSolusi.add("Mengganti Capasitornya, Mengganti keret dudukan dan mencuci kobdesor, Memperbaiki overloadnya.\n");

        mNamaPenyakit.add("Kerusakan Pada Komponen Kelistrikkan");
        mDefinisi.add("\n" +
                "Komponen listrik yaitu benda yang menjadi bagian pendukung suatu rangkaian listrik yang dapat bekerja sesuai dengan kegunaannya.\n");
        mGejala.add("1.\tAdanya short terminal indoor dengan outdoor.\n" +
                "2.\tPermasalahan pada Wiring Diagram.\n");
        mSolusi.add("Mengganti Capasitornya, Mengganti capasitor, Mengganti keret dudukan dan mencuci kobdesor, Memperbaiki overloadnya.\n");



        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.rv_list_jenis_penyakit);
        AdapterJenisPenyakit adapter = new AdapterJenisPenyakit(this, mNamaPenyakit, mDefinisi, mGejala, mSolusi);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
