package com.asignatura.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Libros_act extends AppCompatActivity {

    private EditText etStock, etPrestamo;
    private TextView result;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_act);
        etStock = findViewById(R.id.etStock);
        etPrestamo = findViewById(R.id.etPrestamo);
        result = findViewById(R.id.txtResult);
        sp = findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getIntent().getStringArrayExtra("String"));
        sp.setAdapter(adapter);
    }
    public void calcular(View view)
    {
        if(sp.getSelectedItem().equals("Farenheit"))
        {
            result.setText("Precio final: "+String.valueOf(((5000*Integer.parseInt(etStock.getText().toString())+Integer.parseInt(etPrestamo.getText().toString())))));
        }
        if(sp.getSelectedItem().equals("Revival"))//Se cambió de 12000 a 12575
        {
            result.setText("Precio final: "+String.valueOf(((12575*Integer.parseInt(etStock.getText().toString())+Integer.parseInt(etPrestamo.getText().toString())))));

        }
        if(sp.getSelectedItem().equals("Tesla"))//Se cambió de 25000 a 27500
        {
            result.setText("Precio final: "+String.valueOf(((27500*Integer.parseInt(etStock.getText().toString())+Integer.parseInt(etPrestamo.getText().toString())))));
        }
    }
}
