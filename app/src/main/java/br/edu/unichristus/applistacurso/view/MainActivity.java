package br.edu.unichristus.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.unichristus.applistacurso.R;
import br.edu.unichristus.applistacurso.controller.AlunoController;
import br.edu.unichristus.applistacurso.model.Aluno;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor listaCurso;
    public static final String NOME_PREFERENCES = "pref_lista_curso";

    AlunoController controller;

    Aluno aluno;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCurso;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaCurso = preferences.edit();

        controller = new AlunoController();
        controller.toString();

        aluno = new Aluno();

        //Buscar dados no SharedPreferences no arquivo criado, no caso "preferences"
        aluno.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        aluno.setSobrenome(preferences.getString("sobrenome", ""));
        aluno.setCurso(preferences.getString("curso", ""));
        aluno.setTelefone(preferences.getString("telefone", ""));

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        editPrimeiroNome.setText(aluno.getPrimeiroNome());
        editSobrenome.setText(aluno.getSobrenome());
        editCurso.setText(aluno.getCurso());
        editTelefone.setText(aluno.getTelefone());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(aluno.getPrimeiroNome());
        editSobrenome.setText(aluno.getSobrenome());
        editCurso.setText(aluno.getCurso());
        editTelefone.setText(aluno.getTelefone());



        //Limpar dados
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editCurso.setText("");
                editTelefone.setText("");

                //Limpar o SharedPreferences
                listaCurso.clear();
                listaCurso.apply();
            }
        });

        //Fechar aplicativo
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Agradecemos o preenchimento da pesquisa!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        //Salvar dados
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aluno.setPrimeiroNome(editPrimeiroNome.getText().toString());
                aluno.setSobrenome(editSobrenome.getText().toString());
                aluno.setCurso(editCurso.getText().toString());
                aluno.setTelefone(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo "+aluno.toString(), Toast.LENGTH_LONG).show();

                //Salvar dados digitados no arquivo do SharedPreferences criado - preferences
                listaCurso.putString("primeiroNome", aluno.getPrimeiroNome());
                listaCurso.putString("sobrenome", aluno.getSobrenome());
                listaCurso.putString("curso", aluno.getCurso());
                listaCurso.putString("telefone", aluno.getTelefone());
                listaCurso.apply();


                controller.salvar(aluno);
            }
        });




    }
}