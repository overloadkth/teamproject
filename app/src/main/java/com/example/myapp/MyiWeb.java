package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import static com.example.myapp.R.layout.activity_myiweb;

/**
 * Created by MeromGreen on 2015-11-24.
 */
public class MyiWeb extends Activity{
    private WebView hiddenWebView;
    private WebView frontWebView;
    private String email;
    private String password;

    private String[] navItems = {"성적조회", "학생카드"};
    private ListView lvNavList;
    private RelativeLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_myiweb);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        email = bundle.getString("ID");
        password = bundle.getString("PW");

        hiddenWebView = (WebView)findViewById(R.id.hiddenWV);
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
                        "var a = document.getElementsByTagName('input');};");
                hiddenWebView.loadUrl("javascript:CheckSubmit()");
            }
        });

        frontWebView = (WebView)findViewById(R.id.frontWV);
        frontWebView.clearCache(true);
        frontWebView.getSettings().setDatabaseEnabled(true);
        frontWebView.getSettings().setJavaScriptEnabled(true);
        frontWebView.setWebViewClient(new WebClient());


        lvNavList = (ListView) findViewById(R.id.lv_activity_main_nav_list);
        flContainer = (RelativeLayout)findViewById(R.id.fl_activity_main_container);

        lvNavList.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
        lvNavList.setOnItemClickListener(new DrawerItemClickListener());


    }

    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position,
                                long id) {
            switch (position) {
                case 0:
                    hiddenWebView.loadUrl("https://myiweb.mju.ac.kr/servlet/su.suh.suh03.Suh03Svl02?attribute=getGrade&studentCd=60122469");
                    break;
                case 1:
                    hiddenWebView.loadUrl("https://myiweb.mju.ac.kr/su/sum/sum01/w_sum010Main.jsp");
                    break;

            }

        }
    }
}
