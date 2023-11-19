package br.edu.unichristus.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import br.edu.unichristus.applistacurso.model.Aluno;

public class AlunoController {

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller iniciada");

        return super.toString();
    }

    public void salvar(Aluno aluno) {
        Log.d("MVC_Controller", "Salvo: "+aluno.toString());

    }
}
