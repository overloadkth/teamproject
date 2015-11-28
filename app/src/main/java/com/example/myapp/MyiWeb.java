package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import static com.example.myapp.R.layout.activity_myiweb;

/**
 * Created by MeromGreen on 2015-11-24.
 */
public class MyiWeb extends Activity{
    WebView webview;
    String email;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_myiweb);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        email = bundle.getString("ID");
        password = bundle.getString("PW");

        webview = (WebView)findViewById(R.id.logIn);
        webview.clearCache(true);
        webview.setWebViewClient(new WebClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webview.loadUrl("javascript: {" +
                        "document.getElementById('userID').value = '" + email + "';" +
                        "document.getElementById('userPW').value = '" + password + "';" +
                        "var a = document.getElementsByTagName('input');" +
                        "a[2].CheckSubmit(); };");
                webview.loadUrl("javascript:CheckSubmit()");
            }
        });
        webview.getSettings().setDatabaseEnabled(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://sso.mju.ac.kr/swift/login/login_myiweb.jsp");

        //login(email, password);



    }


    private void login(String id, String pw){
        webview.loadUrl("javascript: {" +
                "document.getElementById('userID').value = '"+email +"';" +
                "document.getElementById('userPW').value = '"+password+"';" +
                "var a = document.getElementsByTagName('input');" +
                "a[2].CheckSubmit(); };");
        webview.loadUrl("javascript:CheckSubmit()");
//        webview.loadUrl("javascript: {" +
//                "var useless = document.getElementById('userID').value = '60122';" +
//                "var useles2s = document.getElementById('userPW').value = '3233222';" +
//                "var a = document.getElementsByTagName('input');" +
//                "a[2].CheckSubmit(); };");
//        webview.loadUrl("javascript:CheckSubmit()");
    }
    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
