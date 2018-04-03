package com.example.fabio.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Button buttonTrocar = (Button) findViewById(R.id.buttonTrocar);

    public void trocarImagem (View vistaBtn) {
        ImageView imgView = findViewById(R.id.imageView);
        imgView.setImageResource(R.drawable.obama);
    }
}

