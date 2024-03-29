package com.asignatura.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private EditText etContra, etUser;
    private Button btnLogin;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        etContra = findViewById(R.id.etPassword);
        etUser = findViewById(R.id.etUser);
        pb = findViewById(R.id.progressBar);

        pb.setVisibility(View.INVISIBLE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(etUser.getText().toString());
            }
        });

    }
    public void mapa(View view)
    {
        Intent i =  new Intent(this, MapsActivity.class);
        startActivity(i);
    }

    public void github(View view)
    {
        Intent i =  new Intent(this, act_git.class);
        String[] list = {"Farenheit","Revival", "El Alquimista", "El Poder", "Despertar"};
        String[] value = {"7000", "22000", "45000", "88000", "156000"};
        i.putExtra("Lista",  list);
        i.putExtra("Valores",  value);
        startActivity(i);
    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
            btnLogin.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try
            {
                for (int i = 1; i<=5; i++)
                {
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.INVISIBLE);
            btnLogin.setEnabled(true);
            Toast.makeText(getBaseContext(), "logueado correctamente:"+ etUser.getText().toString(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getBaseContext(), HOME_ACT.class);
            startActivity(i);

        }

    }
}
