package com.example.fabio.password;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        Button btSubmeter = (Button) findViewById(R.id.btSubmeter);

        btSubmeter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick (View v){
                Toast toast= Toast.makeText(MainActivity.this,txtPassword.getText(),Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}