package br.edu.unichristus.appconsultadisciplina.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.edu.unichristus.appconsultadisciplina.R;
import br.edu.unichristus.appconsultadisciplina.controller.AlunoController;
import br.edu.unichristus.appconsultadisciplina.model.Aluno;

public class MainActivity extends AppCompatActivity {

    AlunoController controller;

    Aluno aluno;
    List<Aluno> dados;


    EditText editNome;
    EditText editDisciplina;
    EditText editMatricula;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new AlunoController(MainActivity.this);
        dados = controller.getListaDados();

        controller.toString();

        aluno = new Aluno();

        controller.buscar(aluno);

        editNome = findViewById(R.id.editNome);
        editMatricula = findViewById(R.id.editMatricula);
        editDisciplina = findViewById(R.id.editDisciplina);
        editTelefone = findViewById(R.id.editTelefone);

        editNome.setText(aluno.getNome());
        editMatricula.setText(aluno.getMatricula());
        editDisciplina.setText(aluno.getDisciplina());
        editTelefone.setText(aluno.getTelefone());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNome.setText(aluno.getNome());
        editMatricula.setText(aluno.getMatricula());
        editDisciplina.setText(aluno.getDisciplina());
        editTelefone.setText(aluno.getTelefone());


        //Limpar dados
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNome.setText("");
                editMatricula.setText("");
                editDisciplina.setText("");
                editTelefone.setText("");

                controller.limpar();
           }
        });

        //Fechar aplicativo
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Agradecemos sua contribuição!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        //Salvar dados
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aluno.setNome(editNome.getText().toString());
                aluno.setMatricula(editMatricula.getText().toString());
                aluno.setDisciplina(editDisciplina.getText().toString());
                aluno.setTelefone(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + aluno.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(aluno);


            }
        });


    }
}