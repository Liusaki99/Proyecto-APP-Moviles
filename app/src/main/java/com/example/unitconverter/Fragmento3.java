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

public class Fragmento3 extends Fragment implements View.OnClickListener {

    TextView resultado;
    EditText numero;
    Button boton3a;
    float num;
    String paso, seleccion, seleccion2;
    Spinner spinner, spinner2;

    public Fragmento3() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragmento3, container, false);
        numero = (EditText) v.findViewById(R.id.numero);
        resultado = (TextView) v.findViewById(R.id.numeroImprimir);
        boton3a = (Button) v.findViewById(R.id.boton3a);
        spinner = (Spinner) v.findViewById(R.id.spinner); //implementacion de spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.peso, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
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

        boton3a.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        num = Integer.parseInt(numero.getText().toString());
        Log.i("Estoy en onClick", seleccion);

        if(seleccion.equals("µg")){
            if(seleccion2.equals("µg")) num = num * 1;
            else if(seleccion2.equals("mg")) num = (float) (num * 0.001);
            else if(seleccion2.equals("g")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("kg")) num = (float) (num * 1e-9);
            else if(seleccion2.equals("lb")) num = (float) (num * 2.2046e-9);
            else if(seleccion2.equals("oz")) num = (float) (num * 3.5274e-8);
            else if(seleccion2.equals("grain")) num = (float) (num * 0.000015);
            else if(seleccion2.equals("tonne")) num = (float) (num * 1e-12);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 9.8421e-13);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 1.1023e-12);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 1.5747e-10);
            else if(seleccion2.equals("carat")) num = (float) (num * 0.000005);
        }

        else if(seleccion.equals("mg")){
            if(seleccion2.equals("µg")) num = num * 1000;
            else if(seleccion2.equals("mg")) num = num * 1;
            else if(seleccion2.equals("g")) num = (float) (num * 0.001);
            else if(seleccion2.equals("kg")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("lb"))num = (float) (num * 0.000002);
            else if(seleccion2.equals("oz")) num = (float) (num * 0.000035);
            else if(seleccion2.equals("grain")) num = (float) (num * 0.015432);
            else if(seleccion2.equals("tonne")) num = (float) (num * 1e-9);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 9.8421e-10);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 1.1023e-9);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 1.5747e-7);
            else if(seleccion2.equals("carat")) num = (float) (num * 0.005);
        }

        else if(seleccion.equals("g")){
            if(seleccion2.equals("µg")) num = num * 1000000;
            else if(seleccion2.equals("mg")) num = num * 1000;
            else if(seleccion2.equals("g")) num = num * 1;
            else if(seleccion2.equals("kg")) num = (float) (num * 0.001);
            else if(seleccion2.equals("lb")) num = (float) (num * 0.002205);
            else if(seleccion2.equals("oz")) num = (float) (num * 0.035274);
            else if(seleccion2.equals("grain")) num = (float) (num * 15.432358);
            else if(seleccion2.equals("tonne")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 9.8421e-7);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 0.000157);
            else if(seleccion2.equals("carat")) num = num * 5;
        }

        else if(seleccion.equals("kg")){
            if(seleccion2.equals("µg")) num = num * 1000000000;
            else if(seleccion2.equals("mg")) num = num * 1000000;
            else if(seleccion2.equals("g")) num = num * 1000;
            else if(seleccion2.equals("kg")) num = num * 1;
            else if(seleccion2.equals("lb")) num = (float) (num * 2.204623);
            else if(seleccion2.equals("oz")) num = (float) (num * 35.273962);
            else if(seleccion2.equals("grain")) num = (float) (num * 15432.3584);
            else if(seleccion2.equals("tonne")) num = (float) (num * 0.001);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 0.000984);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 0.001102);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 0.157473);
            else if(seleccion2.equals("carat")) num = num * 5000;
        }

        else if(seleccion.equals("lb")){
            if(seleccion2.equals("µg")) num = num * 453592370;
            else if(seleccion2.equals("mg")) num = (float) (num * 453592.37);
            else if(seleccion2.equals("g")) num = (float) (num * 453.59237);
            else if(seleccion2.equals("kg")) num = (float) (num * 0.453592);
            else if(seleccion2.equals("lb")) num = num * 1;
            else if(seleccion2.equals("oz")) num = num * 16;
            else if(seleccion2.equals("grain")) num = num * 7000;
            else if(seleccion2.equals("tonne")) num = (float) (num * 0.000454);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 0.000446);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 0.0005);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 0.071429);
            else if(seleccion2.equals("carat")) num = (float) (num * 2267.96185);
        }

        else if(seleccion.equals("oz")){
            if(seleccion2.equals("µg")) num = (float) (num * 28349523.1);
            else if(seleccion2.equals("mg")) num = (float) (num * 28349.5231);
            else if(seleccion2.equals("g")) num = (float) (num * 28.349523);
            else if(seleccion2.equals("kg")) num = (float) (num * 0.02835);
            else if(seleccion2.equals("lb")) num = (float) (num * 0.0625);
            else if(seleccion2.equals("oz")) num = num * 1;
            else if(seleccion2.equals("grain")) num = (float) (num * 437.5);
            else if(seleccion2.equals("tonne")) num = (float) (num * 0.000028);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 0.000028);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 0.000031);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 0.004464);
            else if(seleccion2.equals("carat")) num = (float) (num * 141.747616);
        }

        else if(seleccion.equals("grain")){
            if(seleccion2.equals("µg")) num = (float) (num * 64798.91);
            else if(seleccion2.equals("mg")) num = (float) (num * 64.79891);
            else if(seleccion2.equals("g")) num = (float) (num * 0.064799);
            else if(seleccion2.equals("kg")) num = (float) (num * 0.000065);
            else if(seleccion2.equals("lb")) num = (float) (num * 0.000143);
            else if(seleccion2.equals("oz")) num = (float) (num * 0.002286);
            else if(seleccion2.equals("grain")) num = num * 1;
            else if(seleccion2.equals("tonne")) num = (float) (num * 6.4799e-8);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 6.3776e-8);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 7.1429e-8);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 0.00001);
            else if(seleccion2.equals("carat")) num = (float) (num * 0.323995);
        }

        else if(seleccion.equals("tonne")){
            if(seleccion2.equals("µg")) num = (float) (num * 1.000e+12);
            else if(seleccion2.equals("mg")) num = num * 1000000000;
            else if(seleccion2.equals("g")) num = num * 1000000;
            else if(seleccion2.equals("kg")) num = num * 1000;
            else if(seleccion2.equals("lb")) num = (float) (num * 2204.62262);
            else if(seleccion2.equals("oz")) num = (float) (num * 35273.9619);
            else if(seleccion2.equals("grain")) num = (float) (num * 15432358.4);
            else if(seleccion2.equals("tonne")) num = num * 1;
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 0.984207);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 1.102311);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 157.473044);
            else if(seleccion2.equals("carat")) num = num * 5000000;
        }

        else if(seleccion.equals("ton(UK)")){
            if(seleccion2.equals("µg")) num = (float) (num * 1.016e+12);
            else if(seleccion2.equals("mg")) num = num * 1016046909;
            else if(seleccion2.equals("g")) num = (float) (num * 1016046.91);
            else if(seleccion2.equals("kg")) num = (float) (num * 1016.04691);
            else if(seleccion2.equals("lb")) num = num * 2240;
            else if(seleccion2.equals("oz")) num = num * 35840;
            else if(seleccion2.equals("grain")) num = num * 15680000;
            else if(seleccion2.equals("tonne")) num = (float) (num * 1.016047);
            else if(seleccion2.equals("ton(UK)")) num = num * 1;
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 1.12);
            else if(seleccion2.equals("stone(UK)")) num = num * 160;
            else if(seleccion2.equals("carat")) num = (float) (num * 5080234.54);
        }

        else if(seleccion.equals("ton(US)")){
            if(seleccion2.equals("µg")) num = (float) (num * 9.072e+11);
            else if(seleccion2.equals("mg")) num = num * 907184740;
            else if(seleccion2.equals("g")) num = (float) (num * 907184.74);
            else if(seleccion2.equals("kg")) num = (float) (num * 907.18474);
            else if(seleccion2.equals("lb")) num = num * 2000;
            else if(seleccion2.equals("oz")) num = num * 32000;
            else if(seleccion2.equals("grain")) num = (float) (num * 29166.6667);
            else if(seleccion2.equals("tonne")) num = (float) (num * 0.907185);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 0.892857);
            else if(seleccion2.equals("ton(US)")) num = num * 1;
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 142.857143);
            else if(seleccion2.equals("carat")) num = (float) (num * 4535923.7);
        }

        else if(seleccion.equals("stone(UK)")){
            if(seleccion2.equals("µg")) num = (float) (num * 635029318e+1);
            else if(seleccion2.equals("mg")) num = (float) (num * 6350293.18);
            else if(seleccion2.equals("g")) num = (float) (num * 6350.29318);
            else if(seleccion2.equals("kg")) num = (float) (num * 6.350293);
            else if(seleccion2.equals("lb")) num = num * 14;
            else if(seleccion2.equals("oz")) num = num * 224;
            else if(seleccion2.equals("grain")) num = num *98000;
            else if(seleccion2.equals("tonne")) num = (float) (num * 0.00635);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 0.00625);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 0.007);
            else if(seleccion2.equals("stone(UK)")) num = num * 1;
            else if(seleccion2.equals("carat")) num = (float) (num * 31751.4659);
        }

        else if(seleccion.equals("carat")){
            if(seleccion2.equals("µg")) num = num * 200000;
            else if(seleccion2.equals("mg")) num = num * 200;
            else if(seleccion2.equals("g")) num = (float) (num * 0.2);
            else if(seleccion2.equals("kg")) num = (float) (num * 0.0002);
            else if(seleccion2.equals("lb")) num = (float) (num * 0.000441);
            else if(seleccion2.equals("oz")) num = (float) (num * 0.007055);
            else if(seleccion2.equals("grain")) num = (float) (num * 3.086472);
            else if(seleccion2.equals("tonne")) num = (float) (num * 2e-7);
            else if(seleccion2.equals("ton(UK)")) num = (float) (num * 1.9684e-7);
            else if(seleccion2.equals("ton(US)")) num = (float) (num * 2.2046e-7);
            else if(seleccion2.equals("stone(UK)")) num = (float) (num * 0.000031);
            else if(seleccion2.equals("carat")) num = num * 1;
        }

        paso = String.format("%32.6f",num);
        resultado.setText(paso);
    }
}