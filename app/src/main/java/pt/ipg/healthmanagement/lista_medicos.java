package pt.ipg.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class lista_medicos extends AppCompatActivity {

    private List<DataMedico> notesList2 = new ArrayList<>();
    private RecyclerView recyclerView;
    DatabaseHelper db;
    public static NotesAdapter mAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicos);

        recyclerView = findViewById(R.id.recyclerMedico);
        db = new DatabaseHelper(this);

        notesList2.addAll(db.getMedicosFromdb());
        mAdapter2 = new NotesAdapter(this, notesList2);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter2);
    }
}
