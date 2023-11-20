package br.edu.unichristus.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import br.edu.unichristus.applistacurso.database.ListaCursoDB;
import br.edu.unichristus.applistacurso.model.Aluno;
import br.edu.unichristus.applistacurso.view.MainActivity;

public class AlunoController extends ListaCursoDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaCurso;
    public static final String NOME_PREFERENCES = "pref_lista_curso";

    public AlunoController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaCurso = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller iniciada");

        return super.toString();
    }

    public void salvar(Aluno aluno) {

        ContentValues dados = new ContentValues();

        listaCurso.putString("primeiroNome", aluno.getPrimeiroNome());
        listaCurso.putString("sobrenome", aluno.getSobrenome());
        listaCurso.putString("curso", aluno.getCurso());
        listaCurso.putString("telefone", aluno.getTelefone());
        listaCurso.apply();

        dados.put("primeiroNome", aluno.getPrimeiroNome());
        dados.put("sobrenome", aluno.getSobrenome());
        dados.put("curso", aluno.getCurso());
        dados.put("telefone", aluno.getTelefone());

        salvarObjeto("Intencao", dados);

    }

    public Aluno buscar(Aluno aluno) {

        aluno.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        aluno.setSobrenome(preferences.getString("sobrenome", "NA"));
        aluno.setCurso(preferences.getString("curso", "NA"));
        aluno.setTelefone(preferences.getString("telefone", "NA"));

        return aluno;

    }

    public void limpar() {
        listaCurso.clear();
        listaCurso.apply();

    }


}
