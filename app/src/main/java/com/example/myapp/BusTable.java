package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class BusTable extends AppCompatActivity {

    private Intent BusTable_Button1;
    private Intent BusTable_Button2;
    private Intent BusTable_Button3;
    private Intent BusTable_Button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_table);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (getApplicationContext(), BusTable_Button1.class);
                startActivity(intent);}
        });
        Button button2 = (Button)findViewById(R.id.button6);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (getApplicationContext(), BusTable_Button2.class);
                startActivity(intent);
            }
        });
        Button button3 = (Button)findViewById(R.id.button7);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (getApplicationContext(), BusTable_Button3.class);
                startActivity(intent);}
        });
        Button button4 = (Button)findViewById(R.id.button8);
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent (getApplicationContext(), BusTable_Button4.class);
                startActivity(intent);
            }
        });
    }
}
