package com.meromgreen.mjuapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.util.KakaoParameterException;

public class Kakao extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao);

    }
    public void shareKakao (View v) {
        {
            try {
                    final KakaoLink kakaoLink = KakaoLink.getKakaoLink(this);
                    final KakaoTalkLinkMessageBuilder kakaoBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

            /*메시지 추가*/
                    kakaoBuilder.addText("팀프로젝트 1");

            /*이미지 가로/세로 사이즈는 80px 보다 커야하며, 이미지 용량은 500kb 이하로 제한된다.*/
                    String url = "http://upload2.inven.co.kr/upload/2015/09/27/bbs/i12820605286.jpg";
                    kakaoBuilder.addImage(url, 1080, 1920);

            /*앱 실행버튼 추가*/
                    kakaoBuilder.addAppButton("앱 실행");

            /*메시지 발송*/
                    kakaoLink.sendMessage(kakaoBuilder, this);
                } catch (KakaoParameterException e) {
                e.printStackTrace();
            }
        }
    }
}

