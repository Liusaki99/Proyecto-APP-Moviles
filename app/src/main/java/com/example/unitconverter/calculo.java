package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class calculo extends AppCompatActivity implements ComunicaOpciones{

    Fragment[] fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        fragment = new Fragment[4];
        fragment[0] = new Fragmento1();
        fragment[1] = new Fragmento2();
        fragment[2] = new Fragmento3();
        fragment[3] = new Fragmento4();

        Bundle bundle = getIntent().getExtras();
        opciones(bundle.getInt("botonPresionado"));
    }

    @Override
    public void opciones(int presionado) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.opciones, fragment[presionado]);
        transaction.commit();

    }
}