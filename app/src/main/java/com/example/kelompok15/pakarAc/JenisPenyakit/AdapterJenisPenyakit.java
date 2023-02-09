package com.example.kelompok15.pakarAc.JenisPenyakit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelompok15.pakarAc.R;

import java.util.ArrayList;

public class AdapterJenisPenyakit extends RecyclerView.Adapter<AdapterJenisPenyakit.ViewHolder> {
    private static final String TAG = "AdapterJenisPenyakit";

    private ArrayList<String> mNamaPenyakit = new ArrayList<>();
    private ArrayList<String> mDefinisi = new ArrayList<>();
    private ArrayList<String> mGejala = new ArrayList<>();
    private ArrayList<String> mSolusi = new ArrayList<>();
    private Context mContext;

    public AdapterJenisPenyakit(Context context, ArrayList<String> namaPenyakit, ArrayList<String> defPenyakit, ArrayList<String> gejPenyakit, ArrayList<String> solPenyakit ) {
        mNamaPenyakit = namaPenyakit;
        mDefinisi = defPenyakit;
        mGejala = gejPenyakit;
        mSolusi = solPenyakit;
        mContext = context;
    }

    @Override
    public AdapterJenisPenyakit.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jenis_penyakit, parent, false);
        AdapterJenisPenyakit.ViewHolder holder = new AdapterJenisPenyakit.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterJenisPenyakit.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.namaPenyakit.setText(mNamaPenyakit.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mNamaPenyakit.get(position));

                Toast.makeText(mContext, mNamaPenyakit.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailJenisPenyakit.class);
                intent.putExtra("nama_penyakit", mNamaPenyakit.get(position));
                intent.putExtra("definisi", mDefinisi.get(position));
                intent.putExtra("gejala", mGejala.get(position));
                intent.putExtra("solusi", mSolusi.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNamaPenyakit.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView namaPenyakit;
        CardView parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            namaPenyakit = itemView.findViewById(R.id.tv_nama);
            parentLayout = itemView.findViewById(R.id.cv_item_jenispenyakit);
        }
    }
}
