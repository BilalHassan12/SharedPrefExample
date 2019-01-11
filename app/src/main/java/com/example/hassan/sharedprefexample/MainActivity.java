package com.example.hassan.sharedprefexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveBT = (Button) findViewById(R.id.save);
        Button loadBT = (Button) findViewById(R.id.load);
        Button goBT = (Button) findViewById(R.id.lg);

        final EditText valueET = (EditText) findViewById(R.id.edtTxt);
        final TextView resultTv = (TextView) findViewById(R.id.tv);

        saveBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("MySavedData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("myValue", valueET.getText().toString());
                editor.apply();
            }
        });

        loadBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              resultTv.setText(sharedPreferences.getString("myValue","Data not found"));
            }
        });

        goBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(MainActivity.this,ResultActivity.class);
                startActivity(resultIntent);
            }
        });

    }
}
