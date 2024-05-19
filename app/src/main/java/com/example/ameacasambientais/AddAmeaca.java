package com.example.ameacasambientais;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddAmeaca extends AppCompatActivity {
    AmeacaSQLiteDatabase db;
    EditText txtDescricao, txtData, txtEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ameaca);

        txtDescricao = findViewById(R.id.txtDescricao);
        txtData = findViewById(R.id.txtData);
        txtEndereco = findViewById(R.id.txtEndereco);

        db = new AmeacaSQLiteDatabase(
                getBaseContext());
    }

    public void addAmeaca(View v){
        String descricao = txtDescricao.getText().toString();
        String data = txtData.getText().toString();
        String endereco = txtEndereco.getText().toString();

        if ( descricao == null || descricao.isEmpty() || data == null || data.isEmpty() || endereco == null || endereco.isEmpty())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddAmeaca.this);
            builder.setMessage("Todos os campos são obrigatórios");
            builder.setTitle("Atenção!");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else {
            Ameaca a = new Ameaca();
            a.setDescricao(txtDescricao.getText().toString());
            a.setData(txtData.getText().toString());
            a.setEndereco(txtEndereco.getText().toString());

            db.addAmeaca(a);
            finish();
        }
    }
}