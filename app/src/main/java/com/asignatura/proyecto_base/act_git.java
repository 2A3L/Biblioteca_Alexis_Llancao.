package com.asignatura.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class act_git extends AppCompatActivity {
    private Spinner sp;
    private TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_git);
        sp = findViewById(R.id.SPMain);
        tx = findViewById(R.id.txtResultSP);


        String[] valores = getIntent().getStringArrayExtra("Valores");
        Integer.parseInt(valores[1]);
        getIntent().getStringArrayExtra("Lista");

        ArrayAdapter a = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getIntent().getStringArrayExtra("Lista"));

        sp.setAdapter(a);

    }

    public void mostrar(View view){
        if(sp.getSelectedItem().equals("Farenheit"))
        {
            tx.setText("El valor de Farenheit es: "+getIntent().getStringArrayExtra("Valores")[0]);
        }
        if(sp.getSelectedItem().equals("Revival"))
        {
            tx.setText("El valor de Revival es: "+getIntent().getStringArrayExtra("Valores")[1]);
        }
        if(sp.getSelectedItem().equals("El Alquimista"))
        {
            tx.setText("El valor de El Alquimista: "+getIntent().getStringArrayExtra("Valores")[2]);
        }
    }
}
