package com.asignatura.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class HOME_ACT extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] Image = {R.drawable.a, R.drawable.b, R.drawable.c};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__act);

        vf = findViewById(R.id.slider);

        for (int i= 0; i < Image.length ; i++)
        {
            Instrucciones(Image[i]);
        }
    }


    public void Instrucciones(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2800);
        vf.setAutoStart(true);

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }


    public void Libros(View view)
    {
        Intent i = new Intent(this, Libros_act.class);
        String[] arreglo = {"Farenheit","Revival", "Tesla"};
        i.putExtra("String", arreglo);
        startActivity(i);
    }
    public void info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
    public void base(View view)
    {
        Intent i = new Intent(this, base_act.class);
        startActivity(i);
    }
    public void security(View view)
    {
        Intent i = new Intent(this, Sec_act.class);
        startActivity(i);
    }



}
