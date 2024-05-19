package com.example.ameacasambientais;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_AMEACA = 1010;
    public static final int UPDATE_AMEACA = 2020;
    ListView listAmeacas;
    AmeacaListAdapter ameacaAdapter;
    AmeacaSQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new AmeacaSQLiteDatabase(
                getBaseContext());
        listAmeacas = findViewById(R.id.listAmeacas);
        ameacaAdapter = new AmeacaListAdapter(getBaseContext(), db);
        listAmeacas.setAdapter(ameacaAdapter);

        listAmeacas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeToUpdate(id);
            }
        });

        listAmeacas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.removeAmeaca((Ameaca) ameacaAdapter.getItem(position));
                ameacaAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void changeToAdd(View v){
        Intent it = new Intent(getBaseContext(), AddAmeaca.class);
        startActivityForResult(it, ADD_AMEACA);
    }

    public void changeToUpdate(Long id){
        Intent it = new Intent(getBaseContext(), EditAmeaca.class);
        it.putExtra("ID", id);
        startActivityForResult(it, UPDATE_AMEACA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ameacaAdapter.notifyDataSetChanged();
    }
}