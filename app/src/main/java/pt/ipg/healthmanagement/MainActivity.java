package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //decalarar radiobutton do genero
    RadioButton Rmasc;
    RadioButton Rfem;
    //declarar spiner
    Spinner spinner_d;
    String estados[] = {"Pouco urgente", "Urgente", "Muito Urgente", "Emergente"};
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //spiner estado clinico
        spinner_d = (Spinner) findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estados);
        spinner_d.setAdapter(arrayAdapter);

        spinner_d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }

    public void submeter(View view) {
        //intent para activity_dados_paciente
        Intent intent = new Intent(this, Dados_paciente.class);


        EditText Nome = (EditText) findViewById(R.id.nome_paciente);
        String nome_Paciente = Nome.getText().toString();
        intent.putExtra("nome_Paciente", nome_Paciente);


        EditText DataNascimento = (EditText) findViewById(R.id.data_nascimento);
        String data_de_nascimento = DataNascimento.getText().toString();
        intent.putExtra("data_de_nascimento", data_de_nascimento);

        EditText ContactoEmergencia = (EditText) findViewById(R.id.contacto_emergencia);
        String contacto_de_emergencia = ContactoEmergencia.getText().toString();
        intent.putExtra("contacto_de_emergencia", contacto_de_emergencia);

        EditText NumeroCC = (EditText) findViewById(R.id.numero_cc);
        String numero_CC = NumeroCC.getText().toString();
        intent.putExtra("numero_CC", numero_CC);

        EditText NomeSintoma = (EditText) findViewById(R.id.sintomas);
        String nome_Sintoma = NomeSintoma.getText().toString();
        intent.putExtra("nome_Sintoma", nome_Sintoma);

        EditText SintomaDescricao = (EditText) findViewById(R.id.descricao_sintomas);
        String descricao_Sintoma = SintomaDescricao.getText().toString();
        intent.putExtra("descricao_Sintoma", descricao_Sintoma);

        EditText Morada = (EditText) findViewById(R.id.morada);
        String morada_P = Morada.getText().toString();
        intent.putExtra("morada_P", morada_P);

        EditText DataEntrada = (EditText) findViewById(R.id.data_entrada);
        String dataEntrada = DataEntrada.getText().toString();
        intent.putExtra("dataEntrada", dataEntrada);

        //validar dados


        if (nome_Paciente.length() <= 0) {
            Nome.setError("Nome obrigatório");
            Nome.requestFocus();
            return;
        }


        if (data_de_nascimento.length() <= 0) {
            DataNascimento.setError("Data de nascimento obrigatório");
            DataNascimento.requestFocus();
            return;
        }

        if (contacto_de_emergencia.length() <= 0) {
            ContactoEmergencia.setError("Contacto obrigatório");
            ContactoEmergencia.requestFocus();
            return;
        }

        if (contacto_de_emergencia.length() >= 10) {
            ContactoEmergencia.setError("contacto inválido");
            ContactoEmergencia.requestFocus();
            return;
        }

        if (numero_CC.length() <= 0) {
            NumeroCC.setError("Número de CC obrigatório");
            NumeroCC.requestFocus();
            return;
        }

        if (numero_CC.length() >= 9) {
            NumeroCC.setError("Número de CC inválido");
            NumeroCC.requestFocus();
            return;
        }

        if (nome_Sintoma.length() <= 0) {
            NomeSintoma.setError("Campo obrigatório");
            NomeSintoma.requestFocus();
            return;
        }

        if (descricao_Sintoma.length() <= 0) {
            SintomaDescricao.setError("Campo obrigatório");
            SintomaDescricao.requestFocus();
            return;
        }

        if (morada_P.length() <= 0) {
            Morada.setError("Morada obrigatório");
            Morada.requestFocus();
            return;
        }

        if (dataEntrada.length() <= 0) {
            DataEntrada.setError("Campo obrigatório");
            DataEntrada.requestFocus();
            return;
        }
        //radiobutton genero
        RadioGroup rg = (RadioGroup) findViewById(R.id.grupo1);
        String selectedRadioValue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        intent.putExtra("rg", selectedRadioValue);


        //spiner estado clinico
        intent.putExtra("data", String.valueOf(spinner_d.getSelectedItem()));

        startActivity(intent);
        //lancar  para activity_dados_paciente


    }
}


