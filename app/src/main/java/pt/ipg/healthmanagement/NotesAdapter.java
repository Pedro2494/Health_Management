package pt.ipg.healthmanagement;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose option");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showDialog(position);
                } else {
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

    public void showDialog(final int position){
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(context);
        View view = layoutInflaterAndroid.inflate(R.layout.dialog_layout, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(context);
        alertDialogBuilderUserInput.setView(view);

        final EditText inputNoteNome = view.findViewById(R.id.nomeUpdate);
        final EditText inputNoteGenero = view.findViewById(R.id.generoUpdate);
        final EditText inputNoteDataNascimento = view.findViewById(R.id.datadenascimentoUpdate);
        final EditText inputNoteContactoEmergencia = view.findViewById(R.id.contactodeemergenciaUpdate);
        final EditText inputNoteMorada = view.findViewById(R.id.moradaUpdate);
        final EditText inputNoteNumeroCC = view.findViewById(R.id.numeroccUpdate);
        final EditText inputNoteDataEntradaServico = view.findViewById(R.id.datadeentradaUpdate);
        final EditText inputNoteSintomas = view.findViewById(R.id.sintomasUpdate);
        final EditText inputNoteDetalhesSintomas = view.findViewById(R.id.detalhesintomaUpdate);
        final EditText inputNoteEstadoClinico = view.findViewById(R.id.estadoclinicoUpdate);
        final EditText inputNoteDataInicioTratamento = view.findViewById(R.id.datatratamentoUpdate);
        final EditText inputNoteObservacoes = view.findViewById(R.id.observacoesUpdate);
        final EditText inputNoteRegimeAlimentar = view.findViewById(R.id.regimealimentarUpdate);
        final EditText inputNoteMedicacao = view.findViewById(R.id.medicacaoUpdate);

        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {
                        updateNote(inputNoteNome.getText().toString(),
                                inputNoteGenero.getText().toString(),
                                inputNoteDataNascimento.getText().toString(),
                                inputNoteContactoEmergencia.getText().toString(),
                                inputNoteMorada.getText().toString(),
                                inputNoteNumeroCC.getText().toString(),
                                inputNoteDataEntradaServico.getText().toString(),
                                inputNoteSintomas.getText().toString(),
                                inputNoteDetalhesSintomas.getText().toString(),
                                inputNoteEstadoClinico.getText().toString(),
                                inputNoteDataInicioTratamento.getText().toString(),
                                inputNoteObservacoes.getText().toString(),
                                inputNoteRegimeAlimentar.getText().toString(),
                                inputNoteMedicacao.getText().toString(),
                                position);
                     /*   updateNote(inputNoteGenero.getText().toString(), position);
                        updateNote(inputNoteDataNascimento.getText().toString(), position);
                        updateNote(inputNoteContactoEmergencia.getText().toString(), position);
                        updateNote(inputNoteMorada.getText().toString(), position);
                        updateNote(inputNoteNumeroCC.getText().toString(), position);
                        updateNote(inputNoteDataEntradaServico.getText().toString(), position);
                        updateNote(inputNoteSintomas.getText().toString(), position);
                        updateNote(inputNoteDetalhesSintomas.getText().toString(), position);
                        updateNote(inputNoteEstadoClinico.getText().toString(), position);
                        updateNote(inputNoteDataInicioTratamento.getText().toString(), position);
                        updateNote(inputNoteObservacoes.getText().toString(), position);
                        updateNote(inputNoteRegimeAlimentar.getText().toString(), position);
                        updateNote(inputNoteMedicacao.getText().toString(), position); */
                    }
                })
                .setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                dialogBox.cancel();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();
    }


    private void updateNote(String noteNome, String noteGenero, String noteDataNas, String noteContacto, String noteMorada, String noteNumerocc, String noteDataEntrada, String noteSintoma, String noteDetalheSintoma, String noteEstadoClinico, String noteDataTratamento, String noteObservacoes, String noteRegimeAlimentar, String noteMedicacao, int position) {
        Data n = notesList.get(position);
        // updating note text
        n.setNome(noteNome);
        n.setGenero(noteGenero);
        n.setData_nascimento(noteDataNas);
        n.setContacto_emergencia(noteContacto);
        n.setMorada(noteMorada);
        n.setNumero_cc(noteNumerocc);
        n.setData_entrada_servico(noteDataEntrada);
        n.setSintoma(noteSintoma);
        n.setDetalheSintoma(noteDetalheSintoma);
        n.setEstadoClinico(noteEstadoClinico);
        n.setData_inicio_tratamento(noteDataTratamento);
        n.setObservacoes(noteObservacoes);
        n.setRegime_alimentar(noteRegimeAlimentar);
        n.setMedicacao(noteMedicacao);
        db = new DatabaseHelper(context);
        // updating note in db
        db.updateNote(n);
        // refreshing the list
        notesList.set(position, n);
        mAdapter1.notifyItemChanged(position);
    }

}
