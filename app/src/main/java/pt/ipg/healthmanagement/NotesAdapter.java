package pt.ipg.healthmanagement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static pt.ipg.healthmanagement.lista_Pacientes.mAdapter1;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private Context context;
    private List<Data> notesList;
    DatabaseHelper db;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_recycler, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Data note = notesList.get(position);
        holder.idRC.setText(Integer.toString(note.getId()));
        holder.nomeRC.setText(note.getNome());
        holder.generoRC.setText(note.getGenero());
                holder.data_nascimentoRC.setText(note.getData_nascimento());
                holder.contacto_emergenciaRC.setText(note.getContacto_emergencia());
                holder.moradaRC.setText(note.getMorada());
                holder.numero_ccRC.setText(note.getNumero_cc());
                holder.data_entrada_servicoRC.setText(note.getData_entrada_servico());
                holder.sintomaRC.setText(note.getSintoma());
                holder.detalheSintomaRC.setText(note.getDetalheSintoma());
                holder.estadoclinicoRC.setText(note.getEstadoClinico());
                holder.data_inicio_tartamentoRC.setText(note.getData_inicio_tratamento());
                holder.observacoesRC.setText(note.getObservacoes());
                holder.regime_alimentarRC.setText(note.getRegime_alimentar());
                holder.medicacaoRC.setText(note.getMedicacao());



                holder.nomeRC.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        showActionsDialog(position);
                        return false;
                    }
                });

    }

    public NotesAdapter(Context context, List<Data> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public int getItemCount() { return notesList.size(); }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView idRC;
        public TextView nomeRC;
        public TextView generoRC;
        public TextView data_nascimentoRC;
        public TextView contacto_emergenciaRC;
        public TextView moradaRC;
        public TextView numero_ccRC;
        public TextView data_entrada_servicoRC;
        public TextView sintomaRC;
        public TextView detalheSintomaRC;
        public TextView estadoclinicoRC;
        public TextView data_inicio_tartamentoRC;
        public TextView observacoesRC;
        public TextView regime_alimentarRC;
        public TextView medicacaoRC;

        public MyViewHolder(View view) {
            super(view);
            idRC = view.findViewById(R.id.id);
            nomeRC = view.findViewById(R.id.nomeitem);
            generoRC = view.findViewById(R.id.generoitem);
            data_nascimentoRC = view.findViewById(R.id.datanascimentoitem);
            contacto_emergenciaRC = view.findViewById(R.id.contactoemergenciaitem);
            moradaRC = view.findViewById(R.id.moradaitem);
            numero_ccRC = view.findViewById(R.id.numerodeccitem);
            data_entrada_servicoRC = view.findViewById(R.id.dataentradaitem);
            sintomaRC = view.findViewById(R.id.sintomaitem);
            detalheSintomaRC = view.findViewById(R.id.detalhesintomaitem);
            estadoclinicoRC = view.findViewById(R.id.estadoclinicoitem);
            data_inicio_tartamentoRC = view.findViewById(R.id.datainiciotratamentoitem);
            observacoesRC = view.findViewById(R.id.observacoesitem);
            regime_alimentarRC = view.findViewById(R.id.regimealimentaritem);
            medicacaoRC = view.findViewById(R.id.medicacaoitem);
        }
    }

    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Eliminar"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Apagar paciente");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    deleteNote(position);
                }
            }
        });
        builder.show();
    }

        private void deleteNote(int position) {
            // deleting the note from db
            db = new DatabaseHelper(context);
            db.deleteNote(notesList.get(position));

            // removing the note from the list
            notesList.remove(position);
            mAdapter1.notifyItemRemoved(position);
        }

}
