package com.example.kelompok15.pakarAc.Konsultasi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kelompok15.pakarAc.Database;
import com.example.kelompok15.pakarAc.HomeAct;
import com.example.kelompok15.pakarAc.R;

import java.util.ArrayList;
import java.util.List;

public class KonsultasiAct extends AppCompatActivity {

    private gejalapenyakit data;
    private Database datagejala;
    private SQLiteDatabase db;
    private TextView gejala;
    private Cursor gejalaCursor;
    private String kode_main;
    private String kode_tidak;
    private String kode_ya;
    private String mulai;
    private String selesai;
    private Button lanjut;
    private ImageView btn_back;
    private RadioButton radioButton_tidak;
    private RadioButton radioButton_ya;
    private RadioGroup radioGroup;
    private String result;
    private List<String> arrDiagnosa = new ArrayList<String>();
    String strDiagnosa = "";
    Double nilai = 0.0d;

    public KonsultasiAct() {
        db = null;
        gejalaCursor = null;
        datagejala = null;
        data = new gejalapenyakit();
        result = "";
        kode_ya = "";
        kode_tidak = "";
        kode_main = "";
        mulai = "";
        selesai = "";
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);

        gejala = findViewById(R.id.tv_pertanyaan);
        btn_back = findViewById(R.id.btn_back);
        lanjut = findViewById(R.id.btn_next);
        datagejala = new Database(this);
        db = datagejala.getWritableDatabase();
        datagejala.createTable(db);
        datagejala.generateData(db);
        showText();
        radioButton_ya = findViewById(R.id.btn_ya);
        radioButton_tidak = findViewById(R.id.btn_tidak);
        radioGroup = findViewById(R.id.radiogroup);

        lanjut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (radioButton_ya.isChecked()) {

                    getYA();
                } else if (radioButton_tidak.isChecked()) {
                    getTIDAK();
                } else {
                    Toast.makeText(KonsultasiAct.this, "Pilih ya atau tidak", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(KonsultasiAct.this, HomeAct.class);
                startActivity(gotohome);
            }
        });
    }


    public void showText() {
        gejalaCursor = db.rawQuery("SELECT * FROM gejala where mulai = 'Y'", null);
        if (gejalaCursor.moveToFirst()) {
            result = gejalaCursor.getString(1);
            kode_ya = gejalaCursor.getString(2);
            kode_tidak = gejalaCursor.getString(3);
            mulai = gejalaCursor.getString(4);
            selesai = gejalaCursor.getString(5);
            kode_main = gejalaCursor.getString(0);
            while (!gejalaCursor.isAfterLast()) {
                result = gejalaCursor.getString(1);
                kode_ya = gejalaCursor.getString(2);
                kode_tidak = gejalaCursor.getString(3);
                mulai = gejalaCursor.getString(4);
                selesai = gejalaCursor.getString(5);
                kode_main = gejalaCursor.getString(0);
                gejalaCursor.moveToNext();
            }
        }
        data.setDiagnosa(result);
        data.setYa(kode_ya);
        data.setTidak(kode_tidak);
        gejala.setClickable(false);
        gejala.setText("Apakah Ac anda mengalami\n" + data.getDiagnosa() + "?");
    }

    public void getYA() {
            arrDiagnosa.add(data.getYa());
            strDiagnosa += arrDiagnosa.size() + ". " + data.getDiagnosa() + "\n";

        gejalaCursor = db.rawQuery("SELECT * FROM gejala where id = '" + data.getYa() + "'", null);
        if (gejalaCursor.moveToFirst()) {
            result = gejalaCursor.getString(1);
            kode_ya = gejalaCursor.getString(2);
            kode_tidak = gejalaCursor.getString(3);
            mulai = gejalaCursor.getString(4);
            selesai = gejalaCursor.getString(5);
            kode_main = gejalaCursor.getString(0);
            while (!gejalaCursor.isAfterLast()) {
                result = gejalaCursor.getString(1);
                kode_ya = gejalaCursor.getString(2);
                kode_tidak = gejalaCursor.getString(3);
                mulai = gejalaCursor.getString(4);
                selesai = gejalaCursor.getString(5);
                kode_main = gejalaCursor.getString(0);
                gejalaCursor.moveToNext();
            }
        }

        if (kode_main.equals("P001")){

            nilai = arrDiagnosa.size() / 12.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P002")){

            nilai = arrDiagnosa.size() / 4.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P003")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P004")){

        nilai = arrDiagnosa.size() / 3.0d * 100.0d;
        System.out.println(String.valueOf(nilai));
        Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
        intent.putExtra("persen", String.format("%.2f", nilai)+"%");
        intent.putExtra("nama", kode_main);
        intent.putExtra("namagejala", strDiagnosa);
        startActivity(intent);
        return;
        }

        if (selesai.equals("Y")){
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }

        data.setDiagnosa(result);
        data.setYa(kode_ya);
        data.setTidak(kode_tidak);
        gejala.setText("Apakah Ac anda mengalami\n" + data.getDiagnosa() + "?");
        radioGroup.clearCheck();
        radioButton_ya.invalidate();
        radioButton_tidak.invalidate();
    }

    public void getTIDAK() {
        gejalaCursor = db.rawQuery("SELECT * FROM gejala where id = '" + data.getTidak() + "'", null);
        if (gejalaCursor.moveToFirst()) {
            result = gejalaCursor.getString(1);
            kode_ya = gejalaCursor.getString(2);
            kode_tidak = gejalaCursor.getString(3);
            mulai = gejalaCursor.getString(4);
            selesai = gejalaCursor.getString(5);
            kode_main = gejalaCursor.getString(0);
            while (!gejalaCursor.isAfterLast()) {
                result = gejalaCursor.getString(1);
                kode_ya = gejalaCursor.getString(2);
                kode_tidak = gejalaCursor.getString(3);
                mulai = gejalaCursor.getString(4);
                selesai = gejalaCursor.getString(5);
                kode_main = gejalaCursor.getString(0);
                gejalaCursor.moveToNext();
            }
        }
        if (kode_tidak.contentEquals("B")) {
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("namanol", "Ac anda mungkin tidak rusak atau mungkin Ac anda terdeteksi kerusakan lain yang belum ada di sistem kami");
            intent.putExtra("namagejala", " ");
            startActivity(intent);
            return;

        }
        if (kode_main.equals("P001")){

            nilai = arrDiagnosa.size() / 12.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P002")){

            nilai = arrDiagnosa.size() / 4.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }if (kode_main.equals("P003")){

            nilai = arrDiagnosa.size() / 5.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        if (kode_main.equals("P004")){

            nilai = arrDiagnosa.size() / 3.0d * 100.0d;
            System.out.println(String.valueOf(nilai));
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("persen", String.format("%.2f", nilai)+"%");
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }

        if (selesai.equals("Y")){
            Intent intent = new Intent(getApplicationContext(), hasil_deteksi.class);
            intent.putExtra("nama", kode_main);
            intent.putExtra("namagejala", strDiagnosa);
            startActivity(intent);
            return;
        }
        data.setDiagnosa(result);
        data.setYa(kode_ya);
        radioGroup.clearCheck();
        data.setTidak(kode_tidak);
        gejala.setText("Apakah Ac anda mengalami\n" + data.getDiagnosa() + "?");
        radioButton_ya.invalidate();
        radioButton_tidak.invalidate();
    }

    public void onBackPressed() {

    }
}
