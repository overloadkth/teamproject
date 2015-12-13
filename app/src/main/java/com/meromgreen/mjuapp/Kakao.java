package com.meromgreen.mjuapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Kakao extends Activity implements View.OnClickListener{

    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        if(v == b1){
            KakaoLink kakaoLink = KakaoLink.getLink(getApplicationContext());

            if (!kakaoLink.isAvailableIntent()){
                Toast.makeText(getApplicationContext(),"카카오톡 설치해주세요",Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                String strMessage = "더 이상은 Naver...";
                String strURL ="http://m.naver.com";
                String strAppid ="com.example.simplekakao";
                String strAppVer = "1.0";
                String strAppName = "Simple Kakao";

                kakaoLink.openKakaoLink(Kakao.this ,strURL,strMessage, strAppid, strAppVer, strAppName, "UTF-8");
            }
        }
        else if(v == b2){
            KakaoLink kakaoLink = KakaoLink.getLink(getApplicationContext());

            if (!kakaoLink.isAvailableIntent()){
                Toast.makeText(getApplicationContext(),"카카오톡 설치해주세요",Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                ArrayList<Map<String, String>>metaInfoArray = new ArrayList<Map<String,String>>();

                Map<String, String>metaInfoAndroid = new Hashtable<String, String>(1);
                metaInfoAndroid.put("os","android");
                metaInfoAndroid.put("devicetype","phone");
                metaInfoAndroid.put("installurl","market://details?id=com.kakao.talk");
                metaInfoArray.add(metaInfoAndroid);

                String strMessage = "카카오톡";
                String strURL ="http://play.google.com";
                String strAppid ="com.example.simplekakao";
                String strAppVer = "1.0";
                String strAppName = "Simple Kakao";

                kakaoLink.openKakaoAppLink(Kakao.this ,strURL,strMessage, strAppid, strAppVer, strAppName, "UTF-8", metaInfoArray);
            }
        }
    }
}

class KakaoLink {

    private static KakaoLink kakaoLink = null;

    private static String KakaoLinkApiVersion = "5.2.2";
    private static String KakaoLinkURLBaseString = "kakaolink://sendurl";

    private static Charset KakaoLinkCharset = Charset.forName("UTF-8");
    private static String KakaoLinkEncoding = KakaoLinkCharset.name();

    private Context context;
    private String params;

    private KakaoLink(Context context) {
        super();
        this.context = context;
        this.params = getBaseKakaoLinkUrl();
    }

    public static KakaoLink getLink(Context context) {
        if (kakaoLink != null)
            return kakaoLink;

        return new KakaoLink(context);
    }

    private void openKakaoLink(Activity activity, String params) {
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse(params));
        activity.startActivity(intent);
    }

    public void openKakaoLink(Activity activity, String url, String message, String appId, String appVer, String appName, String encoding) {

        if (isEmptyString(url) || isEmptyString(message) || isEmptyString(appId) || isEmptyString(appVer) || isEmptyString(appName) || isEmptyString(encoding))
            throw new IllegalArgumentException();

        try {
            if (KakaoLinkCharset.equals(Charset.forName(encoding)))
                message = new String(message.getBytes(encoding), KakaoLinkEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        this.params = getBaseKakaoLinkUrl();

        appendParam("url", url);
        appendParam("msg", message);
        appendParam("apiver", KakaoLinkApiVersion);
        appendParam("appid", appId);
        appendParam("appver", appVer);
        appendParam("appname", appName);
        appendParam("type", "link");

        openKakaoLink(activity, params);
    }

    public void openKakaoAppLink(Activity activity, String url, String message, String appId, String appVer, String appName, String encoding,
                                 ArrayList<Map<String, String>> metaInfoArray) {

        if (isEmptyString(url) || isEmptyString(message) || isEmptyString(appId) || isEmptyString(appVer) || isEmptyString(appName) || isEmptyString(encoding)) {
            throw new IllegalArgumentException();
        }

        try {
            if (KakaoLinkCharset.equals(Charset.forName(encoding)))
                message = new String(message.getBytes(encoding), KakaoLinkEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        this.params = getBaseKakaoLinkUrl();

        appendParam("url", url);
        appendParam("msg", message);
        appendParam("apiver", KakaoLinkApiVersion);
        appendParam("appid", appId);
        appendParam("appver", appVer);
        appendParam("appname", appName);
        appendParam("type", "app");
        appendMetaInfo(metaInfoArray);

        openKakaoLink(activity, params);
    }

    public boolean isAvailableIntent() {
        Uri kakaoLinkTestUri = Uri.parse(KakaoLinkURLBaseString);
        Intent intent = new Intent(Intent.ACTION_SEND, kakaoLinkTestUri);
        List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list == null)
            return false;
        return list.size() > 0;
    }

    private boolean isEmptyString(String str) {
        return (str == null || str.trim().length() == 0);
    }

    private void appendParam(final String name, final String value) {
        try {
            String encodedValue = URLEncoder.encode(value, KakaoLinkEncoding);
            params = params + name + "=" + encodedValue + "&";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void appendMetaInfo(ArrayList<Map<String, String>> metaInfoArray) {
        params += "metainfo=";

        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();

        try {
            for (Map<String, String> metaInfo : metaInfoArray) {
                JSONObject metaObj = new JSONObject();
                for (String key : metaInfo.keySet()) {
                    metaObj.put(key, metaInfo.get(key));
                }
                arr.put(metaObj);
            }
            obj.put("metainfo", arr);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            String encodedValue = URLEncoder.encode(obj.toString(), KakaoLinkEncoding);
            params += encodedValue;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String getBaseKakaoLinkUrl() {
        return KakaoLinkURLBaseString + "?";
    }
}
