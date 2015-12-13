package com.meromgreen.mjuapp;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BusTable_Button1 extends AppCompatActivity {
    private Elements BusTable;
    public Element Bus;
    public Element Time1;
    public Element Time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_table__button1);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setBusTable();
    }

    public void setBusTable() {
        int[] idArray = { R.id.busType1, R.id.startTime1, R.id.viaTime1, R.id.busType2, R.id.startTime2, R.id.viaTime2,
                R.id.busType3, R.id.startTime3, R.id.viaTime3, R.id.busType4, R.id.startTime4, R.id.viaTime4,
                R.id.busType5, R.id.startTime5, R.id.viaTime5, R.id.busType6, R.id.startTime6, R.id.viaTime6,
                R.id.busType7, R.id.startTime7, R.id.viaTime7, R.id.busType8, R.id.startTime8, R.id.viaTime8,
                R.id.busType9, R.id.startTime9, R.id.viaTime9, R.id.busType10, R.id.startTime10, R.id.viaTime10,
                R.id.busType11, R.id.startTime11, R.id.viaTime11, R.id.busType12, R.id.startTime12, R.id.viaTime12,
                R.id.busType13, R.id.startTime13, R.id.viaTime13, R.id.busType14, R.id.startTime14, R.id.viaTime14,
                R.id.busType15, R.id.startTime15, R.id.viaTime15, R.id.busType16, R.id.startTime16, R.id.viaTime16,
                R.id.busType17, R.id.startTime17, R.id.viaTime17, R.id.busType18, R.id.startTime18, R.id.viaTime18,
                R.id.busType19, R.id.startTime19, R.id.viaTime19, R.id.busType20, R.id.startTime20, R.id.viaTime20,
                R.id.busType21, R.id.startTime21, R.id.viaTime21, R.id.busType22, R.id.startTime22, R.id.viaTime22,
                R.id.busType23, R.id.startTime23, R.id.viaTime23, R.id.busType24, R.id.startTime24, R.id.viaTime24,
                R.id.busType25, R.id.startTime25, R.id.viaTime25, R.id.busType26, R.id.startTime26, R.id.viaTime26,
                R.id.busType27, R.id.startTime27, R.id.viaTime27, R.id.busType28, R.id.startTime28, R.id.viaTime28,
                R.id.busType29, R.id.startTime29, R.id.viaTime29, R.id.busType30, R.id.startTime30, R.id.viaTime30,
                R.id.busType31, R.id.startTime31, R.id.viaTime31, R.id.busType32, R.id.startTime32, R.id.viaTime32,
                R.id.busType33, R.id.startTime33, R.id.viaTime33, R.id.busType34, R.id.startTime34, R.id.viaTime34,
                R.id.busType35, R.id.startTime35, R.id.viaTime35, R.id.busType36, R.id.startTime36, R.id.viaTime36,
                R.id.busType37, R.id.startTime37, R.id.viaTime37, R.id.busType38, R.id.startTime38, R.id.viaTime38,
                R.id.busType39, R.id.startTime39, R.id.viaTime39, R.id.busType40, R.id.startTime40, R.id.viaTime40,
                R.id.busType41, R.id.startTime41, R.id.viaTime41, R.id.busType42, R.id.startTime42, R.id.viaTime42,
                R.id.busType43, R.id.startTime43, R.id.viaTime43, R.id.busType44, R.id.startTime44, R.id.viaTime44,
                R.id.busType45, R.id.startTime45, R.id.viaTime45, R.id.busType46, R.id.startTime46, R.id.viaTime46,
                R.id.busType47, R.id.startTime47, R.id.viaTime47, R.id.busType48, R.id.startTime48, R.id.viaTime48,
                R.id.busType49, R.id.startTime49, R.id.viaTime49, R.id.busType50, R.id.startTime50, R.id.viaTime50,
                R.id.busType51, R.id.startTime51, R.id.viaTime51, R.id.busType52, R.id.startTime52, R.id.viaTime52,
                R.id.busType53, R.id.startTime53, R.id.viaTime53, R.id.busType54, R.id.startTime54, R.id.viaTime54,
                R.id.busType55, R.id.startTime55, R.id.viaTime55, R.id.busType56, R.id.startTime56, R.id.viaTime56,
                R.id.busType57, R.id.startTime57, R.id.viaTime57, R.id.busType58, R.id.startTime58, R.id.viaTime58,
                R.id.busType59, R.id.startTime59, R.id.viaTime59, R.id.busType60, R.id.startTime60, R.id.viaTime60,
                R.id.busType61, R.id.startTime61, R.id.viaTime61, R.id.busType62, R.id.startTime62, R.id.viaTime62,
                R.id.busType63, R.id.startTime63, R.id.viaTime63, R.id.busType64, R.id.startTime64, R.id.viaTime64,
                R.id.busType65, R.id.startTime65, R.id.viaTime65, R.id.busType66, R.id.startTime66, R.id.viaTime66,
                R.id.busType67, R.id.startTime67, R.id.viaTime67, R.id.busType68, R.id.startTime68, R.id.viaTime68,
                R.id.busType69, R.id.startTime69, R.id.viaTime69, R.id.busType70, R.id.startTime70, R.id.viaTime70,
                R.id.busType71, R.id.startTime71, R.id.viaTime71, R.id.busType72, R.id.startTime72, R.id.viaTime72,
                R.id.busType73, R.id.startTime73, R.id.viaTime73, R.id.busType74, R.id.startTime74, R.id.viaTime74,
                R.id.busType75, R.id.startTime75, R.id.viaTime75 };



        Document doc = null;
        try {
            doc = Jsoup.connect("http://m.mju.ac.kr/mbs/mjumob/jsp/subview.jsp?id=mjumob_040203000000").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView[] tvArray =  new TextView[225];
        for(int i = 0 ; i < tvArray.length; i++) {
            tvArray[i] = (TextView) findViewById(idArray[i]);
        }
        BusTable = doc.select("tr td");

        int j = 0;
        for (int i = 0; i < 375; i+=5) {
            Bus = BusTable.get(i + 1);
            Time1 = BusTable.get(i + 2);
            Time2 = BusTable.get(i + 3);

            tvArray[j].setText(Bus.text());
            tvArray[j + 1].setText(Time1.text());
            tvArray[j + 2].setText(Time2.text());
            j += 3;
        }
    }

    public void setBusTableWidget() {
        long totalMilliSeconds = System.currentTimeMillis();
        long totalSeconds = totalMilliSeconds / 1000;
        long totalMin = totalSeconds / 60;
        long currentMin = totalMin % 60;
        long totalHours = totalMin / 60;
        long currentHour = (totalHours+9) % 24 ;

        Document doc = null;
        try {
            doc = Jsoup.connect("http://m.mju.ac.kr/mbs/mjumob/jsp/subview.jsp?id=mjumob_040203000000").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BusTable = doc.select("tr td");
        if ( currentHour <= 7) {
            if (currentMin <= 59){
                Bus = BusTable.get(1);
                Time1 = BusTable.get(2);
                Time2 = BusTable.get(3);
            }
        }
        else if ( currentHour <= 8) {
            if ( currentMin <= 10) {
                Bus = BusTable.get(6);
                Time1 = BusTable.get(7);
                Time2 = BusTable.get(8);
            }
            else if( currentMin <=15  ){
                Bus = BusTable.get(11);
                Time1 = BusTable.get(12);
                Time2 = BusTable.get(13);
            }

            else if( currentMin <=20 ){
                Bus = BusTable.get(16);
                Time1 = BusTable.get(17);
                Time2 = BusTable.get(18);
            }

            else if( currentMin <=25){
                Bus = BusTable.get(21);
                Time1 = BusTable.get(22);
                Time2 = BusTable.get(23);
            }

            else if( currentMin <=30){
                Bus = BusTable.get(26);
                Time1 = BusTable.get(27);
                Time2 = BusTable.get(28);
            }

            else if( currentMin <=40){
                Bus = BusTable.get(31);
                Time1 = BusTable.get(32);
                Time2 = BusTable.get(33);
            }

            else if( currentMin <=45){
                Bus = BusTable.get(36);
                Time1 = BusTable.get(37);
                Time2 = BusTable.get(38);
            }

            else if( currentMin <=50){
                Bus = BusTable.get(41);
                Time1 = BusTable.get(42);
                Time2 = BusTable.get(43);
            }

            else if( currentMin <=55){
                Bus = BusTable.get(46);
                Time1 = BusTable.get(47);
                Time2 = BusTable.get(48);
            }
            else if( currentMin <=59){
                Bus = BusTable.get(51);
                Time1 = BusTable.get(52);
                Time2 = BusTable.get(53);
            }
        }
        else if ( currentHour <= 9) {
            if ( currentMin <= 10) {
                Bus = BusTable.get(56);
                Time1 = BusTable.get(57);
                Time2 = BusTable.get(58);
            }
            else if( currentMin <=15  ){
                Bus = BusTable.get(61);
                Time1 = BusTable.get(62);
                Time2 = BusTable.get(63);
            }

            else if( currentMin <=20 ){
                Bus = BusTable.get(66);
                Time1 = BusTable.get(67);
                Time2 = BusTable.get(68);
            }

            else if( currentMin <=25){
                Bus = BusTable.get(71);
                Time1 = BusTable.get(72);
                Time2 = BusTable.get(73);
            }

            else if( currentMin <=30){
                Bus = BusTable.get(76);
                Time1 = BusTable.get(77);
                Time2 = BusTable.get(78);
            }

            else if( currentMin <=40){
                Bus = BusTable.get(81);
                Time1 = BusTable.get(82);
                Time2 = BusTable.get(83);
            }

            else if( currentMin <=45){
                Bus = BusTable.get(86);
                Time1 = BusTable.get(87);
                Time2 = BusTable.get(88);
            }

            else if( currentMin <=50){
                Bus = BusTable.get(91);
                Time1 = BusTable.get(92);
                Time2 = BusTable.get(93);
            }

            else if( currentMin <=55){
                Bus = BusTable.get(96);
                Time1 = BusTable.get(97);
                Time2 = BusTable.get(98);
            }

            else if( currentMin <=59){
                Bus = BusTable.get(101);
                Time1 = BusTable.get(103);
                Time2 = BusTable.get(104);
            }
        }
        else if (currentHour <= 10) {
            if ( currentMin <= 10) {
                Bus = BusTable.get(106);
                Time1 = BusTable.get(107);
                Time2 = BusTable.get(108);
            }
            else if( currentMin <=15  ){
                Bus = BusTable.get(111);
                Time1 = BusTable.get(112);
                Time2 = BusTable.get(113);
            }

            else if( currentMin <=20 ){
                Bus = BusTable.get(116);
                Time1 = BusTable.get(117);
                Time2 = BusTable.get(118);
            }

            else if( currentMin <=25){
                Bus = BusTable.get(121);
                Time1 = BusTable.get(122);
                Time2 = BusTable.get(123);
            }

            else if( currentMin <=30){
                Bus = BusTable.get(126);
                Time1 = BusTable.get(127);
                Time2 = BusTable.get(128);
            }

            else if( currentMin <=40){
                Bus = BusTable.get(131);
                Time1 = BusTable.get(132);
                Time2 = BusTable.get(133);
            }

            else if( currentMin <=45){
                Bus = BusTable.get(136);
                Time1 = BusTable.get(137);
                Time2 = BusTable.get(138);
            }

            else if( currentMin <=50){
                Bus = BusTable.get(141);
                Time1 = BusTable.get(142);
                Time2 = BusTable.get(143);
            }

            else if( currentMin <=55){
                Bus = BusTable.get(146);
                Time1 = BusTable.get(147);
                Time2 = BusTable.get(148);
            }
            else if( currentMin <= 59) {
                Bus = BusTable.get(151);
                Time1 = BusTable.get(152);
                Time2 = BusTable.get(153);
            }
        }
        else if ( currentHour <= 11) {
            if( currentMin <=20  ){
                Bus = BusTable.get(156);
                Time1 = BusTable.get(157);
                Time2 = BusTable.get(158);
            }

            else if( currentMin <=30 ){
                Bus = BusTable.get(161);
                Time1 = BusTable.get(162);
                Time2 = BusTable.get(163);
            }

            else if( currentMin <=40){
                Bus = BusTable.get(166);
                Time1 = BusTable.get(167);
                Time2 = BusTable.get(168);
            }

            else if( currentMin <=50){
                Bus = BusTable.get(171);
                Time1 = BusTable.get(172);
                Time2 = BusTable.get(173);
            }

            else if( currentMin <=59){
                Bus = BusTable.get(176);
                Time1 = BusTable.get(177);
                Time2 = BusTable.get(178);
            }

        }

        else if ( currentHour <= 12) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(181);
              Time1 = BusTable.get(182);
              Time2 = BusTable.get(183);
          }
          else if( currentMin <=30  ){
              Bus = BusTable.get(186);
              Time1 = BusTable.get(187);
              Time2 = BusTable.get(188);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(191);
              Time1 = BusTable.get(192);
              Time2 = BusTable.get(193);
          }

          else if( currentMin <=50){
              Bus = BusTable.get(196);
              Time1 = BusTable.get(197);
              Time2 = BusTable.get(198);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(201);
              Time1 = BusTable.get(202);
              Time2 = BusTable.get(203);
          }
        }
        else if ( currentHour <= 13) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(206);
              Time1 = BusTable.get(207);
              Time2 = BusTable.get(208);
          }
          else if( currentMin <=30  ){
              Bus = BusTable.get(211);
              Time1 = BusTable.get(212);
              Time2 = BusTable.get(213);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(216);
              Time1 = BusTable.get(217);
              Time2 = BusTable.get(218);
          }

          else if( currentMin <=50){
              Bus = BusTable.get(221);
              Time1 = BusTable.get(222);
              Time2 = BusTable.get(223);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(226);
              Time1 = BusTable.get(227);
              Time2 = BusTable.get(228);
          }
        }
        else if ( currentHour <= 14) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(231);
              Time1 = BusTable.get(232);
              Time2 = BusTable.get(233);
          }
          else if( currentMin <=30  ){
              Bus = BusTable.get(236);
              Time1 = BusTable.get(237);
              Time2 = BusTable.get(238);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(241);
              Time1 = BusTable.get(242);
              Time2 = BusTable.get(243);
          }

          else if( currentMin <=50){
              Bus = BusTable.get(246);
              Time1 = BusTable.get(247);
              Time2 = BusTable.get(248);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(251);
              Time1 = BusTable.get(252);
              Time2 = BusTable.get(253);
          }
        }
        else if ( currentHour <= 15) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(256);
              Time1 = BusTable.get(257);
              Time2 = BusTable.get(258);
          }
          else if( currentMin <=30  ){
              Bus = BusTable.get(261);
              Time1 = BusTable.get(262);
              Time2 = BusTable.get(263);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(266);
              Time1 = BusTable.get(267);
              Time2 = BusTable.get(268);
          }

          else if( currentMin <=50){
              Bus = BusTable.get(271);
              Time1 = BusTable.get(272);
              Time2 = BusTable.get(273);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(276);
              Time1 = BusTable.get(277);
              Time2 = BusTable.get(278);
          }
        }
        else if ( currentHour <= 16) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(281);
              Time1 = BusTable.get(282);
              Time2 = BusTable.get(283);
          }
          else if( currentMin <=30  ){
              Bus = BusTable.get(286);
              Time1 = BusTable.get(287);
              Time2 = BusTable.get(288);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(291);
              Time1 = BusTable.get(292);
              Time2 = BusTable.get(293);
          }

          else if( currentMin <=50){
              Bus = BusTable.get(296);
              Time1 = BusTable.get(292);
              Time2 = BusTable.get(293);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(301);
              Time1 = BusTable.get(302);
              Time2 = BusTable.get(303);
          }
        }
        else if ( currentHour <= 17) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(306);
              Time1 = BusTable.get(307);
              Time2 = BusTable.get(308);
          }
          else if( currentMin <=30  ){
              Bus = BusTable.get(311);
              Time1 = BusTable.get(312);
              Time2 = BusTable.get(313);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(316);
              Time1 = BusTable.get(317);
              Time2 = BusTable.get(318);
          }

          else if( currentMin <=50){
              Bus = BusTable.get(321);
              Time1 = BusTable.get(322);
              Time2 = BusTable.get(323);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(326);
              Time1 = BusTable.get(327);
              Time2 = BusTable.get(328);
          }
        }
        else if ( currentHour <= 18) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(331);
              Time1 = BusTable.get(332);
              Time2 = BusTable.get(333);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(336);
              Time1 = BusTable.get(337);
              Time2 = BusTable.get(338);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(341);
              Time1 = BusTable.get(342);
              Time2 = BusTable.get(343);
          }

        }
        else if(currentHour == 19) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(346);
              Time1 = BusTable.get(347);
              Time2 = BusTable.get(348);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(351);
              Time1 = BusTable.get(352);
              Time2 = BusTable.get(353);
          }

          else if( currentMin <=59){
              Bus = BusTable.get(356);
              Time1 = BusTable.get(357);
              Time2 = BusTable.get(358);
          }
        }
        else if ( currentHour <= 20) {
          if ( currentMin <= 20) {
              Bus = BusTable.get(361);
              Time1 = BusTable.get(362);
              Time2 = BusTable.get(363);
          }

          else if( currentMin <=40 ){
              Bus = BusTable.get(366);
              Time1 = BusTable.get(367);
              Time2 = BusTable.get(368);

          }
          else  if (currentMin <= 59) {
                Bus = BusTable.get(371);
                Time1 = BusTable.get(372);
                Time2 = BusTable.get(373);
            }
        }
        else if ( currentHour <= 23){
            if (currentMin <= 59) {
                Bus = BusTable.get(371);
                Time1 = BusTable.get(372);
                Time2 = BusTable.get(373);
            }
        }
    }
}

class BusTable1 {
    String busType;
    String busTime1;
    String busTime2;

    BusTable1() {
        BusTable_Button1 busTable1 = new BusTable_Button1();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        busTable1.setBusTableWidget();
        busType = busTable1.Bus.text();
        busTime1 = busTable1.Time1.text();
        busTime2 = busTable1.Time2.text();
    }

    public String getBusType () {
        return busType;
    }
    public String getBusTime1 () {
        return busTime1;
    }
    public String getBusTime2 () {
        return busTime2;
    }
}
