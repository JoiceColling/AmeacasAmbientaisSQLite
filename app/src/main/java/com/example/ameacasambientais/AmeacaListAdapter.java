package com.example.ameacasambientais;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AmeacaListAdapter  extends BaseAdapter {
    LayoutInflater inflater;
    AmeacaSQLiteDatabase db;

    public AmeacaListAdapter(Context ctx, AmeacaSQLiteDatabase db){
        inflater = LayoutInflater.from(ctx);
        this.db = db;
    }

    @Override
    public int getCount() {
        return db.getAmeacas().size();
    }

    @Override
    public Object getItem(int position) {
        return db.getAmeacas().get(position);
    }

    @Override
    public long getItemId(int position) {
        return db.getAmeacas().get(position).getId();
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item, null);
        TextView txtAmeacaDescricao = v.findViewById(R.id.txtAmeacaDescricao);
        TextView txtAmeacaData = v.findViewById(R.id.txtAmeacaData);
        txtAmeacaDescricao.setText(db.getAmeacas().get(position).getDescricao());
        txtAmeacaData.setText(db.getAmeacas().get(position).getData());

        return v;
    }
}
