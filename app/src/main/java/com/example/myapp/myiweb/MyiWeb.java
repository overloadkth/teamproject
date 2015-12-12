package com.example.myapp.myiweb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.renderscript.Element;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.myapp.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MyiWeb extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView hiddenWebView;
    private WebView frontWebView;
    private String email;
    private String password;
    boolean doneOnce=false;
    Document document = null;
    public Elements tables;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
<<<<<<< HEAD
                hiddenWebView.loadUrl("javascript: {" +
                        "document.getElementById('userID').value = '" + email + "';" +
                        "document.getElementById('userPW').value = '" + password + "';" +
                        "var a = document.getElementsByTagName('input');" +
                        "a.CheckSubmit()"
                        + "};");

                hiddenWebView.loadUrl("javascript:CheckSubmit()");
=======
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
>>>>>>> origin/master
            }
        });





        frontWebView = (WebView) findViewById(R.id.frontWV);
        frontWebView.clearCache(true);
        frontWebView.getSettings().setDatabaseEnabled(true);
        frontWebView.getSettings().setJavaScriptEnabled(true);
        frontWebView.setInitialScale(getScale());
        frontWebView.setWebViewClient(new WebClient());
        frontWebView.setWebViewClient(new WebClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                frontWebView.loadUrl("javascript: {" +
                        "$(document).hide();" +
                        "$(table).show();" +
                        "$(tr).show();" +
                        "$(td).show();" +
                        "};");

                //frontWebView.loadUrl("javascript:CheckSubmit()");
            }
        });
    }
//    class WebViewParser extends AsyncTask<String, Void, Document>{
//        private Document doc;
//        private int data = 0;
//
//        public WebViewParser(){
//
//            doc=null;
//        }
//
//        @Override
//        protected Document doInBackground( String... params){
//            try {
//                doc = Jsoup.connect(params[0]).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return doc;
//        }
//
//    }

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.myiweb_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        injectCSS();

        //frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd="+email);
//        } else if (id == R.id.nav_evaluate) {
//            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=60122469");
//        } else if (id == R.id.nav_withdraw) {
//            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=60122469");
        if (id == R.id.nav_diploma) {
            //  try {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=" + email);
//            try {
//                document = Jsoup.connect("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=" + email).get();
////                Elements ele = document.select("html");
////                tables = ele.select("html");
////
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//                tables = document.select("html body form table tbody tr");
//                hiddenWebView.loadData(tables.toString(), "text/html", "UTF-8");
//            } catch (IOException e) {
//                e.printStackTrace();
//        }
        }else if (id == R.id.nav_bank) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.sub.sub02.Sub02Svl06?attribute=accfirstLoad");
        } else if (id == R.id.nav_scholarship) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.sub.sub02.Sub02Svl06?attribute=firstLoad");
        } else if (id == R.id.nav_scholarRecord) {
            hiddenWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.sub.sub02.Sub02Svl05?attribute=getScholarSchs&studentCd="+email);
        } else if (id == R.id.nav_seeToeic) {
            hiddenWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh05.Suh05Svl01?attribute=datecheck&studentCd="+email);

        } else if (id == R.id.nav_toeicScore) {
            hiddenWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh05.Suh05Svl01?attribute=sel_toeic&studentCd="+email);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
<<<<<<< HEAD
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


}
class WebClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
=======
    private int getScale(){
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(PIC_WIDTH);
        val = val * 100d;
        return val.intValue();
    }
    private void injectCSS() {
        try {
            InputStream inputStream = getAssets().open("style.css");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            String encoded = Base64.encodeToString(buffer, Base64.NO_WRAP);
            hiddenWebView.loadUrl("javascript:(function() {" +
                    "var parent = document.getElementsByTagName('head').item(0);" +
                    "var style = document.createElement('style');" +
                    "style.type = 'text/css';" +
                    // Tell the browser to BASE64-decode the string into your script !!!
                    "style.innerHTML = window.atob('" + encoded + "');" +
                    "parent.appendChild(style)" +
                    "})()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }
>>>>>>> origin/master
}
