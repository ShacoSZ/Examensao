package com.example.examensao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class splashsao extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Timer timer;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        TextView second = findViewById(R.id.leopoldo);

        Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new  Intent(splashsao.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
