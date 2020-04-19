package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;



public class Dados_paciente extends AppCompatActivity {
        TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_paciente);

        Intent intent = getIntent();

        String nome = intent.getStringExtra("nome_Paciente");
        TextView Nome = (TextView) findViewById(R.id.textViewNome);
        Nome.setText(nome);


        String idade = intent.getStringExtra("idade_Paciente");
        TextView Idade = (TextView) findViewById(R.id.textViewIdade);
        Idade.setText(idade);

        String datanascimento = intent.getStringExtra("data_de_nascimento");
        TextView DataNascimento = (TextView) findViewById(R.id.textViewDataNas);
        DataNascimento.setText(datanascimento);

        String contactoemergengia = intent.getStringExtra("contacto_de_emergencia");
        TextView ContactoEmergencia = (TextView) findViewById(R.id.textViewContacto);
        ContactoEmergencia.setText(contactoemergengia);

        String numerocc = intent.getStringExtra("numero_CC");
        TextView NumeroCC = (TextView) findViewById(R.id.textViewcartao);
        NumeroCC.setText(numerocc);

        String nomesintoma = intent.getStringExtra("nome_Sintoma");
        TextView NomeSintoma = (TextView) findViewById(R.id.textViewSintoma);
        NomeSintoma.setText(nomesintoma);

        String descricaosintoma = intent.getStringExtra("descricao_Sintoma");
        TextView DescricaoSintoma = (TextView) findViewById(R.id.textViewSintomaDesc);
        DescricaoSintoma.setText(descricaosintoma);

        textView = (TextView) findViewById(R.id.textViewSexo);

        StringBuilder str = new StringBuilder("");
        if (intent.getBooleanExtra("Masculino", false)){
            str.append("Masculino");
        }

        if (intent.getBooleanExtra("Feminino", false)){
            str.append("Feminino");
        }
        if(str.length() == 0){
            str.append("Plain");
        }
        textView.setText(str);

    }
}
