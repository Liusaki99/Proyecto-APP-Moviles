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
import android.widget.Toast;


public class Fragmento2 extends Fragment implements View.OnClickListener {

    TextView resultado;
    EditText numero;
    Button botona;
    float num;
    String paso, seleccion, seleccion2;
    Spinner spinner, spinner2;

    public Fragmento2() {
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
        View v = inflater.inflate(R.layout.fragment_fragmento2, container, false);
        numero = (EditText) v.findViewById(R.id.numero);
        resultado = (TextView) v.findViewById(R.id.numeroImprimir);
        botona = (Button) v.findViewById(R.id.boton2a);
        spinner = (Spinner) v.findViewById(R.id.spinner); //implementacion de spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.area, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
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

        if(seleccion.equals("m^2"))
        {
            if(seleccion2.equals("mm^2")) num = num * 1000000;
            else if (seleccion2.equals("cm^2")) num = num * 10000;
            else if (seleccion2.equals("dm^2")) num = num * 100;
            else if (seleccion2.equals("m^2")) num =  num;
            else if (seleccion2.equals("in^2")) num = num *1550;
            else if (seleccion2.equals("ft^2")) num = (float) (num * 10.7639);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 1.19599);
            else if (seleccion2.equals("a")) num = (float) (num * 0.010000);
            else if (seleccion2.equals("ha")) num = (float) (num * 0.0001);
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.000001);
            else if (seleccion2.equals("acre")) num = (float) (num * 0.000247105);
            else if (seleccion2.equals("mile^2")) num = (float) (num *  0.0000003861);
        }
        else if (seleccion.equals("mm^2"))
        {
            if(seleccion2.equals("mm^2")) num = num;
            else if (seleccion2.equals("cm^2")) num = (float) (num * 0.01);
            else if (seleccion2.equals("dm^2")) num = num / 1000;
            else if (seleccion2.equals("m^2")) num =  num / 10000000;
            else if (seleccion2.equals("in^2")) num = (float) (num * 0.00155);
            else if (seleccion2.equals("ft^2")) num = (float) (num / 92900);
            else if (seleccion2.equals("yd^2")) num = (float) (num / 836100);
            else if (seleccion2.equals("a")) num = (float) (num / 100000000);
            else if (seleccion2.equals("ha")) num = (float) (num / (10000000000.00));
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.000000000001);
            else if (seleccion2.equals("acre")) num = (float) (num / 4046856422.4);
            else if (seleccion2.equals("mile^2")) num = (float) (num *  0.0000000000003861);
        }

	else if (seleccion.equals("cm^2"))
        {
            if(seleccion2.equals("mm^2")) num = num * 100;
            else if (seleccion2.equals("cm^2")) num = num;
            else if (seleccion2.equals("dm^2")) num = (float) (num * 0.01);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 0.0001);
            else if (seleccion2.equals("in^2")) num = (float) (num * 0.155);
            else if (seleccion2.equals("ft^2")) num = (float) (num * 0.00107639);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 0.000119599);
            else if (seleccion2.equals("a")) num = (float) (num / 1000000);
            else if (seleccion2.equals("ha")) num = (float) (num * 0.00000001);
            else if (seleccion2.equals("km^2")) num = (float) (num / 10000000000.00);
            else if (seleccion2.equals("acre")) num = (float) (num / 40468564.224);
            else if (seleccion2.equals("mile^2")) num = (float) (num / 25899881103.36);
        }

	else if (seleccion.equals("dm^2"))
        {
            if(seleccion2.equals("mm^2")) num = num * 10000;
            else if (seleccion2.equals("cm^2")) num = num * 100;
            else if (seleccion2.equals("dm^2")) num = num;
            else if (seleccion2.equals("m^2")) num =  (float) (num * 0.01);
            else if (seleccion2.equals("in^2")) num = (float) (num * 15.5);
            else if (seleccion2.equals("ft^2")) num = (float) (num * 0.107639);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 0.0119599);
            else if (seleccion2.equals("a")) num = (float) (num * 0.01);
            else if (seleccion2.equals("ha")) num = (float) (num / 1000000);
            else if (seleccion2.equals("km^2")) num = (float) (num / 100000000);
            else if (seleccion2.equals("acre")) num = (float) (num / 404685.64224);
            else if (seleccion2.equals("mile^2")) num = (float) (num / 258998811.0336);
        }

	else if (seleccion.equals("in^2"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 645.16);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 6.4516);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 0.064516);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 0.00064516);
            else if (seleccion2.equals("in^2")) num = num;
            else if (seleccion2.equals("ft^2")) num = (float) (num * 0.00694444);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 0.000771605);
            else if (seleccion2.equals("a")) num = (float) (num * 0.0000064516);
            else if (seleccion2.equals("ha")) num = (float) (num / 15500031.000062);
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.00000000064516);
            else if (seleccion2.equals("acre")) num = (float) (num / 6272640);
            else if (seleccion2.equals("mile^2")) num = (float) (num * 0.000000000249097);
        }

	else if (seleccion.equals("ft^2"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 92903);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 929.03);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 9.2903);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 0.092903);
            else if (seleccion2.equals("in^2")) num = num * 144;
            else if (seleccion2.equals("ft^2")) num = num;
            else if (seleccion2.equals("yd^2")) num = (float) (num * 0.111111);
            else if (seleccion2.equals("a")) num = (float) (num * 0.0009290304);
            else if (seleccion2.equals("ha")) num = (float) (num * 0.00000929);
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.00000009);
            else if (seleccion2.equals("acre")) num = (float) (num * 0.00002296);
            else if (seleccion2.equals("mile^2")) num = (float) (num / 27878400 );
        }

	else if (seleccion.equals("yd^2"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 836127);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 8361.27);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 83.6127);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 0.836127);
            else if (seleccion2.equals("in^2")) num = num * 1296;
            else if (seleccion2.equals("ft^2")) num = num * 9;
            else if (seleccion2.equals("yd^2")) num = num;
            else if (seleccion2.equals("a")) num = (float) (num * 0.008361);
            else if (seleccion2.equals("ha")) num = (float) (num / 11960.2918311);
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.00000083612736);
            else if (seleccion2.equals("acre")) num = (float) (num * 0.000206612);
            else if (seleccion2.equals("mile^2")) num = (float) (num / 3097600);
        }

	else if (seleccion.equals("a"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 100000000.00);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 1000000);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 10000);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 100);
            else if (seleccion2.equals("in^2")) num = (float) (num * 155000.31);
            else if (seleccion2.equals("ft^2")) num = (float) (num * 1076.3910);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 119.5990);
            else if (seleccion2.equals("a")) num = num;
            else if (seleccion2.equals("ha")) num = (float) (num * 0.01);
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.0001);
            else if (seleccion2.equals("acre")) num = (float) (num * 0.024710);
            else if (seleccion2.equals("mile^2")) num = (float) (num * 0.00003861);
        }

	else if (seleccion.equals("ha"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 10000000000.00);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 100000000.00);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 1000000);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 10000);
            else if (seleccion2.equals("in^2")) num = (float) (num * 15500031.00);
            else if (seleccion2.equals("ft^2")) num = (float) (num * 107639);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 11959.9);
            else if (seleccion2.equals("a")) num = num * 100;
            else if (seleccion2.equals("ha")) num = num;
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.01);
            else if (seleccion2.equals("acre")) num = (float) (num * 2.47105);
            else if (seleccion2.equals("mile^2")) num = (float) (num * 0.00386102);
        }

	else if (seleccion.equals("km^2"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 1000000000000.00);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 10000000000.00);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 100000000.00);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 1000000);
            else if (seleccion2.equals("in^2")) num = (float) (num * 1550003100.0061);
            else if (seleccion2.equals("ft^2")) num = (float) (num * 10763910.4167);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 1195990.0463);
            else if (seleccion2.equals("a")) num = num * 10000;
            else if (seleccion2.equals("ha")) num = num * 100;
            else if (seleccion2.equals("km^2")) num = num;
            else if (seleccion2.equals("acre")) num = (float) (num * 247.105);
            else if (seleccion2.equals("mile^2")) num = (float) (num * 0.386102);
        }

	else if (seleccion.equals("acre"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 4046856422.4);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 40468564.224);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 404686);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 4046.86);
            else if (seleccion2.equals("in^2")) num = (float) (num * 6272640);
            else if (seleccion2.equals("ft^2")) num = (float) (num * 43560);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 4840);
            else if (seleccion2.equals("a")) num = (float) (num * 40.47);
            else if (seleccion2.equals("ha")) num = (float) (num * 0.404686);
            else if (seleccion2.equals("km^2")) num = (float) (num * 0.00404686);
            else if (seleccion2.equals("acre")) num = num;
            else if (seleccion2.equals("mile^2")) num = (float) (num * 0.386102);
        }

	else if (seleccion.equals("mile^2"))
        {
            if(seleccion2.equals("mm^2")) num = (float) (num * 2589988110336.00);
            else if (seleccion2.equals("cm^2")) num = (float) (num * 25898460000.00);
            else if (seleccion2.equals("dm^2")) num = (float) (num * 258998811.0336);
            else if (seleccion2.equals("m^2")) num =  (float) (num * 2589846.00);
            else if (seleccion2.equals("in^2")) num = (float) (num * 4014500000.00);
            else if (seleccion2.equals("ft^2")) num = (float) (num * 27878501.00);
            else if (seleccion2.equals("yd^2")) num = (float) (num * 3097600.00);
            else if (seleccion2.equals("a")) num = (float) (num * 25898.46);
            else if (seleccion2.equals("ha")) num = (float) (num * 258.999);
            else if (seleccion2.equals("km^2")) num = (float) (num * 2.58999);
            else if (seleccion2.equals("acre")) num = num * 640;
            else if (seleccion2.equals("mile^2")) num = num;
        }

        paso = String.format("%32.6f",num);
        resultado.setText(paso);
    }

}
