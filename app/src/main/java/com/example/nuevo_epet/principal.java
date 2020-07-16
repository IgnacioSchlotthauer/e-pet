package com.example.nuevo_epet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class principal extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        tv=(TextView)findViewById(R.id.et_visor);
        Bundle b=getIntent().getExtras();
        String nom= b.getString("nombre");
        String ape=b.getString("apellido");
        tv.setText("Hola "+nom+" "+ape );
    }
    public void Salir(View v){
        Intent i=new Intent(Intent.ACTION_MAIN);
        finish();
    }
}
