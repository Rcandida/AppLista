package br.edu.unichristus.appconsultadisciplina.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

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

        dados.put("nome", aluno.getNome());
        dados.put("matricula", aluno.getMatricula());
        dados.put("disciplina", aluno.getDisciplina());
        dados.put("telefone", aluno.getTelefone());

        salvarObjeto("Intencao", dados);

    }

    public List<Aluno> getListaDados(){
        return listarDados();
    }

    public void deletar(int id){
        deletarObjeto("Intencao", id);
    }

    public void limpar() {
        listaAluno.clear();
        listaAluno.apply();

    }


}
