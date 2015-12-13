package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.myapp.myiweb.MyiWeb;
import com.example.myapp.myiweb.myiwebLoginActivity;
import com.example.myapp.timetable.TimeTable;
import com.example.myapp.timetable.timetableLoginActivity;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Intent foodTable;
    private Intent BusTable;
    private Intent TimeTable;
    private Intent myiWeb;
    private Intent Kakao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodTable = new Intent(getApplicationContext(), FoodTableActivity.class);
        BusTable = new Intent(getApplicationContext(), BusTableActivity.class);
        TimeTable = new Intent(getApplicationContext(), timetableLoginActivity.class);
        myiWeb = new Intent(getApplicationContext(), myiwebLoginActivity.class);
        Kakao = new Intent(getApplicationContext(), Kakao.class);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(foodTable);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(BusTable);
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(TimeTable);
            }
        });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myiWeb);
            }
        });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Kakao);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
