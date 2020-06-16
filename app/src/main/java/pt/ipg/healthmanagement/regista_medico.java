package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class regista_medico extends AppCompatActivity {
    DatabaseHelper db;
    EditText nomeMedico, funcaoMedico, contactoMedico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regista_medico);

        db=new DatabaseHelper(this);

        nomeMedico = findViewById(R.id.nome_Medico);
        funcaoMedico = findViewById(R.id.funcaoMedico);
        contactoMedico = findViewById(R.id.contactoMedico);

    }

    public void RegistaMedico(View view) {
        String saveNome = nomeMedico.getText().toString();
        String savefuncao = funcaoMedico.getText().toString();
        String saveContacto = contactoMedico.getText().toString();

        db.insertDataMedico(saveNome,savefuncao,saveContacto);
        Intent intent=new Intent(regista_medico.this,lista_medicos.class);
        startActivity(intent);
    }
}
