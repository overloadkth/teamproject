package com.example.myapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FoodTableActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_food_table);

      Button button1 = (Button)findViewById(R.id.btn1);
      button1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "월요일 식단입니다.", Toast.LENGTH_SHORT).show();
          }
      });

      Button button2 = (Button)findViewById(R.id.btn2);
      button2.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "화요일 식단입니다.", Toast.LENGTH_SHORT).show();
          }
      });

      Button button3 = (Button)findViewById(R.id.btn3);
      button3.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "수요일 식단입니다.", Toast.LENGTH_SHORT).show();
          }
      });

      Button button4 = (Button)findViewById(R.id.btn4);
      button4.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "목요일 식단입니다.", Toast.LENGTH_SHORT).show();
          }
      });

      Button button5 = (Button)findViewById(R.id.btn5);
      button5.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "금요일 식단입니다.", Toast.LENGTH_SHORT).show();
        }
      });
    }
}

private class Description extends AsyncTask<Void, Void, Void> {
    String desc;
    @Override
    protected void doInBackground(Void... params) {
        try {
            Document doc = Jsoup.connect("http://m.mju.ac.kr/mbs/mjumob/jsp/restaurant/restaurant_mobile.jsp?configIdx=36548&id=mjumob_050201000000").get();
            Elements contents = doc.select(".diet dd");
            desc = contents.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
