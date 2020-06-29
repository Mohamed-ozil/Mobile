package com.example.handleactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView total;
    private Button btnIncrement;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = findViewById(R.id.total);
        btnIncrement = findViewById(R.id.btn_increment);
        counter= 0;

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