package com.example.fabio.toastsack;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Button buttonToast = (Button) findViewById(R.id.toastButton);
    Button buttonSnack = (Button) findViewById(R.id.snackButton);

    private String obterTexto() {
        EditText caixaTexto = findViewById(R.id.plainText);
        String texto = caixaTexto.getText().toString();
        if (texto.trim().equals("")){
            texto = "Não há qualquer texto introduzido!";
        }
        return texto;
    }

    public void pulsarToast (View view) {
        Toast.makeText(MainActivity.this, obterTexto(), Toast.LENGTH_LONG).show();
    }

    public void pulsarSnack (View view) {
        Snackbar.make(view, obterTexto(), Snackbar.LENGTH_LONG).show();
    }

}
