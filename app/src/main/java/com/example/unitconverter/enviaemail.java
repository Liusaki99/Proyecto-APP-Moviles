package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class enviaemail extends AppCompatActivity {

    EditText para, asunto, mensaje;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviaemail);

        para = (EditText) findViewById(R.id.para);
        asunto = (EditText) findViewById(R.id.asunto);
        mensaje = (EditText) findViewById(R.id.mensaje);
        boton = (Button) findViewById(R.id.enviar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{para.getText().toString()});
                intent.putExtra(intent.EXTRA_SUBJECT, asunto.getText().toString());
                intent.putExtra(intent.EXTRA_TEXT, mensaje.getText());
                intent.setType("message/rfc/822");
                startActivity(intent.createChooser(intent , "Escoje una aplicacion"));

                para.setText("");
                asunto.setText("");
                mensaje.setText("");

            }
        });

    }

}