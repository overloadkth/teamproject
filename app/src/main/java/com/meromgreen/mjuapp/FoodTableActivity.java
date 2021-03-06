package com.meromgreen.mjuapp;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.util.KakaoParameterException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;

public class FoodTableActivity extends Activity {
    public Elements FoodTable;
    public Element special;
    public Element korea;
    Calendar c = Calendar.getInstance();
    final String[] weekDay = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    private TextView textview3;
    private TextView textview5;
    private TextView textview8;
    private TextView textview10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_table);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        textview3 = (TextView) findViewById(R.id.textView3);
        textview5 = (TextView) findViewById(R.id.textView5);
        textview8 = (TextView) findViewById(R.id.textView8);
        textview10 = (TextView) findViewById(R.id.textView10);
        String Day = weekDay[c.get(Calendar.DAY_OF_WEEK)-1];
        setFoodTable_ST(Day);
        setFoodTable_MJ(Day);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareKakao(view);
            }
        });



        if ( Day == "Mon" || Day == "Sun" || Day == "Sat"){
            Button button1 = (Button)findViewById(R.id.btn1);
            button1.setBackgroundColor(Color.rgb(200,250,250));
        }
        else if ( Day == "Tue") {
            Button button2 = (Button)findViewById(R.id.btn2);
            button2.setBackgroundColor(Color.rgb(200,250,250));
        }
        else if ( Day == "Wed") {
            Button button3 = (Button)findViewById(R.id.btn3);
            button3.setBackgroundColor(Color.rgb(200,250,250));
        }
        else if ( Day == "Thu") {
            Button button4 = (Button)findViewById(R.id.btn4);
            button4.setBackgroundColor(Color.rgb(200,250,250));
        }
        else if ( Day == "Fri") {
            Button button5 = (Button)findViewById(R.id.btn5);
            button5.setBackgroundColor(Color.rgb(200,250,250));
        }
        Button button1 = (Button)findViewById(R.id.btn1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button1 = (Button)findViewById(R.id.btn1);
                button1.setBackgroundColor(Color.rgb(200,250,250));
                Button button2 = (Button)findViewById(R.id.btn2);
                button2.setBackgroundColor(Color.rgb(255,255,255));
                Button button3 = (Button)findViewById(R.id.btn3);
                button3.setBackgroundColor(Color.rgb(255,255,255));
                Button button4 = (Button)findViewById(R.id.btn4);
                button4.setBackgroundColor(Color.rgb(255,255,255));
                Button button5 = (Button)findViewById(R.id.btn5);
                button5.setBackgroundColor(Color.rgb(255,255,255));
                setFoodTable_ST("Mon");
                setFoodTable_MJ("Mon");
            }
        });

        Button button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button1 = (Button)findViewById(R.id.btn1);
                button1.setBackgroundColor(Color.rgb(255,255,255));
                Button button2 = (Button)findViewById(R.id.btn2);
                button2.setBackgroundColor(Color.rgb(200,250,250));
                Button button3 = (Button)findViewById(R.id.btn3);
                button3.setBackgroundColor(Color.rgb(255,255,255));
                Button button4 = (Button)findViewById(R.id.btn4);
                button4.setBackgroundColor(Color.rgb(255,255,255));
                Button button5 = (Button)findViewById(R.id.btn5);
                button5.setBackgroundColor(Color.rgb(255,255,255));
                setFoodTable_ST("Tue");
                setFoodTable_MJ("Tue");
            }
        });

        Button button3 = (Button)findViewById(R.id.btn3);
        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button1 = (Button)findViewById(R.id.btn1);
                button1.setBackgroundColor(Color.rgb(255,255,255));
                Button button2 = (Button)findViewById(R.id.btn2);
                button2.setBackgroundColor(Color.rgb(255,255,255));
                Button button3 = (Button)findViewById(R.id.btn3);
                button3.setBackgroundColor(Color.rgb(200,250,250));
                Button button4 = (Button)findViewById(R.id.btn4);
                button4.setBackgroundColor(Color.rgb(255,255,255));
                Button button5 = (Button)findViewById(R.id.btn5);
                button5.setBackgroundColor(Color.rgb(255,255,255));
                setFoodTable_ST("Wed");
                setFoodTable_MJ("Wed");
            }
        });

        Button button4 = (Button)findViewById(R.id.btn4);
        button4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button1 = (Button)findViewById(R.id.btn1);
                button1.setBackgroundColor(Color.rgb(255,255,255));
                Button button2 = (Button)findViewById(R.id.btn2);
                button2.setBackgroundColor(Color.rgb(255,255,255));
                Button button3 = (Button)findViewById(R.id.btn3);
                button3.setBackgroundColor(Color.rgb(255,255,255));
                Button button4 = (Button)findViewById(R.id.btn4);
                button4.setBackgroundColor(Color.rgb(200,250,250));
                Button button5 = (Button)findViewById(R.id.btn5);
                button5.setBackgroundColor(Color.rgb(255,255,255));
                setFoodTable_ST("Thu");
                setFoodTable_MJ("Thu");
            }
        });

        Button button5 = (Button)findViewById(R.id.btn5);
        button5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button1 = (Button)findViewById(R.id.btn1);
                button1.setBackgroundColor(Color.rgb(255,255,255));
                Button button2 = (Button)findViewById(R.id.btn2);
                button2.setBackgroundColor(Color.rgb(255,255,255));
                Button button3 = (Button)findViewById(R.id.btn3);
                button3.setBackgroundColor(Color.rgb(255,255,255));
                Button button4 = (Button)findViewById(R.id.btn4);
                button4.setBackgroundColor(Color.rgb(255,255,255));
                Button button5 = (Button)findViewById(R.id.btn5);
                button5.setBackgroundColor(Color.rgb(200,250,250));
                setFoodTable_ST("Fri");
                setFoodTable_MJ("Fri");
            }
        });
    }

    public void setFoodTable_ST (String Day) {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.mju.ac.kr/mbs/mjukr/jsp/restaurant/restaurant.jsp?configIdx=36548&id=mjukr_051002020000").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FoodTable = doc.select("div table tbody tr tr td");
        if ( Day == "Mon" || Day == "Sun" || Day == "Sat") {
            korea = FoodTable.get(1);
            special = FoodTable.get(5);
        } else if ( Day == "Tue") {
            korea = FoodTable.get(11);
            special = FoodTable.get(15);
        } else if ( Day == "Wed") {
            korea = FoodTable.get(21);
            special = FoodTable.get(25);
        } else if ( Day == "Thu") {
            korea = FoodTable.get(31);
            special = FoodTable.get(35);
        } else if ( Day == "Fri") {
            korea = FoodTable.get(41);
            special = FoodTable.get(45);
        }
      textview3.setText(special.text());
      textview5.setText(korea.text());
    }

    public void setFoodTable_MJ (String Day) {
      Document doc = null;
      try {
        doc = Jsoup.connect("http://www.mju.ac.kr/mbs/mjukr/jsp/restaurant/restaurant.jsp?configIdx=36337&id=mjukr_051002050000").get();
      } catch (IOException e) {
        e.printStackTrace();
      }

      FoodTable = doc.select("div table tbody tr tr td");
      if ( Day == "Mon" || Day == "Sun" || Day == "Sat") {
        korea = FoodTable.get(1);
        special = FoodTable.get(5);
      } else if ( Day == "Tue") {
        korea = FoodTable.get(13);
        special = FoodTable.get(17);
      } else if ( Day == "Wed") {
        korea = FoodTable.get(25);
        special = FoodTable.get(29);
      } else if ( Day == "Thu") {
        korea = FoodTable.get(37);
        special = FoodTable.get(41);
      } else if ( Day == "Fri") {
        korea = FoodTable.get(49);
        special = FoodTable.get(53);
      }

      textview8.setText(special.text());
      textview10.setText(korea.text());
    }
    public void shareKakao (View v) {
        {
            try {
                final KakaoLink kakaoLink = KakaoLink.getKakaoLink(this);
                final KakaoTalkLinkMessageBuilder kakaoBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

            /*메시지 추가*/
                kakaoBuilder.addText("학생식당\n" + "◎특식\n-"+ textview3.getText() + "\n"
                                                    + "◎한식\n-"+ textview5.getText() + "\n\n"
                                    +"명진당\n" + "◎특식\n-"+ textview8.getText() + "\n"
                                                    + "◎한식\n-"+ textview10.getText() + "\n");


//
//            /*앱 실행버튼 추가*/
//                kakaoBuilder.addAppButton("앱 실행");

            /*메시지 발송*/
                kakaoLink.sendMessage(kakaoBuilder, this);
            } catch (KakaoParameterException e) {
                e.printStackTrace();
            }
        }
    }
}