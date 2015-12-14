package com.meromgreen.mjuapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;
import com.meromgreen.mjuapp.myiweb.myiwebLoginActivity;
import com.meromgreen.mjuapp.timetable.timetableLoginActivity;

public class MainActivity extends Activity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private Intent foodTable;
    private Intent BusTable;
    private Intent TimeTable;
    private Intent myiWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodTable = new Intent(getApplicationContext(), FoodTableActivity.class);
        BusTable = new Intent(getApplicationContext(), BusTableActivity.class);
        TimeTable = new Intent(getApplicationContext(), timetableLoginActivity.class);
        myiWeb = new Intent(getApplicationContext(), myiwebLoginActivity.class);

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
