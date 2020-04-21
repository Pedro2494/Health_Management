package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Dados_paciente extends AppCompatActivity {
         //para checkbox
        TextView textView;

        //para lista medicamentos
        EditText et;
        Button bt;
        ListView lv;

        ArrayList<String> arrayList;
        ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_paciente);

        //para lista medicamentos
        et = (EditText) findViewById(R.id.medicamento);
        bt = (Button) findViewById(R.id.button_add_Data);
        lv = (ListView) findViewById(R.id.ListaMedicamento);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(Dados_paciente.this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);


        //dados pessoais do paciente
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

        String moradap = intent.getStringExtra("morada_P");
        TextView Morada = (TextView)findViewById(R.id.textViewMorada);
        Morada.setText(moradap);

        String dataentrada = intent.getStringExtra("dataEntrada");
        TextView DataEntrada = (TextView)findViewById(R.id.textViewDataEntrada);
        DataEntrada.setText(dataentrada);

        //checkbox
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

        //spiner estadoClinico
        TextView estado=(TextView)findViewById(R.id.textViewEstadoClinico);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.get("data").toString();
        estado.setText(data);


    }
        //adiciona medicamento
    public void adicionaMedicamento(View view) {
       String result = et.getText().toString();
       arrayList.add(result);
       adapter.notifyDataSetChanged();
    }
}
