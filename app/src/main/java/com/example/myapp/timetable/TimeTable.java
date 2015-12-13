package com.example.myapp.timetable;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapp.R;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TimeTable extends AppCompatActivity {


    private WebView hiddenWebView;
    private WebView frontWebView;
    private String email;
    private String password;
    boolean doneOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_navigation);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        email = bundle.getString("ID");
        password = bundle.getString("PW");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        hiddenWebView = (WebView) findViewById(R.id.hiddenWV);
        hiddenWebView.clearCache(true);
        hiddenWebView.loadUrl("http://sso.mju.ac.kr/swift/login/login_myiweb.jsp");
        hiddenWebView.getSettings().setDatabaseEnabled(true);
        hiddenWebView.getSettings().setJavaScriptEnabled(true);


        hiddenWebView.setWebViewClient(new WebClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                if (!doneOnce) {
                    hiddenWebView.loadUrl("javascript: {" +
                            "document.getElementById('userID').value = '" + email + "';" +
                            "document.getElementById('userPW').value = '" + password + "';" +
                            "var a = document.getElementsByTagName('input');" +
                            "a.CheckSubmit()"
                            + "};");

                    hiddenWebView.loadUrl("javascript:CheckSubmit()");
                    doneOnce = true;
                }

            }
        });


        frontWebView = (WebView) findViewById(R.id.frontWV);
        frontWebView.clearCache(true);
        frontWebView.getSettings().setDatabaseEnabled(true);
        frontWebView.getSettings().setJavaScriptEnabled(true);
        frontWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        frontWebView.setHorizontalScrollBarEnabled(false);
        frontWebView.setPadding(0, 0, 0, 0);
//        frontWebView.setWebChromeClient(new WebChromeClient());
////

        frontWebView.setWebViewClient(new WebClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                frontWebView.loadUrl("javascript: {" +
                        "var x = document.getElementsByTagName('*');" +
                        "var i = 0;" +
                        "function myFunction(){" +
                        "for(i=0;i<x.length; i++){" +
                        "x[i].width='300px';" +
                        "}" +
                        "}" +
                        "var a = myFunction();" +
                        "};");

                frontWebView.loadUrl("javascript: {" +
                        "var x = document.getElementsByTagName('table');" +
                        "var i = 0;" +
                        "function myFunction(){" +
                        "for(i=0;i<x.length; i++){" +
                        "x[i].width='300px';" +
                        "}" +
                        "}" +
                        "var a = myFunction();" +
                        "};");

            }
        });
        frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.sug.sug01.Sug01Svl03?attribute=sug240_int");
    }


    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }

}
