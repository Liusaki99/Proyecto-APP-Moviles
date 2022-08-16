package com.example.unitconverter;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Opciones extends Fragment {

    private final int[] OPCIONES = {R.id.length, R.id.area, R.id.weight,R.id.volume};

    public Opciones() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View misOpciones;
        misOpciones = inflater.inflate(R.layout.fragment_opciones,container, false);

        Button boton;

        // ************************************
        for (int i = 0 ; i < OPCIONES.length; i++)
        {
            boton = (Button) misOpciones.findViewById(OPCIONES[i]);
            final int presionado = i;

            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity actividad = getActivity();
                    ((ComunicaOpciones)actividad).opciones(presionado);
                }
            });
        }

        // ************************************

        return misOpciones;
    }
}
