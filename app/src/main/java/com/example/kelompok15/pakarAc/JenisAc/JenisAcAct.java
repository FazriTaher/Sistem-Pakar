package com.example.kelompok15.pakarAc.JenisAc;

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

public class JenisAcAct extends AppCompatActivity {

    private static final String TAG = "JenisAcAct";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_ac);

        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();

        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(JenisAcAct.this, HomeAct.class);
                startActivity(gotohome);
            }
        });
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://crossmedial.net/wp-content/uploads/2019/09/3.-AC-split-640x422.jpg");
        mNames.add("AC SPLIT");
        mDescription.add("AC Split adalah salah satu jenis AC yang paling sering ditemui di Indonesia, dengan 2 komponen utama yaitu: unit pendingin yang biasanya diletakkan atau dipasang di dalam ruangan dan juga unit pembuang panas berbentuk persegi yang biasanya diletakkan di luar ruangan.\n");

        mImageUrls.add("https://s3.bukalapak.com/img/3724490213/large/image.jpg");
        mNames.add("AC WINDOW");
        mDescription.add("AC ini merupakan salah satu jenis AC tipe lama dan bisa dibilang jarang ditemui lagi di jaman yang modern ini. AC Window, sesuai dengan namanya memiliki bentuk yang kotak dan juga berukuran lumayan besar dibandingkan dengan AC yang kita gunakan pada saat ini.\n");

        mImageUrls.add("https://i0.wp.com/serviceacjogja.pro/wp-content/uploads/2016/11/Cassette-Type-Air-Conditioner.jpg");
        mNames.add("AC CENTRAL");
        mDescription.add("AC ini memiliki ukuran yang besar dan memiliki bentuk seperti corong yang menempel di langit-langit. Walau mungkin kita melihat mereka menempel di langit-langit, namun AC Central memiliki sebuah mesin utama yang bertugas untuk mengatur sirkulasi udara dan suhu ruangan.\n");

        mImageUrls.add("https://www.gree.id/userfiles/gallery/5fbcd66701c4a.jpg");
        mNames.add("AC TOWER");
        mDescription.add("AC Tower ini kurang lebih sama dengan AC Split, namun memiliki perbedaan yaitu AC Tower lebih besar ukurannya. Jika AC Split diletakkan di dinding bagian atas, AC Tower ini diletakkan di lantai dan memiliki bentuk hampir seperti lemari.\n");

        mImageUrls.add("https://symphonyac.com/wp-content/uploads/2022/08/Screenshot_20220615-084325_Adobe-Acrobat-300x188.jpg");
        mNames.add("AC CASSETTE");
        mDescription.add("AC Cassette yang sekarang juga mudah kita jumpai. AC jenis Cassette ini sebenarnya hampir sama juga sistem kerjanya dengan AC Split dan juga AC Tower atau Floor Standing yang baru saja kami bahas tadi.\n");



        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_list_jenis_kelinci);
        AdapterJenisAc adapter = new AdapterJenisAc(this, mNames, mImageUrls, mDescription);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

//    public void onBackPressed() {
//
//    }

}
