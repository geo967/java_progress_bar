package com.example.supportinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    ProgressBar progressBar,progressBar2;
    Button button;
    Handler handler=new Handler();
    int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=findViewById(R.id.text1);
        progressBar=findViewById(R.id.progress_bar);
        progressBar2=findViewById(R.id.progress_bar2);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(progressBar.getProgress()<100){
                            progressBar.setProgress(progress);
                            progress++;
                            handler.postDelayed(this,100);
                            text1.setText("wait...");

                        }else text1.setText("completed");

                    }
                },10);*/
                progress=0;

                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(10);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        if(progressBar2.getProgress()<100){
                            progressBar2.setProgress(progress);
                            progress++;
                            handler.postDelayed(this,100);

                        }
                    }
                });
                thread.start();
            }
        });
    }
}