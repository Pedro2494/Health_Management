package pt.ipg.healthmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class Ecra_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecra_principal);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent AM = new Intent(this, regista_medico.class);
        Intent VM = new Intent(this, lista_medicos.class);

        int id = item.getItemId();
        if (id == R.id.addMedico){
            startActivity(AM);
        }

        if (id == R.id.verMedicos){
            startActivity(VM);
        }

        if (id == R.id.sair){
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

    public void abrir(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void abrirlista(View view) {
        Intent intent2 = new Intent(this, lista_Pacientes.class);
        startActivity(intent2);
    }
}
