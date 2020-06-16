package pt.ipg.healthmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static pt.ipg.healthmanagement.lista_medicos.mAdapter2;
public class NotesAdapterMedico extends RecyclerView.Adapter<NotesAdapterMedico.MyViewHolder> {

    private Context context;
    private List<DataMedico> notesList;
    DatabaseHelper db;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_recycler_medico, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataMedico note = notesList.get(position);
        holder.idRc.setText(Integer.toString(note.getId()));
        holder.nomeMedicoRc.setText(note.getNome());
        holder.funcaoMedicoRc.setText(note.getFuncao());
        holder.contactoMedicoRc.setText(note.getContacto());
    }

    public NotesAdapterMedico(Context context, List<DataMedico> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeMedicoRc;
        public TextView funcaoMedicoRc;
        public TextView contactoMedicoRc;
        public TextView idRc;


        public MyViewHolder(View view) {
            super(view);
            idRc = view.findViewById(R.id.idMedicoitem);
            nomeMedicoRc = view.findViewById(R.id.nomeMedicoitem);
            funcaoMedicoRc= view.findViewById(R.id.funcaoMedicoitem);
            contactoMedicoRc=view.findViewById(R.id.contactoMedicoitem);

        }
    }
}
