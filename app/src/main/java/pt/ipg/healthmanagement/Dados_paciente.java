package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Dados_paciente extends AppCompatActivity {
    //para checkbox
    TextView textView;

    //lista medicamentos
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText itemText;
    Button addButton;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_paciente);


        //criar lista medicamentos
        lv = (ListView) findViewById(R.id.listView);
        itemText = (EditText) findViewById(R.id.addtext);
        addButton = (Button) findViewById(R.id.addbutton);
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(Dados_paciente.this, android.R.layout.simple_list_item_1, itemList);

        View.OnClickListener addListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();


            }
        };
        addButton.setOnClickListener(addListner);
        lv.setAdapter(adapter);


        //passar dados pessoais do paciente
        Intent intent = getIntent();

        String nome = intent.getStringExtra("nome_Paciente");
        TextView Nome = (TextView) findViewById(R.id.textViewNome);
        Nome.setText(nome);

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
        TextView Morada = (TextView) findViewById(R.id.textViewMorada);
        Morada.setText(moradap);

        String dataentrada = intent.getStringExtra("dataEntrada");
        TextView DataEntrada = (TextView) findViewById(R.id.textViewDataEntrada);
        DataEntrada.setText(dataentrada);


        //passar valor do Radiobutton genero
        String selectedRadioValue = intent.getStringExtra("rg");
        TextView genero = (TextView) findViewById(R.id.textViewSexo);
        genero.setText(selectedRadioValue);

        //passar valor so spiner estadoClinico
        TextView estado = (TextView) findViewById(R.id.textViewEstadoClinico);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("data").toString();
        estado.setText(data);


    }

    public void Enviar(View view) {
        Intent intent2 = new Intent(this, Ficha_Paciente.class);

        //passar dados para ficha

        TextView NomePaciente = (TextView) findViewById(R.id.textViewNome);
        String nomepaciente = NomePaciente.getText().toString();
        intent2.putExtra("nomepaciente", nomepaciente);

        TextView Genero = (TextView) findViewById(R.id.textViewSexo);
        String genero = Genero.getText().toString();
        intent2.putExtra("genero", genero);

        TextView DataDeNascimento = (TextView) findViewById(R.id.textViewDataNas);
        String datanascimento = DataDeNascimento.getText().toString();
        intent2.putExtra("datanascimento", datanascimento);

        TextView ContactoDeEmergencia = (TextView) findViewById(R.id.textViewContacto);
        String contactodeemergencia = ContactoDeEmergencia.getText().toString();
        intent2.putExtra("contactodeemergencia", contactodeemergencia);

        TextView Morada = (TextView) findViewById(R.id.textViewMorada);
        String morada = Morada.getText().toString();
        intent2.putExtra("morada", morada);

        TextView CartaoCC = (TextView) findViewById(R.id.textViewcartao);
        String cartao = CartaoCC.getText().toString();
        intent2.putExtra("cartao", cartao);

        TextView DataEntrada = (TextView) findViewById(R.id.textViewDataEntrada);
        String dataentrada = DataEntrada.getText().toString();
        intent2.putExtra("dataentrada", dataentrada);

        //passar sintomas

        TextView Sintoma = (TextView) findViewById(R.id.textViewSintoma);
        String sintoma = Sintoma.getText().toString();
        intent2.putExtra("sintoma", sintoma);

        TextView SintomaDesc = (TextView) findViewById(R.id.textViewSintomaDesc);
        String sintomadesc = SintomaDesc.getText().toString();
        intent2.putExtra("sintomadesc", sintomadesc);

        TextView EstadoClinico = (TextView) findViewById(R.id.textViewEstadoClinico);
        String estadoclinico = EstadoClinico.getText().toString();
        intent2.putExtra("estadoclinico", estadoclinico);


        //passar tratamento para ficha
        EditText DataInicioTratamento = (EditText) findViewById(R.id.data_inicio);
        String data_inicio_tratamento = DataInicioTratamento.getText().toString();
        intent2.putExtra("data_inicio_tratamento", data_inicio_tratamento);

        EditText Observacoes = (EditText) findViewById(R.id.outros);
        String observacoes = Observacoes.getText().toString();
        intent2.putExtra("observacoes", observacoes);

        EditText RegimeAlimentar = (EditText) findViewById(R.id.regime_alimentar);
        String regime_alimentar = RegimeAlimentar.getText().toString();
        intent2.putExtra("regime_alimentar", regime_alimentar);

        //lista de medicamentos

        //passar para outra activity os medicamentos

        intent2.putExtra("itemList", itemList);


        startActivity(intent2);
    }


}

