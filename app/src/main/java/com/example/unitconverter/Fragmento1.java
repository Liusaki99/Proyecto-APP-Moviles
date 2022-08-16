package com.example.unitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Fragmento1 extends Fragment implements View.OnClickListener{

    TextView resultado;
    EditText numero;
    Button botona;
    float num;
    String paso, seleccion, seleccion2;
    Spinner spinner, spinner2;

    public Fragmento1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragmento1, container, false);
        numero = (EditText) v.findViewById(R.id.numero);
        resultado = (TextView) v.findViewById(R.id.numeroImprimir);
        botona = (Button) v.findViewById(R.id.boton2a);
        spinner = (Spinner) v.findViewById(R.id.spinner); //implementacion de spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.logitud, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion = parent.getItemAtPosition(position).toString();
                Log.i("Selecciono algo?", seleccion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2 = (Spinner) v.findViewById(R.id.spinner2); //implementacion de spinner2
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion2 = parent.getItemAtPosition(position).toString();
                Log.i("Segunda selleccion", seleccion2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        botona.setOnClickListener(this);

        return v;


    }

    @Override
    public void onClick(View v) {
        num = Integer.parseInt(numero.getText().toString());
        Log.i("Estoy en onClick", seleccion);

        if(seleccion.equals("m"))
        {
            if(seleccion2.equals("mm")) num = num * 1000;
            else if (seleccion2.equals("cm")) num = num * 100;
            else if (seleccion2.equals("dm")) num = num * 10;
            else if (seleccion2.equals("m")) num =  num;
            else if (seleccion2.equals("in")) num = (float) (num *39.3701);
            else if (seleccion2.equals("ft")) num = (float) (num * 3.28084);
            else if (seleccion2.equals("yd")) num = (float) (num * 1.09361);
            else if (seleccion2.equals("km")) num = (float) (num * 0.001);
            else if (seleccion2.equals("mile")) num = (float) (num *  0.000621371);
        }

        else if(seleccion.equals("mm"))
        {
            if(seleccion2.equals("mm")) num = num;
            else if (seleccion2.equals("cm")) num = (float) (num * 0.1);
            else if (seleccion2.equals("dm")) num = (float) (num * 0.01);
            else if (seleccion2.equals("m")) num = (float) (num * 0.001);
            else if (seleccion2.equals("in")) num = (float) (num * 0.0393701);
            else if (seleccion2.equals("ft")) num = (float) (num * 0.00328084);
            else if (seleccion2.equals("yd")) num = (float) (num * 0.00109361);
            else if (seleccion2.equals("km")) num = (float) (num * 0.000001);
            else if (seleccion2.equals("mile")) num = (float) (num *  0.00000062137);
        }

        else if(seleccion.equals("cm"))
        {
            if(seleccion2.equals("mm")) num = num * 10;
            else if (seleccion2.equals("cm")) num = num;
            else if (seleccion2.equals("dm")) num = (float) (num * 0.1);
            else if (seleccion2.equals("m")) num = (float) (num * 0.01);
            else if (seleccion2.equals("in")) num = (float) (num * 0.393701);
            else if (seleccion2.equals("ft")) num = (float) (num * 0.0328084);
            else if (seleccion2.equals("yd")) num = (float) (num * 0.0109361);
            else if (seleccion2.equals("km")) num = (float) (num * 0.00001);
            else if (seleccion2.equals("mile")) num = (float) (num *  0.0000062137);
        }

        else if(seleccion.equals("dm"))
        {
            if(seleccion2.equals("mm")) num = num * 100;
            else if (seleccion2.equals("cm")) num = num * 10;
            else if (seleccion2.equals("dm")) num = num;
            else if (seleccion2.equals("m")) num = (float) (num * 0.1);
            else if (seleccion2.equals("in")) num = (float) (num * 3.9370);
            else if (seleccion2.equals("ft")) num = (float) (num * 0.328084);
            else if (seleccion2.equals("yd")) num = (float) (num * 0.109361);
            else if (seleccion2.equals("km")) num = (float) (num * 0.0001);
            else if (seleccion2.equals("mile")) num = (float) (num *  0.0000621371);
        }

        else if(seleccion.equals("in"))
        {
            if(seleccion2.equals("mm")) num = (float) (num * 25.4);
            else if (seleccion2.equals("cm")) num = (float) (num * 0.393701);
            else if (seleccion2.equals("dm")) num = (float) (num * 0.254);
            else if (seleccion2.equals("m")) num = (float) (num * 0.0254);
            else if (seleccion2.equals("in")) num = num;
            else if (seleccion2.equals("ft")) num = (float) (num * 0.0833333);
            else if (seleccion2.equals("yd")) num = (float) (num * 0.0277778);
            else if (seleccion2.equals("km")) num = (float) (num * 0.000025);
            else if (seleccion2.equals("mile")) num = (float) (num *  0.0000157828);
        }

        else if(seleccion.equals("ft"))
        {
            if(seleccion2.equals("mm")) num = (float) (num * 304.8);
            else if (seleccion2.equals("cm")) num = (float) (num * 30.48);
            else if (seleccion2.equals("dm")) num = (float) (num * 3.048);
            else if (seleccion2.equals("m")) num = (float) (num * 0.3048);
            else if (seleccion2.equals("in")) num = num * 12;
            else if (seleccion2.equals("ft")) num = num;
            else if (seleccion2.equals("yd")) num = (float) (num * 0.333333);
            else if (seleccion2.equals("km")) num = (float) (num * 0.0003048);
            else if (seleccion2.equals("mile")) num = (float) (num *  0.000189394);
        }

        else if(seleccion.equals("yd"))
        {
            if(seleccion2.equals("mm")) num = (float) (num * 914.4);
            else if (seleccion2.equals("cm")) num = (float) (num * 91.44);
            else if (seleccion2.equals("dm")) num = (float) (num * 9.144);
            else if (seleccion2.equals("m")) num = (float) (num * 0.9144);
            else if (seleccion2.equals("in")) num = num * 36;
            else if (seleccion2.equals("ft")) num = num * 3;
            else if (seleccion2.equals("yd")) num = num;
            else if (seleccion2.equals("km")) num = (float) (num * 0.0009144);
            else if (seleccion2.equals("mile")) num = (float) (num *  0.000568182);
        }

        else if(seleccion.equals("km"))
        {
            if(seleccion2.equals("mm")) num = (float) (num * 1000000);
            else if (seleccion2.equals("cm")) num = (float) (num * 100000);
            else if (seleccion2.equals("dm")) num = (float) (num * 10000);
            else if (seleccion2.equals("m")) num = (float) (num * 1000);
            else if (seleccion2.equals("in")) num = (float) (num * 39370.1);
            else if (seleccion2.equals("ft")) num = (float) (num * 3280.84);
            else if (seleccion2.equals("yd")) num = (float) (num * 1093.61);
            else if (seleccion2.equals("km")) num = num;
            else if (seleccion2.equals("mile")) num = (float) (num *  0.621371);
        }

        else if(seleccion.equals("mile"))
        {
            if(seleccion2.equals("mm")) num = (float) (num * 1609344);
            else if (seleccion2.equals("cm")) num = (float) (num * 160934.4);
            else if (seleccion2.equals("dm")) num = (float) (num * 16093.44);
            else if (seleccion2.equals("m")) num = (float) (num * 1609.34);
            else if (seleccion2.equals("in")) num = (float) (num * 63360);
            else if (seleccion2.equals("ft")) num = (float) (num * 5280);
            else if (seleccion2.equals("yd")) num = (float) (num * 1760);
            else if (seleccion2.equals("km")) num = (float) (num * 1.6093);
            else if (seleccion2.equals("mile")) num = num;
        }

        paso = String.format("%32.6f",num);
        resultado.setText(paso);
    }
}