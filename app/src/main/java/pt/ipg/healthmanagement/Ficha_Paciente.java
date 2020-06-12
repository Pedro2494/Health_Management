package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import org.w3c.dom.Text;

public class Ficha_Paciente extends AppCompatActivity {
    //base de dados
    TextView nomeR, generoR, datanasR, contactoemR, moradaR, numeroccR, datahospitalR;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha__paciente);

        //base de dados
        db=new DatabaseHelper(this);
        //getting id
        nomeR=findViewById(R.id.textViewNomeFicha);
        generoR=findViewById(R.id.textViewSexoFicha);
        datanasR=findViewById(R.id.textViewDataNasFicha);
        contactoemR=findViewById(R.id.textViewContactoFicha);
        moradaR=findViewById(R.id.textViewMoradaFicha);
        numeroccR=findViewById(R.id.textViewcartaoFicha);
        datahospitalR=findViewById(R.id.textViewDataEntradaFicha);





        //colocar dados dos pacientes
        Intent intent2 = getIntent();

        String nome = intent2.getStringExtra("nomepaciente");
        TextView Nome = (TextView) findViewById(R.id.textViewNomeFicha);
        Nome.setText(nome);

        String genero = intent2.getStringExtra("genero");
        TextView Genero = (TextView) findViewById(R.id.textViewSexoFicha);
        Genero.setText(genero);

        String datanascimento = intent2.getStringExtra("datanascimento");
        TextView dataNascimento = (TextView) findViewById(R.id.textViewDataNasFicha);
        dataNascimento.setText(datanascimento);

        String morada = intent2.getStringExtra("morada");
        TextView Morada = (TextView) findViewById(R.id.textViewMoradaFicha);
        Morada.setText(morada);

        String ContactoDeEmergencia = intent2.getStringExtra("contactodeemergencia");
        TextView contactoDeEmergencia = (TextView) findViewById(R.id.textViewContactoFicha);
        contactoDeEmergencia.setText(ContactoDeEmergencia);

        String numerocc = intent2.getStringExtra("cartao");
        TextView NumeroCC = (TextView) findViewById(R.id.textViewcartaoFicha);
        NumeroCC.setText(numerocc);

        String datadeentrada = intent2.getStringExtra("dataentrada");
        TextView DataEntrada = (TextView) findViewById(R.id.textViewDataEntradaFicha);
        DataEntrada.setText(datadeentrada);

        String sintoma = intent2.getStringExtra("sintoma");
        TextView Sintoma = (TextView) findViewById(R.id.textViewSintomaFicha);
        Sintoma.setText(sintoma);

        String simtomadesc = intent2.getStringExtra("sintomadesc");
        TextView SintomaDesc = (TextView) findViewById(R.id.textViewSintomaDescFicha);
        SintomaDesc.setText(simtomadesc);

        String estadoclinico = intent2.getStringExtra("estadoclinico");
        TextView EstadoClinico = (TextView) findViewById(R.id.textViewEstadoClinicoFicha);
        EstadoClinico.setText(estadoclinico);

        //tratamento
        String Datainiciotratamento = intent2.getStringExtra("data_inicio_tratamento");
        TextView DataInicioTratamento = (TextView) findViewById(R.id.textViewDataInicioTratamentoFicha);
        DataInicioTratamento.setText(Datainiciotratamento);

        String Observacoes = intent2.getStringExtra("observacoes");
        TextView observacoes = (TextView) findViewById(R.id.textViewObservacoesFicha);
        observacoes.setText(Observacoes);

        String RegimeAlimentar = intent2.getStringExtra("regime_alimentar");
        TextView regimealimentar = (TextView) findViewById(R.id.textViewRegimeAlimentarFicha);
        regimealimentar.setText(RegimeAlimentar);


        //adicionar medicamentos

        TextView textView = (TextView) findViewById(R.id.textViewMedicacaoFicha);
        Bundle bundle2 = getIntent().getExtras();
        String data = bundle2.get("itemList").toString();

        textView.setText(data.substring(1, data.length() - 1));

    }

    public void AdicionaDados(View view) {
        String saveNome=nomeR.getText().toString();
        String saveGenero=generoR.getText().toString();
        String saveDataNascimento=datanasR.getText().toString();
        String saveContactoEmergencia=contactoemR.getText().toString();
        String saveMorada=moradaR.getText().toString();
        String saveNumeroCC=numeroccR.getText().toString();
        String saveDataEntradaHospital=datahospitalR.getText().toString();
        db.insertData(saveNome,saveGenero,saveDataNascimento,saveContactoEmergencia,saveMorada,saveNumeroCC,saveDataEntradaHospital);
        Intent intent=new Intent(Ficha_Paciente.this,lista_Pacientes.class);
        startActivity(intent);
    }

    //base de dados

}
