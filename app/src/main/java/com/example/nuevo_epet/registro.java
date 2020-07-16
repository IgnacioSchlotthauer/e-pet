package com.example.nuevo_epet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {
//nombre, apellido, telefono, coorreo, contrasena
    private EditText nom,ape,tel,ce,contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nom=(EditText)findViewById(R.id.a_nombre);
        ape=(EditText)findViewById(R.id.et_ape);
        tel=(EditText)findViewById(R.id.et_telefono);
        ce=(EditText)findViewById(R.id.et_correo);
        contra=(EditText)findViewById(R.id.et_contrasena);
    }

    public void registrar(View v) {
        AdminSQLiteOpenHelper a= new AdminSQLiteOpenHelper(this,
                "EPET", null, 1);
        SQLiteDatabase bd = a.getWritableDatabase();





        String nombre = nom.getText().toString();
        String apellido = ape.getText().toString();
        String telefono = tel.getText().toString();
        String email = ce.getText().toString();
        String contrasena = contra.getText().toString();

        if(nombre.length()==0 || apellido.length()==0 ||telefono.length()==0 ||email.length()==0 ||contrasena.length()==0){
            Toast.makeText(this, "Ningún campo puede quedar vacío",
                    Toast.LENGTH_SHORT).show();
        }else {
            ContentValues registro = new ContentValues();
            //  "CREATE TABLE usuarios (id_usuario  INTEGER PRIMARY KEY AUTOINCREMENT,nombre varchar(255),apellido varchar(255),telefono varchar(255),email varchar(255),contrasena varchar(255))"
            registro.put("nombre", nombre);
            registro.put("apellido", apellido);
            registro.put("telefono", telefono);
            registro.put("email", email);
            registro.put("contrasena", contrasena);
            bd.insert("usuarios", null, registro);
            bd.close();

            nom.setText(" ");
            ape.setText(" ");
            tel.setText(" ");
            ce.setText(" ");
            contra.setText(" ");
            Toast.makeText(this, "Se cargaron los datos de la persona",
                    Toast.LENGTH_SHORT).show();
            IraLogIn(v);

        }
    }

    public void IraLogIn(View v){
        Intent i=new Intent(this, LogIn.class);
        startActivity(i);
    }
}
