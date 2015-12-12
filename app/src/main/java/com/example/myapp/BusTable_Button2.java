package com.example.myapp;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BusTable_Button2 extends AppCompatActivity {

    Elements BusTable;
    Element Time1;
    Element Time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_table__button2);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setBusTable2();

    }

    public void setBusTable2() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://m.mju.ac.kr/mbs/mjumob/jsp/subview.jsp?id=mjumob_040204000000").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] idArray = {R.id.startTime1, R.id.viaTime1, R.id.startTime2, R.id.viaTime2,
                         R.id.startTime3, R.id.viaTime3, R.id.startTime4, R.id.viaTime4,
                         R.id.startTime5, R.id.viaTime5, R.id.startTime6, R.id.viaTime6,
                         R.id.startTime7, R.id.viaTime7, R.id.startTime8, R.id.viaTime8,
                         R.id.startTime9, R.id.viaTime9, R.id.startTime10, R.id.viaTime10};

        TextView[] tvArray = new TextView[20];
        for (int i = 0; i < tvArray.length; i++) {
            tvArray[i] = (TextView) findViewById(idArray[i]);
        }

        BusTable = doc.select("tr td");
        int j = 0;
        for (int i = 0; i < 39; i += 4) {
            Time1 = BusTable.get(i + 1);
            Time2 = BusTable.get(i + 2);

            tvArray[j].setText(Time1.text());
            tvArray[j+1].setText(Time2.text());
            j+=2;
        }
    }
}

