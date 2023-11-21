package br.edu.unichristus.appconsultadisciplina.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.edu.unichristus.appconsultadisciplina.R;
import br.edu.unichristus.appconsultadisciplina.database.ListaAlunoDB;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutarTelaSplash();
    }

    private void comutarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ListaAlunoDB db = new ListaAlunoDB(SplashActivity.this);

                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }
}