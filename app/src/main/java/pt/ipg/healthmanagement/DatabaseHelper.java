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
    private static final String DATABASE_NAME = "Pacientes";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Data.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

public long insertData(String nomeR, String generoR, String datanasR, String contactoemR, String moradaR, String numeroccR, String datahospitalR, String sintomaR, String detalheSintomaR, String estadoClinicoR){
    SQLiteDatabase db=this.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put("Nome",nomeR);
    values.put("Genero",generoR);
    values.put("Data_nascimento",datanasR);
    values.put("Contacto_emergencia",contactoemR);
    values.put("Morada",moradaR);
    values.put("Numero_cc",numeroccR);
    values.put("Data_entrada_servico",datahospitalR);
    values.put("Sintoma",sintomaR);
    values.put("Detalhe_sintoma", detalheSintomaR);
    values.put("EstadoClinico", estadoClinicoR);
    long id=db.insert("Pacientes",null,values);
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
                notes.add(note);
            } while (cursor.moveToNext());
        }
        db.close();
        return notes;
    }

    public void deleteNote(Data note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Pacientes", "Id" + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
}
