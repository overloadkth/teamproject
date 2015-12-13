package com.meromgreen.mjuapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.StrictMode;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class BusTableWidget extends AppWidgetProvider
{
    // 시간을 뜻하는 변수
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        BusTable1 bus_table1 = new BusTable1(); // 이 부분을 시간에 따라 다르게 받을 수 있도록 정해줘야함
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RemoteViews busType = new RemoteViews(context.getPackageName(), R.layout.bus_table_widget);
        busType.setTextViewText(R.id.BusType, bus_table1.getBusType());
        RemoteViews startTime = new RemoteViews(context.getPackageName(), R.layout.bus_table_widget);
        startTime.setTextViewText(R.id.start_time, bus_table1.getBusTime1());
        RemoteViews viaTime = new RemoteViews(context.getPackageName(), R.layout.bus_table_widget);
        viaTime.setTextViewText(R.id.via_time, bus_table1.getBusTime2());

        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i = 0; i <appWidgetIds.length; i++) {
            int widgetId = appWidgetIds[i];
            appWidgetManager.updateAppWidget(widgetId, busType);
            appWidgetManager.updateAppWidget(widgetId, startTime);
            appWidgetManager.updateAppWidget(widgetId, viaTime);
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
}

