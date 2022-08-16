package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btSendEmail, btAgendar, btGps, btcam, btunit, btañadircon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSendEmail = (Button) findViewById(R.id.sendEmail);
        btAgendar = (Button) findViewById(R.id.agendaEntrega);
        btGps = (Button) findViewById(R.id.gps);
        btcam = (Button) findViewById(R.id.cam);
        btunit = (Button) findViewById(R.id.unitConverted);
        btañadircon = (Button) findViewById(R.id.addContacto);

        btSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irActividadenviaemail();
            }
        });

        btAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irActividadAddEventoCalendario();
            }
        });

        btGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irActividadUbicacionGPS();
            }
        });

        btcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isActividadTomarPic();
            }
        });

        btunit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAcyividadUnitConverted();
            }
        });

        btañadircon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irActividadañadirContacto();
            }
        });

    }

    private void irActividadañadirContacto() {
        Intent intent = new Intent(MainActivity.this, AgregarContacto.class);
        startActivity(intent);
    }

    private void irActividadenviaemail() {
        Intent intent = new Intent(MainActivity.this, enviaemail.class);
        startActivity(intent);
    }

    private void irActividadAddEventoCalendario() {
        Intent intent = new Intent(MainActivity.this, AddEventoCalendario.class);
        startActivity(intent);
    }

    private void irActividadUbicacionGPS() {
        Intent intent = new Intent(MainActivity.this, UbicacionGPS.class);
        startActivity(intent);
    }

    private void isActividadTomarPic() {
        Intent intent = new Intent(MainActivity.this, TomarPic.class);
        startActivity(intent);
    }

    private void irAcyividadUnitConverted() {
        Intent intent = new Intent(MainActivity.this, UnitConverted.class);
        startActivity(intent);
    }

}
