package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.GregorianCalendar;

public class AddEventoCalendario extends AppCompatActivity {

    EditText titulo, destino,mensaje;
    Button enviar;
    DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evento_calendario);

        titulo = (EditText) findViewById(R.id.titulo);
        destino = (EditText) findViewById(R.id.destino);
        mensaje = (EditText) findViewById(R.id.mensaje);

        picker = (DatePicker) findViewById(R.id.picker);

        enviar = (Button) findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarmensaje();
            }
        });

    }

    private void enviarmensaje() {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        GregorianCalendar fecha = new GregorianCalendar(picker.getYear(), picker.getMonth(),picker.getDayOfMonth());
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, titulo.getText().toString());
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, destino.getText().toString());
        intent.putExtra(CalendarContract.Events.DESCRIPTION, mensaje.getText().toString());
        intent.putExtra(CalendarContract.Events.ALL_DAY, true);
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, fecha.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, fecha.getTimeInMillis());
        startActivity(intent);
    }
}