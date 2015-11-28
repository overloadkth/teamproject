package com.example.myapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import org.w3c.dom.Text;

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
                try {
                    setFoodTable_MJ("http://m.mju.ac.kr/mbs/mjumob/jsp/restaurant/restaurant_mobile.jsp?configIdx=36548&id=mjumob_050201000000&getDate=2015-11-23");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    setFoodTable_ST("http://m.mju.ac.kr/mbs/mjumob/jsp/restaurant/restaurant_mobile2.jsp?configIdx=36337&id=mjumob_050202000000&getDate=2015-11-23");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "화요일 식단입니다.", Toast.LENGTH_SHORT).show();
                TextView textview3 = (TextView)findViewById(R.id.textView3);
                textview3.setText("불닭덮밥(닭정육;브라질산),어묵국,물만두튀김,멕시칸샐러드,배추김치");
                TextView textview5 = (TextView)findViewById(R.id.textView5);
                textview5.setText("어묵국,오이무침,미니돈까스*케찹,도시락김,배추김치");
                TextView textview8 = (TextView)findViewById(R.id.textView8);
                textview8.setText("설렁탕&소면사리(우덩어리:호주산),흑미밥,김가루계란말이,매운어묵떡볶이,배추김치");
                TextView textview10 = (TextView)findViewById(R.id.textView10);
                textview10.setText("호박고추장국,연두부*양념장,매운콩나물무침,미니새송이볶음,배추김치");
            }
        });

        Button button3 = (Button)findViewById(R.id.btn3);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "수요일 식단입니다.", Toast.LENGTH_SHORT).show();
                TextView textview3 = (TextView)findViewById(R.id.textView3);
                textview3.setText("돈부리덮밥,호박감자국,쌀떡조청무침,깐풍기데리조림,배추김치");
                TextView textview5 = (TextView)findViewById(R.id.textView5);
                textview5.setText("호박감자국,교자만두튀김,숙주들깨볶음,감자조림,배추김치");
                TextView textview8 = (TextView)findViewById(R.id.textView8);
                textview8.setText("소고기육개장(우덩어리:호주산)*당면,백미밥,납작군만두,날치알계란찜,배추김치");
                TextView textview10 = (TextView)findViewById(R.id.textView10);
                textview10.setText("맑은콩나물국,참나물무침,동그랑땡조림,버섯잡채,배추김치");
            }
        });

        Button button4 = (Button)findViewById(R.id.btn4);
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "목요일 식단입니다.", Toast.LENGTH_SHORT).show();
                TextView textview3 = (TextView)findViewById(R.id.textView3);
                textview3.setText("사골떡만두국(쇠고기;호주산),오징어야채볶음,칠리알미트볼조림,깍두기");
                TextView textview5 = (TextView)findViewById(R.id.textView5);
                textview5.setText("얼갈이국,특각어묵볶음,도시락김,미역줄거리볶음,배추김치");
                TextView textview8 = (TextView)findViewById(R.id.textView8);
                textview8.setText("오삼콩불덮밥(돈불:국내산, 삼겹살:독일산),미역국,어묵채볶음,푸실리케첩샐러드,배추김치");
                TextView textview10 = (TextView)findViewById(R.id.textView10);
                textview10.setText("미역국,숙주나물무침,건파래볶음,어묵채볶음,배추김치");
            }
        });

        Button button5 = (Button)findViewById(R.id.btn5);
        button5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "금요일 식단입니다.", Toast.LENGTH_SHORT).show();
                TextView textview3 = (TextView)findViewById(R.id.textView3);
                textview3.setText("참치마요덮밥,순두부김치국,빌소세지구이,오이무침,배추김치");
                TextView textview5 = (TextView)findViewById(R.id.textView5);
                textview5.setText("순두부김치국,치킨너켓,오이무침,느타리버섯볶음,배추김치");
                TextView textview8 = (TextView)findViewById(R.id.textView8);
                textview8.setText("뚝배기칼만둣국(우덩어리:호주산),흑미밥,도토리묵오이무침,근대된장무침,배추김치");
                TextView textview10 = (TextView)findViewById(R.id.textView10);
                textview10.setText("다시마무국,도토리묵오이무침,근대된장무침,교자만두*초간장,배추김치");
            }
        });
    }
    public void setFoodTable_ST(String url) throws IOException {
      Document doc = Jsoup.connect(url).get();
        Element special = doc.select("dd").first();
      Element korea = doc.select("dd").last();
        String food_special = special.text();
      String food_korea = korea.text();

      TextView textview5 = (TextView)findViewById(R.id.textView5);
      textview5.setText(food_special);
      TextView textview3 = (TextView)findViewById(R.id.textView3);
      textview3.setText(food_korea);
    }

    public void setFoodTable_MJ(String url) throws IOException{
      Document doc = Jsoup.connect(url).get();
      Element korea = doc.select("dd").first();
      Element special = doc.select("dd").first();
      String food_korea = korea.text();
      String food_special = special.text();

      TextView textview8 = (TextView)findViewById(R.id.textView8);
      textview8.setText(food_korea);
      TextView textview10 = (TextView)findViewById(R.id.textView10);
      textview10.setText(food_special);
    }
}
