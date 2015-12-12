package com.example.myapp.myiweb;

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

public class MyiWeb extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private WebView hiddenWebView;
    private WebView frontWebView;
    private String email;
    private String password;
    boolean doneOnce=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myiweb_navigation);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        email = bundle.getString("ID");
        password = bundle.getString("PW");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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


            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.myiweb_navigation, menu);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_diploma) {
            //  try {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=" + email);
        }else if (id == R.id.nav_bank) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.sub.sub02.Sub02Svl06?attribute=accfirstLoad");
        } else if (id == R.id.nav_scholarship) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.sub.sub02.Sub02Svl06?attribute=firstLoad");
        } else if (id == R.id.nav_scholarRecord) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.sub.sub02.Sub02Svl05?attribute=getScholarSchs&studentCd="+email);

        } else if (id == R.id.nav_seeToeic) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh05.Suh05Svl01?attribute=datecheck&studentCd="+email);
        } else if (id == R.id.nav_toeicScore) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh05.Suh05Svl01?attribute=sel_toeic&studentCd="+email);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private String getCSSForTable(){
        String cssString;
        cssString = "<style>"+
                ".TableStyle {"+
                "margin:0px;padding:0px;"+
                "width:100%;"+
                "box-shadow: 10px 10px 5px #888888;"+
                "border:1px solid #07214f;"+
                "-moz-border-radius-bottomleft:0px;"+
                "-webkit-border-bottom-left-radius:0px;"+
                "border-bottom-left-radius:0px;"+
                "-moz-border-radius-bottomright:0px;"+
                "-webkit-border-bottom-right-radius:0px;"+
                "border-bottom-right-radius:0px;"+
                "-moz-border-radius-topright:0px;"+
                "-webkit-border-top-right-radius:0px;"+
                "border-top-right-radius:0px;"+
                "-moz-border-radius-topleft:0px;"+
                "-webkit-border-top-left-radius:0px;"+
                "border-top-left-radius:0px;"+
                "}"+
                "</style>";
        return cssString;
    }

    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }

}
