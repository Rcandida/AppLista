package br.edu.unichristus.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.unichristus.applistacurso.R;
import br.edu.unichristus.applistacurso.model.Aluno;

public class MainActivity extends AppCompatActivity {

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

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(aluno.getPrimeiroNome());
        editSobrenome.setText(aluno.getSobrenome());
        editCurso.setText(aluno.getCurso());
        editTelefone.setText(aluno.getTelefone());


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editCurso.setText("");
                editTelefone.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Agradecemos pelo preenchimento da pesquisa!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aluno.setPrimeiroNome(editPrimeiroNome.getText().toString());
                aluno.setSobrenome(editSobrenome.getText().toString());
                aluno.setCurso(editCurso.getText().toString());
                aluno.setTelefone(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo "+aluno.toString(), Toast.LENGTH_LONG).show();
            }
        });




    }
}