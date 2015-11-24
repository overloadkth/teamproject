package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class myiwebLoginActivity extends AppCompatActivity {

    private AutoCompleteTextView personID;
    private EditText mPasswordView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myiweb_login);

        personID = (AutoCompleteTextView) findViewById(R.id.personID);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button loginButton = (Button) findViewById(R.id.sign_in_button);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });


    }

    private void attemptLogin() {
        // Store values at the time of the login attempt.
        String ID = personID.getText().toString();
        String password = mPasswordView.getText().toString();

        Intent intent = new Intent(this, MyiWeb.class);
        Bundle extras = new Bundle();
        extras.putString("ID",ID);
        extras.putString("PW",password);
        intent.putExtras(extras);
        startActivity(intent);

    }
}

