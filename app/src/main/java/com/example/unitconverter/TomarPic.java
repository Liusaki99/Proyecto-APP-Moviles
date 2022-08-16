package com.example.unitconverter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.util.Base64;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unitconverter.databinding.ActivityTomarPicBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class TomarPic extends AppCompatActivity {

    ActivityTomarPicBinding binding;

    TextView nombre, apellidoP, telefonoCel, telefonoCas, email,direccion;

    Handler handler = new Handler();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTomarPicBinding .inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        nombre = (TextView) findViewById(R.id.nombrestv);
        apellidoP = (TextView) findViewById(R.id.aptv);
        telefonoCel = (TextView) findViewById(R.id.celulartv);
        telefonoCas = (TextView) findViewById(R.id.casatv);
        email = (TextView) findViewById(R.id.emailtv);
        direccion = (TextView) findViewById(R.id.direcciontv);

        new fetchData().start();

        binding.salvartv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarMenuPrincipal();
            }
        });
    }

    private void regresarMenuPrincipal() {
        Intent intent = new Intent(TomarPic.this, MainActivity.class);
        startActivity(intent);
    }

    class fetchData extends Thread{

        String data = "";
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(TomarPic.this);
                    progressDialog.setMessage("Obteniendo Datos");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });
            super.run();
            //URL url = new URL("https://api.npoint.io/5906b0715d4617bda052"); npoint URL url = new URL("https://data.fixer.io/api/lates ? access_key = CHu7Cefl67w9GAl0Y9ivhKqSveE4Vyxw");
            try {
                URL url = new URL("https://servidor2jsonapiemma.herokuapp.com/usuario");
                HttpURLConnection httpURLConnection = (HttpURLConnection)  url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String line;

                while((line = bufferedReader.readLine()) != null){
                    data += line;
                }

                // ve si la informacion esta vacia o no

                if(!data.isEmpty()){
                    JSONObject jsonObject = new JSONObject(data);


                    String fotoencript = jsonObject.getString("foto");
                    String Nombre = jsonObject.getString("nombres");
                    String Apellido = jsonObject.getString("apellidoP");
                    String Telefonocel = jsonObject.getString("telefonoCelular");
                    String Telefonocas = jsonObject.getString("telefonoCasa");
                    String Email = jsonObject.getString("email");
                    String Direccion = jsonObject.getString("direccion");

                    byte[] decodedString = Base64.decode(fotoencript, Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                    //setearpi(decodedByte);
                    nombre.setText(Nombre);
                    apellidoP.setText(Apellido);
                    telefonoCel.setText(Telefonocel);
                    telefonoCas.setText(Telefonocas);
                    email.setText(Email);
                    direccion.setText(Direccion);

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }
                }
            });
        }
    }

    private void setearpi(Bitmap decodedByte) {

        binding.imagentv.setImageBitmap(decodedByte);

    }

}