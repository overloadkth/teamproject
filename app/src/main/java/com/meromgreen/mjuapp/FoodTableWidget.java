package com.meromgreen.mjuapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.StrictMode;
import android.widget.RemoteViews;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Calendar;

/**
 * Implementation of App Widget functionality.
 */
public class FoodTableWidget extends AppWidgetProvider {
  Calendar c = Calendar.getInstance();
  final String[] weekDay = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    Elements FoodTable;
    Element special;
    Element korea;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setFoodTable_ST(weekDay[c.get(Calendar.DAY_OF_WEEK) - 1]);
        RemoteViews ST_special_food = new RemoteViews(context.getPackageName(), R.layout.food_table_widget);
        ST_special_food.setTextViewText(R.id.ST_special_food, special.text());
        RemoteViews ST_korea_food = new RemoteViews(context.getPackageName(), R.layout.food_table_widget);
        ST_korea_food.setTextViewText(R.id.ST_korea_food, korea.text());

        setFoodTable_MJ(weekDay[c.get(Calendar.DAY_OF_WEEK) - 1]);
        RemoteViews MJ_special_food = new RemoteViews(context.getPackageName(), R.layout.food_table_widget);
        MJ_special_food.setTextViewText(R.id.MJ_special_food, special.text());
        RemoteViews MJ_korea_food = new RemoteViews(context.getPackageName(), R.layout.food_table_widget);
        MJ_korea_food.setTextViewText(R.id.MJ_korea_food, korea.text());


        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for ( int i = 0; i < appWidgetIds.length; i++ ) {
            int widgetId = appWidgetIds[i];
            appWidgetManager.updateAppWidget(widgetId, ST_special_food);
            appWidgetManager.updateAppWidget(widgetId, ST_korea_food);
            appWidgetManager.updateAppWidget(widgetId, MJ_special_food);
            appWidgetManager.updateAppWidget(widgetId, MJ_korea_food);
        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
        super.onDisabled(context);
    }

   public void setFoodTable_ST(String Day) {
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
   }
   public void setFoodTable_MJ(String Day) {
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
   }
}
