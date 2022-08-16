package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class UnitConverted extends AppCompatActivity implements ComunicaOpciones{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converted);
    }


    @Override
    public void opciones(int presionado) {
        Intent intent = new Intent(this, calculo.class);
        intent.putExtra("botonPresionado", presionado);
        startActivity(intent);
    }
}