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

public class Fragmento4 extends Fragment implements View.OnClickListener{

    TextView resultado;
    EditText numero;
    Button botona;
    float num;
    String paso, seleccion, seleccion2;
    Spinner spinner, spinner2;

    public Fragmento4() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragmento4, container, false);
        numero = (EditText) v.findViewById(R.id.numero);
        resultado = (TextView) v.findViewById(R.id.numeroImprimir);
        botona = (Button) v.findViewById(R.id.boton2a);
        spinner = (Spinner) v.findViewById(R.id.spinner); //implementacion de spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.volumen, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
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

        if(seleccion.equals("ml(cc)")){
            if(seleccion2.equals("ml(cc)")) num = num * 1;
            else if(seleccion2.equals("dl")) num = (float) (num * 0.01);
            else if(seleccion2.equals("l")) num = (float) (num * 0.001);
            else if(seleccion2.equals("mm3")) num = num * 1000;
            else if(seleccion2.equals("cm3")) num = num * 1;
            else if(seleccion2.equals("dm3")) num = (float) (num * 0.001);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("in3")) num = (float) (num * 0.061024);
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.000035);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("gal")) num = (float) (num * 0.000264);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 0.033814);
        }

        else if(seleccion.equals("dl")){
            if(seleccion2.equals("ml(cc)")) num = num * 100;
            else if(seleccion2.equals("dl")) num = num * 1;
            else if(seleccion2.equals("l")) num = (float) (num * 0.1);
            else if(seleccion2.equals("mm3")) num = num * 100000;
            else if(seleccion2.equals("cm3")) num = num * 100;
            else if(seleccion2.equals("dm3")) num = (float) (num * 0.1);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.0001);
            else if(seleccion2.equals("in3")) num = (float) (num * 6.102374);
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.003531);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.000131);
            else if(seleccion2.equals("gal")) num = (float) (num * 0.026417);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 3.381402);
        }

        else if(seleccion.equals("l")){
            if(seleccion2.equals("ml(cc)")) num = num * 1000;
            else if(seleccion2.equals("dl")) num = num * 10;
            else if(seleccion2.equals("l")) num = num * 1;
            else if(seleccion2.equals("mm3")) num = num * 1000000;
            else if(seleccion2.equals("cm3")) num = num * 1000;
            else if(seleccion2.equals("dm3")) num = num * 1;
            else if(seleccion2.equals("m3")) num = (float) (num * 0.001);
            else if(seleccion2.equals("in3")) num = (float) (num * 61.023744);
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.035315);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.001308);
            else if(seleccion2.equals("gal")) num = (float) (num * 0.264172);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 33.814023);
        }

        else if(seleccion.equals("mm3")){
            if(seleccion2.equals("ml(cc)")) num = (float) (num * 0.001);
            else if(seleccion2.equals("dl")) num = (float) (num * 0.00001);
            else if(seleccion2.equals("l")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("mm3")) num = num * 1;
            else if(seleccion2.equals("cm3")) num = (float) (num * 0.001);
            else if(seleccion2.equals("dm3")) num = (float) (num * 0.000061);
            else if(seleccion2.equals("m3")) num = (float) (num * 1e-9);
            else if(seleccion2.equals("in3")) num = (float) (num * 0.000061);
            else if(seleccion2.equals("ft3")) num = (float) (num * 3.5315e-8);
            else if(seleccion2.equals("yd3")) num = (float) (num * 1.308e-9);
            else if(seleccion2.equals("gal")) num = (float) (num * 2.6417e-7);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 0.000034);
        }

        else if(seleccion.equals("cm3")){
            if(seleccion2.equals("ml(cc)")) num = num * 1;
            else if(seleccion2.equals("dl")) num = (float) (num * 0.01);
            else if(seleccion2.equals("l")) num = (float) (num * 0.001);
            else if(seleccion2.equals("mm3")) num = num * 1000;
            else if(seleccion2.equals("cm3")) num = num * 1;
            else if(seleccion2.equals("dm3")) num = (float) (num * 0.001);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("in3")) num = (float) (num * 0.061024);
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.000035);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.000001);
            else if(seleccion2.equals("gal")) num = (float) (num * 0.000264);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 0.033814);
        }

        else if(seleccion.equals("dm3")){
            if(seleccion2.equals("ml(cc)")) num = num * 1000;
            else if(seleccion2.equals("dl")) num = num * 10;
            else if(seleccion2.equals("l")) num = num * 1;
            else if(seleccion2.equals("mm3")) num = num * 1000000;
            else if(seleccion2.equals("cm3")) num = num * 1000;
            else if(seleccion2.equals("dm3")) num = num * 1;
            else if(seleccion2.equals("m3")) num = (float) (num * 0.001);
            else if(seleccion2.equals("in3")) num = (float) (num * 61.023744);
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.035315);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.001308);
            else if(seleccion2.equals("gal")) num = (float) (num * 0.264172);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 33.814023);
        }

        else if(seleccion.equals("m3")){
            if(seleccion2.equals("ml(cc)")) num = num * 1000000;
            else if(seleccion2.equals("dl")) num = num * 10000;
            else if(seleccion2.equals("l")) num = num * 1000;
            else if(seleccion2.equals("mm3"))num = num * 1000000000;
            else if(seleccion2.equals("cm3")) num = num * 1000000;
            else if(seleccion2.equals("dm3")) num = num * 1000;
            else if(seleccion2.equals("m3")) num = num * 1;
            else if(seleccion2.equals("in3")) num = (float) (num * 61023.7441);
            else if(seleccion2.equals("ft3")) num = (float) (num * 35.314667);
            else if(seleccion2.equals("yd3")) num = (float) (num * 1.307951);
            else if(seleccion2.equals("gal")) num = (float) (num * 264.172052);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 33814.0227);
        }

        else if(seleccion.equals("in3")){
            if(seleccion2.equals("ml(cc)")) num = (float) (num * 16.387064);
            else if(seleccion2.equals("dl")) num = (float) (num * 0.163871);
            else if(seleccion2.equals("l")) num = (float) (num * 0.016387);
            else if(seleccion2.equals("mm3")) num = (float) (num * 16387.064);
            else if(seleccion2.equals("cm3")) num = (float) (num * 16.387064);
            else if(seleccion2.equals("dm3")) num = (float) (num * 0.016387);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.000016);
            else if(seleccion2.equals("in3")) num = num * 1;
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.000579);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.000021);
            else if(seleccion2.equals("gal")) num = (float) (num * 0.004329);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 0.554113);
        }

        else if(seleccion.equals("ft3")){
            if(seleccion2.equals("ml(cc)")) num = (float) (num * 28316.8466);
            else if(seleccion2.equals("dl")) num = (float) (num * 283.168466);
            else if(seleccion2.equals("l")) num = (float) (num * 28.168466);
            else if(seleccion2.equals("mm3")) num = (float) (num * 28316846.6);
            else if(seleccion2.equals("cm3")) num = (float) (num * 28316.8466);
            else if(seleccion2.equals("dm3")) num = (float) (num * 28.316847);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.028317);
            else if(seleccion2.equals("in3")) num = num * 1728;
            else if(seleccion2.equals("ft3")) num = num * 1;
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.037037);
            else if(seleccion2.equals("gal")) num = (float) (num * 7.480519);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 957.506494);
        }

        else if(seleccion.equals("yd3")){
            if(seleccion2.equals("ml(cc)")) num = (float) (num * 764554.858);
            else if(seleccion2.equals("dl")) num = (float) (num * 7645.54858);
            else if(seleccion2.equals("l")) num = (float) (num * 764.554858);
            else if(seleccion2.equals("mm3")) num = num * 764554858;
            else if(seleccion2.equals("cm3")) num = (float) (num * 764554.858);
            else if(seleccion2.equals("dm3")) num = (float) (num * 764.554858);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.764555);
            else if(seleccion2.equals("in3")) num = num * 4656;
            else if(seleccion2.equals("ft3")) num = num * 27;
            else if(seleccion2.equals("yd3")) num = num * 1;
            else if(seleccion2.equals("gal")) num = (float) (num * 201.974026);
            else if(seleccion2.equals("fl oz")) num = (float) (num * 25852.6753);
        }

        else if(seleccion.equals("gal")){
            if(seleccion2.equals("ml(cc)")) num = (float) (num * 3785.41178);
            else if(seleccion2.equals("dl")) num = (float) (num * 37.854118);
            else if(seleccion2.equals("l")) num = (float) (num * 3.785412);
            else if(seleccion2.equals("mm3")) num = (float) (num * 3785411.78);
            else if(seleccion2.equals("cm3")) num = (float) (num * 3785.41178);
            else if(seleccion2.equals("dm3")) num = (float) (num * 3.785412);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.003785);
            else if(seleccion2.equals("in3")) num = num * 231;
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.133681);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.004951);
            else if(seleccion2.equals("gal")) num = num * 1;
            else if(seleccion2.equals("fl oz")) num = num * 128;
        }

        else if(seleccion.equals("fl oz")){
            if(seleccion2.equals("ml(cc)")) num = (float) (num * 29.57353);
            else if(seleccion2.equals("dl")) num = (float) (num * 0.295735);
            else if(seleccion2.equals("l")) num = (float) (num * 0.029574);
            else if(seleccion2.equals("mm3")) num = (float) (num * 29573.5296);
            else if(seleccion2.equals("cm3")) num = (float) (num * 29.57353);
            else if(seleccion2.equals("dm3")) num = (float) (num * 0.029574);
            else if(seleccion2.equals("m3")) num = (float) (num * 0.00003);
            else if(seleccion2.equals("in3")) num = (float) (num * 1.804688);
            else if(seleccion2.equals("ft3")) num = (float) (num * 0.001044);
            else if(seleccion2.equals("yd3")) num = (float) (num * 0.000039);
            else if(seleccion2.equals("gal")) num = (float) (num * 0.007812);
            else if(seleccion2.equals("fl oz")) {
                num = num * 1;
            }
        }

        paso = String.format("%32.6f",num);
        resultado.setText(paso);

    }
}