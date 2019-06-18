package com.example.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {
    TextView tvNombre,tvFecha,tvTelefono,tvCorreo,tvDescripcion;
    Button btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion);

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvCorreo = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btnEditar = findViewById(R.id.btnEditar);

        final Bundle receptor = getIntent().getExtras();

        final String nombre = receptor.getString("nombre");
        final String fecha = receptor.getString("day")+"/"+receptor.getString("month")+"/"+receptor.getString("year");
        final String telefono = receptor.getString("telefono");
        final String correo = receptor.getString("correo");
        final String descripcion = receptor.getString("descripcion");

        tvNombre.setText(nombre);
        tvFecha.setText("Fecha Nacimiento: "+fecha);
        tvTelefono.setText("tel."+telefono);
        tvCorreo.setText("Email: "+correo);
        tvDescripcion.setText("Descripción: "+descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Confirmacion.this, Contactos.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("telefono", telefono);
                intent.putExtra("correo", correo);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("day", receptor.getString("day"));
                intent.putExtra("month",receptor.getString("month"));
                intent.putExtra("year", receptor.getString("year"));
                startActivity(intent);
                finish();
            }
        });
    }
}
