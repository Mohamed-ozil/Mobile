package com.example.lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView total;
    private Button btnIncrement;
    private int counter;
    String msg = "Android :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = findViewById(R.id.total);
        btnIncrement = findViewById(R.id.btn_increment);
        counter= 0;
        Log.d(msg, "The onCreate() event");

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt("key counter", 0);
        }else {
            counter = 0;
        }
        total.setText("" + counter);

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                total.setText("" + counter);
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(msg, "The onStart() event");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(msg, "The onStart() event");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(msg, "The onPause() event");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(msg, "The onStop() event");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(msg, "The onRestart() event");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("key_counter", counter);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("key_counter", 0);
        total.setText("" + counter);
    }

}