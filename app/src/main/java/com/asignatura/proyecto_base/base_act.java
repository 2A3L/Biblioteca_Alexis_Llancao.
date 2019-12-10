package com.asignatura.proyecto_base;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class base_act extends AppCompatActivity {

    private EditText et1, et2, et3;
    private TextView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        et1 = (EditText)findViewById(R.id.txtCodigo);
        et2 = (EditText)findViewById(R.id.txtNombre);
        et3 = (EditText)findViewById(R.id.txtPrecio);
    }

    public void eliminar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//Se abre la base de datos

        String codigo = et1.getText().toString();

        BaseDeDatos.delete("libros",  "codigo="+codigo, null);
        BaseDeDatos.close();
        Toast.makeText(this, "Se eliminó correctamente el ordenador con código: "+et1.getText().toString(), Toast.LENGTH_LONG).show();

    }
    public void modificar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//Se abre la base de datos

        ContentValues content = new ContentValues();

        content.put("codigo",et1.getText().toString());
        content.put("nombre", et2.getText().toString());
        content.put("precio", et3.getText().toString());

        if (!et1.getText().toString().isEmpty()) {
            BaseDeDatos.update("libros", content, "codigo="+et1.getText().toString(), null);
            Toast.makeText(this, "Se actualizó el producto correctamente" , Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Este producto no se pudo actualizar, debido que no ingresó el código", Toast.LENGTH_LONG).show();
        }

    }
    public void añadir(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Gestion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//Se abre la base de datos

        if (!et1.getText().toString().isEmpty() && !et2.getText().toString().isEmpty() && !et3.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            BaseDeDatos.insert("libros", null, registro);
            BaseDeDatos.close();//Se cierra la base de datos
            Toast.makeText(this, "Se ingresó el ordenador correctamente, Codigo: "+et1.getText().toString(), Toast.LENGTH_LONG).show();
        }

    }
}
