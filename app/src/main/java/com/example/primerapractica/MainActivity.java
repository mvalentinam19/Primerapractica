package com.example.primerapractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button iniciar;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = (Button)findViewById(R.id.button3);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent iniciar;
                iniciar = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(iniciar);


            }
        });

        registrar = (Button)findViewById(R.id.button4);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent registrar;
                registrar = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(registrar);


            }
        });
    }

}
