package br.edu.unichristus.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.edu.unichristus.applistacurso.model.Aluno;

public class ListaCursoDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "listacurso.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;


    public ListaCursoDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Query SQL para criar table
        String sqlTabelaIntencao =
                "CREATE TABLE Intencao (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "primeiroNome TEXT, " +
                        "sobrenome TEXT, " +
                        "curso TEXT, " +
                        "telefone TEXT)";
        db.execSQL(sqlTabelaIntencao);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);

    }

    public List<Aluno> listarDados(){

        List<Aluno> lista = new ArrayList<>();

        Aluno registro;
        String querySQL = "SELECT * FROM Intencao";

        cursor = db.rawQuery(querySQL, null);

        if(cursor.moveToFirst()){

            do{

                registro = new Aluno();

                registro.setId(cursor.getInt(0));
                registro.setPrimeiroNome(cursor.getString(1));
                registro.setSobrenome(cursor.getString(2));
                registro.setCurso(cursor.getString(3));
                registro.setTelefone(cursor.getString(4));

                lista.add(registro);

            }while(cursor.moveToNext());
        }else{

        }

        return lista;

    }
}
