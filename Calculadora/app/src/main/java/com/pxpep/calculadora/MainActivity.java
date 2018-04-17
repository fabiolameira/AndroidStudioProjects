package com.pxpep.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double varAux1 = 0.0d;
    private double varAux2 = 0.0d;
    private char op = ' ';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void pulsarBtnNumerico(int valorPulsado) {

        TextView txtView = findViewById(R.id.txtVisor);
        String strAct = txtView.getText().toString()+String.valueOf(valorPulsado);
        txtView.setText(strAct);
        if (op==' ') {
            varAux1 = Double.valueOf(strAct);
        } else {
            varAux2 = Double.valueOf(strAct);
        }

    }

    public void pulsarBtnC(View vistaBtn) {
        TextView txtView = findViewById(R.id.txtVisor);
        txtView.setText("");
        varAux1 = 0.0d;
        varAux2 = 0.0d;
        op = ' ';
    }

    public void pulsarBtn0(View vistaBtn) {
        pulsarBtnNumerico(0);
    }

    public void pulsarBtn1(View vistaBtn) {
        pulsarBtnNumerico(1);
    }

    public void pulsarBtn2(View vistaBtn) {
        pulsarBtnNumerico(2);
    }

    public void pulsarBtn3(View vistaBtn) {
        pulsarBtnNumerico(3);
    }

    public void pulsarBtn4(View vistaBtn) {
        pulsarBtnNumerico(4);
    }

    public void pulsarBtn5(View vistaBtn) {
        pulsarBtnNumerico(5);
    }

    public void pulsarBtn6(View vistaBtn) {
        pulsarBtnNumerico(6);
    }

    public void pulsarBtn7(View vistaBtn) {
        pulsarBtnNumerico(7);
    }

    public void pulsarBtn8(View vistaBtn) {
        pulsarBtnNumerico(8);
    }

    public void pulsarBtn9(View vistaBtn) {
        pulsarBtnNumerico(9);
    }

    public void pulsarBtnDiv(View vistaBtn) {
        executaCalculo();
        op = '/';
        TextView txtView = findViewById(R.id.txtVisor);
        txtView.setText("");
    }

    public void pulsarBtnMult(View vistaBtn) {
        executaCalculo();
        op = '*';
        TextView txtView = findViewById(R.id.txtVisor);
        txtView.setText("");
    }

    public void pulsarBtnMenos(View vistaBtn) {
        executaCalculo();
        op = '-';
        TextView txtView = findViewById(R.id.txtVisor);
        txtView.setText("");
    }

    public void pulsarBtnMais(View vistaBtn) {

        executaCalculo();
        op = '+';
        TextView txtView = findViewById(R.id.txtVisor);
        txtView.setText("");

    }

    public void pulsarBtnEnter(View vistaBtn) {

        executaCalculo();
        TextView txtView = findViewById(R.id.txtVisor);
        txtView.setText(String.valueOf(varAux1));

    }

    public void pulsarBtnPonto(View vistaBtn) {
        TextView txtView = findViewById(R.id.txtVisor);
        String strAct = txtView.getText().toString();
        if (strAct.indexOf('.') < 0) {
            txtView.setText(txtView.getText().toString() + '.');
        }
    }

    private void executaCalculo() {

        // Executamos a operação
        if (varAux1!= 0.0d && varAux2 != 0.0d && op != ' ') {
            switch (op) {
                case '+': varAux1 += varAux2; break;
                case '-': varAux1 -= varAux2; break;
                case '*': varAux1 *= varAux2; break;
                case '/': varAux1 /= varAux2; break;
            }
            varAux2 = 0.0d;
            op = ' ';
        }

    }

    // Caso quisessemos obter o id do botão
    // Log.v("viewid", getId(vistaBtn));
    /* De modo a prevenir a criação de 10 métodos, este poderia ter sido criado para obter o id de cada botão
    public static String getId(View view) {
        return view.getResources().getResourceName(view.getId());
    }
     */

}
