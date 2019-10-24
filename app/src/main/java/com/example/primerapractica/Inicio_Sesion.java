package com.example.primerapractica;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Inicio_Sesion extends AppCompatActivity {

    public static final String user = "name";
    TextView cajaBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio__sesion);

        cajaBienvenido = (TextView)findViewById(R.id.textView3);
        String usuario=getIntent().getStringExtra("name");
        cajaBienvenido.setText(String.format("%s%s", usuario) );
    }
}
