package com.example.myapp.myiweb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapp.R;

public class MyiWeb extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView hiddenWebView;
    private WebView frontWebView;
    private String email;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myiweb_navigation);

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
                hiddenWebView.loadUrl("javascript: {" +
                        "document.getElementById('userID').value = '" + email + "';" +
                        "document.getElementById('userPW').value = '" + password + "';" +
                        "var a = document.getElementsByTagName('input');"+
                        "a.CheckSubmit()"
                        +"};");

                hiddenWebView.loadUrl("javascript:CheckSubmit()");
            }
        });

        frontWebView = (WebView) findViewById(R.id.frontWV);
        frontWebView.clearCache(true);
        frontWebView.getSettings().setDatabaseEnabled(true);
        frontWebView.getSettings().setJavaScriptEnabled(true);
        frontWebView.setWebViewClient(new WebClient());
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_diploma) {
            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd="+email);
//        } else if (id == R.id.nav_evaluate) {
//            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=60122469");
//        } else if (id == R.id.nav_withdraw) {
//            frontWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=60122469");
        } else if (id == R.id.nav_bank) {
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
}
class WebClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}