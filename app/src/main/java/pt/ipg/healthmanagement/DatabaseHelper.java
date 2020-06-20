package pt.ipg.healthmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 99;
    private static final String DATABASE_NAME = "Health";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Data.CREATE_TABLE);
        db.execSQL(DataMedico.CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

public long insertData(String nomeR, String generoR, String datanasR, String contactoemR, String moradaR, String numeroccR, String datahospitalR, String sintomaR,
                       String detalheSintomaR, String estadoClinicoR, String datatratamentoR, String observacoesR, String regimealimentarR, String medicacaoR){
    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put("Nome",nomeR);
    values.put("Genero",generoR);
    values.put("Data_nascimento",datanasR);
    values.put("Contacto_emergencia",contactoemR);
    values.put("Morada",moradaR);
    values.put("Numero_cc",numeroccR);
    values.put("Data_entrada_servico",datahospitalR);
    values.put("Sintoma", sintomaR);
    values.put("Detalhe_sintoma", detalheSintomaR);
    values.put("Estado_clinico", estadoClinicoR);
    values.put("Data_inicio_tratamento", datatratamentoR);
    values.put("Observacoes", observacoesR);
    values.put("Regime_alimentar", regimealimentarR);
    values.put("Medicacao", medicacaoR);
    long id=db.insert("Pacientes",null,values);
    db.close();
    return id;
}

//tabela medicos
public long insertDataMedico(String nomeMR, String funcaoMR, String contactoMR){
    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues values2=new ContentValues();
    values2.put("Nome",nomeMR);
    values2.put("funcao",funcaoMR);
    values2.put("contacto", contactoMR);
    long id=db.insert("Medicos", null, values2);
    db.close();
    return id;
}





    public List<Data> getAllDataFromDb(){
        List<Data> notes = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + "Pacientes" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Data note = new Data();
                note.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                note.setNome(cursor.getString(cursor.getColumnIndex("Nome")));
                note.setGenero(cursor.getString(cursor.getColumnIndex("Genero")));
                note.setData_nascimento(cursor.getString(cursor.getColumnIndex("Data_nascimento")));
                note.setContacto_emergencia(cursor.getString(cursor.getColumnIndex("Contacto_emergencia")));
                note.setMorada(cursor.getString(cursor.getColumnIndex("Morada")));
                note.setNumero_cc(cursor.getString(cursor.getColumnIndex( "Numero_cc")));
                note.setData_entrada_servico(cursor.getString(cursor.getColumnIndex("Data_entrada_servico")));
                note.setSintoma(cursor.getString(cursor.getColumnIndex("Sintoma")));
                note.setDetalheSintoma(cursor.getString(cursor.getColumnIndex("Detalhe_sintoma")));
                note.setEstadoClinico(cursor.getString(cursor.getColumnIndex("Estado_clinico")));
                note.setData_inicio_tratamento(cursor.getString(cursor.getColumnIndex("Data_inicio_tratamento")));
                note.setObservacoes(cursor.getString(cursor.getColumnIndex("Observacoes")));
                note.setRegime_alimentar(cursor.getString(cursor.getColumnIndex("Regime_alimentar")));
                note.setMedicacao(cursor.getString(cursor.getColumnIndex("Medicacao")));
                notes.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return notes;
    }


    //tabela medico
    public List<DataMedico>getMedicosFromdb(){
        List<DataMedico> notes2 = new ArrayList<>();
        String selectQueryMedico = "SELECT  * FROM " + "Medicos" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor2 = db.rawQuery(selectQueryMedico, null);
        if (cursor2.moveToFirst()) {
            do {
                DataMedico note2 = new DataMedico();
                note2.setId(cursor2.getInt(cursor2.getColumnIndex("Id")));
                note2.setNome(cursor2.getString(cursor2.getColumnIndex("Nome")));
                note2.setFuncao(cursor2.getString(cursor2.getColumnIndex("Funcao")));
                note2.setContacto(cursor2.getString(cursor2.getColumnIndex("Contacto")));
                notes2.add(note2);
            } while (cursor2.moveToNext());
        }
        db.close();
        return notes2;
    }





    public void deleteNote(Data note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Pacientes", "Id" + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }

    //elimina tabela medicos
    public void deleteNote2(DataMedico note2) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Medicos", "Id" + " = ?",
                new String[]{String.valueOf(note2.getId())});
        db.close();
    }

//edita dados paciente
    public int updateNote(Data note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Nome", note.getNome());
        values.put("Genero", note.getGenero());
        values.put("Data_nascimento", note.getData_nascimento());
        values.put("Contacto_emergencia", note.getContacto_emergencia());
        values.put("Morada", note.getMorada());
        values.put("Numero_cc", note.getNumero_cc());
        values.put("Data_entrada_servico",note.getData_entrada_servico());
        values.put("Sintoma", note.getSintoma());
        values.put("Detalhe_sintoma", note.getDetalheSintoma());
        values.put("Estado_clinico", note.getEstadoClinico());
        values.put("Data_inicio_tratamento", note.getData_inicio_tratamento());
        values.put("Observacoes", note.getObservacoes());
        values.put("Regime_alimentar", note.getRegime_alimentar());
        values.put("Medicacao", note.getMedicacao());

        // updating row
        return db.update("Pacientes", values, "Id" + " = ?",
                new String[]{String.valueOf(note.getId())});
    }
}
