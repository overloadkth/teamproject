package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import static com.example.myapp.R.layout.activity_myiweb;

/**
 * Created by MeromGreen on 2015-11-24.
 */
public class MyiWeb extends Activity{
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_myiweb);

        webview = (WebView)findViewById(R.id.logIn);
        webview.setWebViewClient(new WebClient()); // 응룡프로그램에서 직접 url 처리
        WebSettings set = webview.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(true);
        webview.loadUrl("http://www.google.com");

       // findViewById(R.id.btnStart).setOnClickListener(onclick);
    }

//    OnClickListener onclick =new OnClickListener() {
//
//        @Override
//        public void onClick(View v) {
//            System.out.println("클릭");
//            String url= null;
//            EditText add = (EditText)findViewById(R.id.add);
//            url = add.getText().toString();
//            webview.loadUrl(url);
//        }
//    };

    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
