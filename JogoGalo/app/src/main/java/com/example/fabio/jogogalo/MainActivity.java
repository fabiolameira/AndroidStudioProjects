package com.example.fabio.jogogalo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int[] jogadas = {2,2,2,2,2,2,2,2,2};
    private boolean player = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void clickBtn(View vistaBtn) {
        Button btnClicado = (Button) vistaBtn;
        btnClicado.getTag();

        if (player){
            btnClicado.setBackgroundColor(Color.RED);
        }else {
            btnClicado.setBackgroundColor(Color.BLUE);
        }
        player = !player;
    }
}
