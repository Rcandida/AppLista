package br.edu.unichristus.appconsultadisciplina.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

import br.edu.unichristus.appconsultadisciplina.database.ListaAlunoDB;
import br.edu.unichristus.appconsultadisciplina.model.Aluno;
import br.edu.unichristus.appconsultadisciplina.view.MainActivity;

public class AlunoController extends ListaAlunoDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaAluno;
    public static final String NOME_PREFERENCES = "pref_lista_aluno";

    public AlunoController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaAluno = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {



        return super.toString();
    }

    public void salvar(Aluno aluno) {

        ContentValues dados = new ContentValues();

        listaAluno.putString("nome", aluno.getNome());
        listaAluno.putString("matricula", aluno.getMatricula());
        listaAluno.putString("disciplina", aluno.getDisciplina());
        listaAluno.putString("telefone", aluno.getTelefone());
        listaAluno.apply();

        dados.put("nome", aluno.getNome());
        dados.put("matricula", aluno.getMatricula());
        dados.put("disciplina", aluno.getDisciplina());
        dados.put("telefone", aluno.getTelefone());

        salvarObjeto("Intencao", dados);

    }

    public List<Aluno> getListaDados(){

        return listarDados();
    }

    public Aluno buscar(Aluno aluno) {

        aluno.setNome(preferences.getString("nome", ""));
        aluno.setMatricula(preferences.getString("matricula", ""));
        aluno.setDisciplina(preferences.getString("disciplina", ""));
        aluno.setTelefone(preferences.getString("telefone", ""));

        return aluno;

    }

    public void limpar() {
        listaAluno.clear();
        listaAluno.apply();

    }


}
