package com.example.unitconverter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Base64;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unitconverter.databinding.ActivityAgregarContactoBinding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;



public class AgregarContacto extends AppCompatActivity {

    @NonNull ActivityAgregarContactoBinding binding;

    EditText nombre, apellidoP, telefonoCel, telefonoCas, email,direccion;

    private static final int IMAGE_PICK_GALLERY_CODE = 200;
    String encodedImage;
    private Uri image_uri;
    Handler handler = new Handler();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAgregarContactoBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        nombre = (EditText) findViewById(R.id.nombres);
        apellidoP = (EditText) findViewById(R.id.ap);
        telefonoCel = (EditText) findViewById(R.id.celular);
        telefonoCas = (EditText) findViewById(R.id.casa);
        email = (EditText) findViewById(R.id.email);
        direccion = (EditText) findViewById(R.id.direccion);

        binding.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirGaleria();
            }
        });

        binding.salvar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                codificarpic();
                ServicioTask envio = new ServicioTask(AgregarContacto.this,
                        "https://servidor2jsonapiemma.herokuapp.com/usuario",
                        encodedImage,
                        nombre.getText().toString(),
                        apellidoP.getText().toString(),
                        telefonoCel.getText().toString(),
                        telefonoCas.getText().toString(),
                        email.getText().toString(),
                        direccion.getText().toString());
                envio.execute();
                regresarMenuPrincipal();
            }
        });
    }

    private void regresarMenuPrincipal() {
        Intent intent = new Intent(AgregarContacto.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if(requestCode == IMAGE_PICK_GALLERY_CODE)
            {
                image_uri = data.getData();
                binding.imagen.setImageURI(image_uri);
            }
            else
            {
                Toast.makeText(AgregarContacto.this, "Cancelada", Toast.LENGTH_LONG).show();
            }
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void codificarpic() {

        byte[] imageBytes = imageUriToBytes();

        encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    private byte[] imageUriToBytes() {
        Bitmap bitmap;
        ByteArrayOutputStream baos = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), image_uri);
            baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,baos);
            return baos.toByteArray();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null ;
        }
    }

    private void abrirGaleria() {
        Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galeria, IMAGE_PICK_GALLERY_CODE);
    }



}