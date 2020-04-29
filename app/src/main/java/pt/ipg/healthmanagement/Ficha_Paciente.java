package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ficha_Paciente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha__paciente);

        Intent intent2 = getIntent();
        //colocar dados dos pacientes
        String nome = intent2.getStringExtra("nomepaciente");
        TextView Nome = (TextView) findViewById(R.id.textViewNomeFicha);
        Nome.setText(nome);

        String genero = intent2.getStringExtra("genero");
        TextView Genero = (TextView)findViewById(R.id.textViewSexoFicha);
        Genero.setText(genero);

        String datanascimento = intent2.getStringExtra("datanascimento");
        TextView dataNascimento =(TextView)findViewById(R.id.textViewDataNasFicha);
        dataNascimento.setText(datanascimento);

        String morada = intent2.getStringExtra("morada");
        TextView Morada =(TextView)findViewById(R.id.textViewMoradaFicha);
        Morada.setText(morada);

        String ContactoDeEmergencia = intent2.getStringExtra("contactodeemergencia");
        TextView contactoDeEmergencia =(TextView)findViewById(R.id.textViewContactoFicha);
        contactoDeEmergencia.setText(ContactoDeEmergencia);

        String numerocc = intent2.getStringExtra("cartao");
        TextView NumeroCC = (TextView)findViewById(R.id.textViewcartaoFicha);
        NumeroCC.setText(numerocc);

        String datadeentrada = intent2.getStringExtra("dataentrada");
        TextView DataEntrada = (TextView)findViewById(R.id.textViewDataEntradaFicha);
        DataEntrada.setText(datadeentrada);

        String sintoma = intent2.getStringExtra("sintoma");
        TextView Sintoma =(TextView)findViewById(R.id.textViewSintomaFicha);
        Sintoma.setText(sintoma);

        String simtomadesc = intent2.getStringExtra("sintomadesc");
        TextView SintomaDesc = (TextView)findViewById(R.id.textViewSintomaDescFicha);
        SintomaDesc.setText(simtomadesc);

        String estadoclinico = intent2.getStringExtra("estadoclinico");
        TextView EstadoClinico = (TextView)findViewById(R.id.textViewEstadoClinicoFicha);
        EstadoClinico.setText(estadoclinico);

        //tratamento
        String Datainiciotratamento = intent2.getStringExtra("data_inicio_tratamento");
        TextView DataInicioTratamento =(TextView)findViewById(R.id.textViewDataInicioTratamentoFicha);
        DataInicioTratamento.setText(Datainiciotratamento);

        String Observacoes = intent2.getStringExtra("observacoes");
        TextView observacoes = (TextView)findViewById(R.id.textViewObservacoesFicha);
        observacoes.setText(Observacoes);

        String RegimeAlimentar = intent2.getStringExtra("regime_alimentar");
        TextView regimealimentar = (TextView)findViewById(R.id.textViewRegimeAlimentarFicha);
        regimealimentar.setText(RegimeAlimentar);


    //adicionar medicamentos

        TextView textView = (TextView)findViewById(R.id.textViewMedicacaoFicha);
        Bundle bundle2=getIntent().getExtras();
        String data = bundle2.get("itemList").toString();

        textView.setText(data.substring(1, data.length()-1));
    }
}
