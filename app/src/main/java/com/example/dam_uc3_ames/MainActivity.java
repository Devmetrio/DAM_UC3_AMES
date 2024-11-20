package com.example.dam_uc3_ames;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los componentes del layout
        Spinner spinner = findViewById(R.id.spiner);
        Button myButton = findViewById(R.id.btnEnviar);

        // Crear un adaptador usando el recurso de cadenas y un diseño predeterminado
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.opciones_spinner, // Asegúrate de que esta lista exista en res/values/strings.xml
                android.R.layout.simple_spinner_item
        );

        // Especificar el diseño para la lista desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador al Spinner
        spinner.setAdapter(adapter);

        // Configurar el evento de clic para el botón
        myButton.setOnClickListener(v -> {
            // Mostrar un mensaje emergente
            Toast.makeText(MainActivity.this, "Datos enviados", Toast.LENGTH_SHORT).show();
        });

        EditText editTextDate = findViewById(R.id.idFechaVuelta);
        EditText editTextDates = findViewById(R.id.idFechaIda);

        editTextDate.setOnClickListener(v -> {
            // Obtener la fecha actual
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Mostrar el DatePickerDialog
            DatePickerDialog datePicker = new DatePickerDialog(
                    MainActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        // Establecer la fecha seleccionada en el EditText
                        editTextDate.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                    },
                    year,
                    month,
                    day
            );
            datePicker.show();
        });

        editTextDates.setOnClickListener(v -> {
            // Obtener la fecha actual
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Mostrar el DatePickerDialog
            DatePickerDialog datePicker = new DatePickerDialog(
                    MainActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        // Establecer la fecha seleccionada en el EditText
                        editTextDates.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                    },
                    year,
                    month,
                    day
            );
            datePicker.show();
        });



    }
}
