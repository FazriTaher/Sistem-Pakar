package com.example.kelompok15.pakarAc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sistempakar";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 5);
    }



    public void createTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS gejala");
        db.execSQL("CREATE TABLE if not exists gejala (id TEXT PRIMARY KEY, nama TEXT, " +
                "ya VARCHAR(5), tidak VARCHAR(5), mulai VARCHAR(5), selesai VARCHAR(5));");
    }

    public void createTable2(SQLiteDatabase db2) {
        db2.execSQL("DROP TABLE IF EXISTS penyakit");
        db2.execSQL("CREATE TABLE if not exists penyakit (kode_penyakit TEXT PRIMARY KEY , " +
                "nama_penyakit TEXT);");
    }

    public void generateData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        db.execSQL("INSERT INTO gejala VALUES ('G001','Tekanan freon kurang', 'G003', 'B', 'Y', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G002','Bocor pada pipa sambungan', 'G006', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G003','Kotor pada unit indoor', 'G004', 'G013', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G004','Adanya Frozen pada pipa sambungan', 'G005', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G005','Rusak pada fan indoor ', 'G002', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G006','Penyumbatan pada pipa kapiler', 'G007', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G007','Kerusakan pada thermistor', 'G008', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G008','Penempatan posisi indoor tidak sesuai', 'G009', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G009','Penempatan posisi outdoor tidak sesuai', 'G010', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G010','Tekanan ampere tidak stabil', 'G011', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G011','Faktor perhitungan BTU tidak sesuai', 'G012', 'P001', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G012','Rusak pada fan outdoor', 'P001', 'G013', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G013','Kerusakan kipas swing Indoor', 'G014', 'G016', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G014','Air menetes pada indoor', 'G015', 'P002', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G015','Suara bising pada unit indoor', 'P002', 'P002', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G016','Kerusakan pada Capasitor outdoor', 'G017', 'G020', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G017','Kompresor macet', 'G018', 'P003', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G018','Suara bising pada unit Outdoor', 'G019', 'P003', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G019','Overload pada Kompresor', 'P003', 'P003', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G020','Adanya short terminal indoor dengan outdoor', 'G021', 'G021', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G021','Permasalahan pada Wiring Diagram', 'P004', 'P004', 'T', 'T');");


        db.execSQL("INSERT INTO gejala VALUES ('P001','Pendinginan', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P002','Indoor', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P003','Outdoor', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P004','Komponen', '0', '0', 'T', 'Y');");


    }

    public void generateData2(SQLiteDatabase db2) {
        db2.execSQL("INSERT INTO penyakit VALUES ('P001', 'Pendinginan');");
        db2.execSQL("INSERT INTO penyakit VALUES ('P002', 'Indoor');");
        db2.execSQL("INSERT INTO penyakit VALUES ('P003', 'Outdoor');");
        db2.execSQL("INSERT INTO penyakit VALUES ('P004', 'Komponen');");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void onCreate(SQLiteDatabase db) {

    }
}
