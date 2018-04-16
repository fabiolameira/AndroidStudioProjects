package com.example.fabio.idadecao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText caixaTexto;
    private Button botaoIdade;
    private TextView resultadoIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caixaTexto = (EditText) findViewById(R.id.caixaTextoId);
        botaoIdade = (Button) findViewById(R.id.botaoIdadeId);
        resultadoIdade = (TextView) findViewById(R.id.resultadoIdadeId);

        botaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Recuperar o que foi digitado
                String textoDigitado = caixaTexto.getText().toString();

                if( textoDigitado.isEmpty() ){
                    //String vazia (mensagem de erro)
                    resultadoIdade.setText("Nenhum número digitado!!");
                }else{

                    int valorDigitado = Integer.parseInt( textoDigitado );
                    int ValorResultadoFinal = valorDigitado * 7;

                    resultadoIdade.setText( "A idade do cachorro em anos humanos é: " + ValorResultadoFinal + " anos " );

                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Abrir o menu; isso adiciona itens à barra de ação, se estiver presente.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Lidar com cliques de itens da barra de ação aqui. A barra de ação será
        // lida automaticamente com cliques no botão Início / Acima, por muito tempo
        // conforme você especifica uma atividade pai em AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
