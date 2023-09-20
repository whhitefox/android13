package com.example.pract13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText dateText, timeText;
    ImageButton datePick, timePick;
    Button applyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateText = findViewById(R.id.date_txt);
        timeText = findViewById(R.id.time_txt);

        datePick = findViewById(R.id.date_pick);
        timePick = findViewById(R.id.time_pick);

        applyButton = findViewById(R.id.button_zapis);

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedYear = 2000;
                int selectedMonth = 2;
                int selectedDay = 2;

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateText.setText(""+year+"-"+(month + 1)+"-"+dayOfMonth);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        dateSetListener, selectedYear, selectedMonth, selectedDay);
                datePickerDialog.show();
            }
        });

        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean is24HView = true;
                int selectedHour = 10;
                int selectedMinute = 20;

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeText.setText(hourOfDay+":"+minute);
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        timeSetListener, selectedHour, selectedMinute, is24HView);
                timePickerDialog.show();
            }
        });

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Подтверждение записи")
                        .setMessage("Вы подтверждаете вашу запись?")
                        .setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(MainActivity.this, "Ваша запись подтверждена",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                builder.show();
            }
        });
    }
}