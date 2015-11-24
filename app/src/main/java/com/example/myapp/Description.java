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

class Description extends AsyncTask<Void, Void, Void> {
    ArrayList desc = new ArrayList[];

    @Override
    protected void doInBackground(Void... params) {
        try {
            Document doc = Jsoup.connect("http://m.mju.ac.kr/mbs/mjumob/jsp/restaurant/restaurant_mobile.jsp?configIdx=36548&id=mjumob_050201000000").get();
            Elements contents = doc.select(".diet dd");
            for() {
              desc = contents.text();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
