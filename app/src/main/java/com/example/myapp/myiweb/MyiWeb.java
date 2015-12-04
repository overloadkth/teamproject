package com.example.myapp.myiweb;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.myapp.R;
import com.example.myapp.myiweb.adapter.NavDrawerListAdapter;
import com.example.myapp.myiweb.model.NavDrawerItem;

import java.util.ArrayList;

import static com.example.myapp.R.drawable.ic_drawer;


/**
 * Created by MeromGreen on 2015-11-24.
 */
public class MyiWeb extends AppCompatActivity {
    private WebView hiddenWebView;
    private WebView frontWebView;
    private String email;
    private String password;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_myiweb);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        email = bundle.getString("ID");
        password = bundle.getString("PW");

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

    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
