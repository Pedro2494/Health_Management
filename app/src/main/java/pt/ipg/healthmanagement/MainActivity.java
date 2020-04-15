package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submeter(View view) {
        Intent intent = new Intent(this, Dados_paciente.class);

        EditText Nome = (EditText) findViewById(R.id.nome_paciente);
        String nome_Paciente = Nome.getText().toString();
        intent.putExtra("nome_Paciente", nome_Paciente);

        EditText Idade =(EditText) findViewById(R.id.idade_paciente);
        String idade_Paciente = Idade.getText().toString();
        intent.putExtra("idade_Paciente", idade_Paciente);



        startActivity(intent);
    }
}
