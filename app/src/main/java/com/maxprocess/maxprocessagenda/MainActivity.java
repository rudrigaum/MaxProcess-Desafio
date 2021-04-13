package com.maxprocess.maxprocessagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private Button buttonCadastrar;
    private TextInputEditText editNome;
    private TextInputEditText editCPF;
    private TextView editDataCadastro;
    private TextView editHoraCadastro;
    private TextView editDataNascimento;
    private TextInputEditText editEstado;
    private DatePickerDialog.OnDateSetListener mDateSetListenerCadastro;
    private DatePickerDialog.OnDateSetListener mDateSetListenerNascimento;
    private TimePickerDialog.OnTimeSetListener mTimeSetListenerHorario;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        editNome = findViewById(R.id.editNome);
        editCPF = findViewById(R.id.editCPF);
        editDataCadastro = findViewById(R.id.editDataCadastro);
        editHoraCadastro = findViewById(R.id.editHoraCadastro);
        editDataNascimento = findViewById(R.id.editDataNascimento);
        editEstado = findViewById(R.id.editEstado);



        editDataNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListenerNascimento,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListenerNascimento = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date =  day  + "/" + month + "/" + year;
                Integer idade = 2021 - year;
                editDataNascimento.setText(date);
            }
        };

        editDataCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListenerCadastro,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListenerCadastro = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date =  day  + "/" + month + "/" + year;
                editDataCadastro.setText(date);

            }
        };

        editHoraCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);;

                TimePickerDialog dialog = new TimePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mTimeSetListenerHorario,
                        hour, minute, true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mTimeSetListenerHorario = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute ) {

                String time =  selectedHour + " : " + selectedMinute;
                editHoraCadastro.setText(time);
            }
        };




        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (editEstado.getText().toString().equals("SP" ) && editCPF.getText().toString().equals(""))  {
                    Toast.makeText(getApplicationContext(), "Preenchimento do CPF obrigatório", Toast.LENGTH_LONG).show();
                } else {
                    String nome = editNome.getText().toString();
                    Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();

                }
                if (editEstado.getText().toString().equals("MG" )  ){
                    Toast.makeText(getApplicationContext(), "Não é possivel cadastrar menores de 18 anos", Toast.LENGTH_LONG).show();
                } else {
                    String nome = editNome.getText().toString();
                    Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();

                }

            }
        });

    }

}