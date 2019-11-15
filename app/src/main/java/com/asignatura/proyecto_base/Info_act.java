package com.asignatura.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Info_act extends AppCompatActivity {

    private TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        txtInfo = findViewById(R.id.txtInfo);
        txtInfo.setText("Biblioteca virtual, aplicación donde \n " +
                "podrás analizar profundamente\n " +
                "el contenido de los libros utilizando QR,\n " +
                "no te preocupes porque ahora podrás \n " +
                "organizar tus búsquedas virtuales y \n " +
                "asignar diversos roles por usuarios \n " +
                "según la categoria del libro que quieras \n " +
                "encontrar.  además te prometemos \n " +
                "la gestión de Base de datos con los \n " +
                "mejores libros de la semana y la mejor\n " +
                "seguridad para el acceso de datos\n " +
                " y títulos mas comprometedores, \n " +
                "utilizaremos algoritmos de encriptación \n " +
                "y manejaremos su correcto uso,\n " +
                " Gracias por usar Biblioteca Virtual. \n ");
    }
}
