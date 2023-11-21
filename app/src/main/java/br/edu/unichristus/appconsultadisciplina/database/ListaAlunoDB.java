package br.edu.unichristus.appconsultadisciplina.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

import br.edu.unichristus.appconsultadisciplina.model.Aluno;


public class ListaAlunoDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "listadisciplina.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;


    public ListaAlunoDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Query SQL para criar table
        String sqlTabelaIntencao =
                "CREATE TABLE Intencao (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nome TEXT, " +
                        "matricula TEXT, " +
                        "disciplina TEXT, " +
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

        //o cursor é responsável por consultar o banco de dados e aplicar a query
        //o rawQuery executa a instrução com os argumentos. Como queremos a lista toda, coloca argumentos como null
        cursor = db.rawQuery(querySQL, null);

        if(cursor.moveToFirst()){

            do{
                registro = new Aluno();

                registro.setId(cursor.getInt(0));
                registro.setNome(cursor.getString(1));
                registro.setMatricula(cursor.getString(2));
                registro.setDisciplina(cursor.getString(3));
                registro.setTelefone(cursor.getString(4));

                lista.add(registro);

            }while(cursor.moveToNext());
        }else{
            //false
        }
        return lista;
    }

    public void deletarObjeto(String tabela, int id){
        db.delete(tabela,"id=?", new String[]{Integer.toString(id)});
    }
}
