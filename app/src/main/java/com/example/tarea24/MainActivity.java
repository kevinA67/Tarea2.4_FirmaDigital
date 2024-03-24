package com.example.tarea24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tarea24.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;

import Configuracion.SQLiteConexion;
import Configuracion.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText description;
    Button btnSave, btnClean, btnList;
    ImageView image;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.btnLimpiar.setOnClickListener(View -> {
            mainBinding.signatureView.clearCanvas();
            mainBinding.txtDescription.setText("");
        });

        mainBinding.btnGuardar.setOnClickListener(View -> {
            salvarData();
        });

        mainBinding.btnLista.setOnClickListener(View -> {
            Intent intent = new Intent(getApplicationContext(), ActivityList.class);
            startActivity(intent);
        });


    }

    public void salvarData() {
        Bitmap signBitmap = mainBinding.signatureView.getSignatureBitmap();

        if (mainBinding.txtDescription.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Favor llenar todos los campos.", Toast.LENGTH_LONG).show();
        } else {
            //mainBinding.imageView.setImageBitmap(signBitmap);
            SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.DBName, null, 1);
            SQLiteDatabase db = conexion.getWritableDatabase();
            ContentValues datos = new ContentValues();
            datos.put(Transacciones.description, mainBinding.txtDescription.getText().toString());
            datos.put(Transacciones.firma, ConvertImageBase64(signBitmap));

            Long resultado = db.insert(Transacciones.TableFirmas, Transacciones.id, datos);

            Toast.makeText(getApplicationContext(), "Firma registrada correctamente " + resultado.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }


    private String ConvertImageBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] imageArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(imageArray, Base64.DEFAULT);
    }

}