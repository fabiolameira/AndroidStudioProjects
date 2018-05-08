package com.example.fabio.progressdialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int progressStatus = 0;
    private Handler handler = new Handler();
    private boolean isCanceled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get the widgets reference from XML layout
        final ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.constraint_layout);
        final Button btn = (Button) findViewById(R.id.iniciar_processo);
        final TextView tv = (TextView) findViewById(R.id.estado_do_processo);

        // Set a click listener for button widget
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Specify the progress dialog is not canceled
                isCanceled = false;
                // Initialize a new instance of progress dialog
                final ProgressDialog pd = new ProgressDialog(MainActivity.this);

                // Set progress dialog style horizontal
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                // Set the progress dialog title and message
                pd.setTitle("Barra de Progresso.");
                pd.setMessage("Processando.........");

                // Set the progress dialog background color
                pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD4D9D0")));

                pd.setIndeterminate(false);
                /*
                    Set the progress dialog non cancelable
                    It will disallow user's to cancel progress dialog by clicking outside of dialog
                    But, user's can cancel the progress dialog by cancel button
                 */
                pd.setCancelable(false);

                pd.setMax(100);

                // Put a cancel button in progress dialog
                pd.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener(){
                    // Set a click listener for progress dialog cancel button
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // dismiss the progress dialog
                        pd.dismiss();
                        // Tell the system about cancellation
                        isCanceled = true;
                    }
                });

                // Finally, show the progress dialog
                pd.show();

                // Set the progress status zero on each button click
                progressStatus = 0;

                // Start the lengthy operation in a background thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus < pd.getMax()){
                            // If user's click the cancel button from progress dialog
                            if(isCanceled)
                            {
                                // Stop the operation/loop
                                break;
                            }
                            // Update the progress status
                            progressStatus +=1;

                            // Try to sleep the thread for 200 milliseconds
                            try{
                                Thread.sleep(200);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }

                            // Update the progress bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // Update the progress status
                                    pd.setProgress(progressStatus);
                                    tv.setText(progressStatus+"");
                                    // If task execution completed
                                    if(progressStatus == pd.getMax()){
                                        // Dismiss/hide the progress dialog
                                        pd.dismiss();
                                        tv.setText("Operação completa!");
                                    }
                                }
                            });
                        }
                    }
                }).start(); // Start the operation
            }
        });

    }
}
