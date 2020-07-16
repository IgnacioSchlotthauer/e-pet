package com.example.nuevo_epet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    private EditText et_correo,et_contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        et_correo=(EditText)findViewById(R.id.et_correo);
        et_contrasena=(EditText)findViewById(R.id.et_contrasena);
    }
    public void IniciarSesion(View v) {
      //  "CREATE TABLE usuarios (id_usuario  INTEGER PRIMARY KEY AUTOINCREMENT,nombre varchar(255),apellido varchar(255),telefono varchar(255),email varchar(255),contrasena varchar(255))"
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "EPET", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usuario = et_correo.getText().toString();
        String contrasena = et_contrasena.getText().toString();
        String[] argumentos={usuario,contrasena};
        String[] columnas={"nombre","apellido"};
        Cursor fila = bd.query("usuarios",columnas,"email=? and contrasena=?",argumentos,null,null,null   );
        if (fila.moveToFirst()) {
            fila.moveToFirst();
            Toast.makeText(this, "Iniciando...   "+fila.getString(0),
                    Toast.LENGTH_SHORT).show();
                String nombreu=fila.getString(0);
                String apellidp=fila.getString(1);
                Intent i=new Intent(this, principal.class);
                i.putExtra("nombre",nombreu);
                i.putExtra("apellido",apellidp);
                startActivity(i);


        } else{
            Toast.makeText(this, "Datos incorrectos",
                    Toast.LENGTH_SHORT).show();}
        bd.close();
    }

    public void IraRegistro(View v){
        Intent i=new Intent(this, registro.class);
        startActivity(i);
    }
}
