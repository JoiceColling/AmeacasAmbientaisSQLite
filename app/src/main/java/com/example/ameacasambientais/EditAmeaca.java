package com.example.ameacasambientais;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditAmeaca extends AppCompatActivity {
    AmeacaSQLiteDatabase db;
    EditText txtDescricao, txtData, txtEndereco;
    Ameaca current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ameaca);

        txtDescricao = findViewById(R.id.txtEditDescricao);
        txtData = findViewById(R.id.txtEditData);
        txtEndereco = findViewById(R.id.txtEditEndereco);

        db = new AmeacaSQLiteDatabase(
                getBaseContext());
        Long id = getIntent().getLongExtra("ID", 0);
        current = db.getAmeaca(id);

        txtDescricao.setText(current.getDescricao());
        txtData.setText(current.getData());
        txtEndereco.setText(current.getEndereco());
    }

    public void updateAmeaca(View v){
        String descricao = txtDescricao.getText().toString();
        String data = txtData.getText().toString();
        String endereco = txtEndereco.getText().toString();

        if ( descricao == null || descricao.isEmpty() || data == null || data.isEmpty() || endereco == null || endereco.isEmpty())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(EditAmeaca.this);
            builder.setMessage("Todos os campos são obrigatórios");
            builder.setTitle("Atenção!");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else {
            current.setDescricao(descricao);
            current.setData(data);
            current.setEndereco(endereco);

            db.updateAmeaca(current);
            finish();
        }
    }
}