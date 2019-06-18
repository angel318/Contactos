package com.example.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


public class Contactos extends AppCompatActivity {
    DatePicker dpFecha;
    Button btnSiguiente;
    EditText etNombre,etTelefono,etEmail,etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactos);

        dpFecha = findViewById(R.id.simpleDatePicker);
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etCorreo);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        if(getIntent().hasExtra("nombre"))
        {
            rellenado();
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dpFecha.getDayOfMonth();
                int month = dpFecha.getMonth();
                int year = dpFecha.getYear();
                Intent intent = new Intent(Contactos.this, Confirmacion.class);
                intent.putExtra("nombre", etNombre.getText().toString());
                intent.putExtra("telefono", etTelefono.getText().toString());
                intent.putExtra("correo", etEmail.getText().toString());
                intent.putExtra("descripcion", etDescripcion.getText().toString());
                intent.putExtra("day", Integer.toString(day));
                intent.putExtra("month", Integer.toString(month));
                intent.putExtra("year", Integer.toString(year));
                startActivity(intent);
                finish();
            }
        });

    }
    public void rellenado()
    {
        final Bundle receptor = getIntent().getExtras();
        etNombre.setText(receptor.getString("nombre"));
        etTelefono.setText(receptor.getString("telefono"));
        etEmail.setText(receptor.getString("correo"));
        etDescripcion.setText(receptor.getString("descripcion"));
        int day = Integer.parseInt(receptor.getString("day"));
        int month = Integer.parseInt(receptor.getString("month"));
        int year = Integer.parseInt(receptor.getString("year"));
        dpFecha.init(year,month,day,null);
    }
}
