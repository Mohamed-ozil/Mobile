package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.unit_arrays,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spin =(Spinner)findViewById(R.id.unit_spinner);
        spin.setAdapter(adapter);
        Button btnConvert = (Button)findViewById(R.id.btnConvert);
        final EditText kmtxt = (EditText)findViewById(R.id.kmtxt);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final int[] pos = new int[1];
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                pos[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                openActivity2();
                if (kmtxt.equals("[0-9]+")){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Converted", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Invalid input",Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    public void openActivity2(){
        intent= new Intent(this,Activity2.class);
        startActivity(intent);
    }
}