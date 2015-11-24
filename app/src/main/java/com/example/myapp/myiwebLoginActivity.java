package com.example.myapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class myiwebLoginActivity extends AppCompatActivity {

    private UserLoginTask mAuthTask = null;
    //protected String url = "http://sso.mju.ac.kr/swift/login/login_myiweb.jsp";
    private WebView wv;
    // UI references.
    private AutoCompleteTextView personID;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myiweb_login);
        wv =(WebView)findViewById(R.id.webView);
        wv.setWebViewClient(new WebClient());
        // Set up the login form.
        personID = (AutoCompleteTextView) findViewById(R.id.personID);

        WebSettings set = wv.getSettings();
        set.setJavaScriptEnabled(true);
        set.setDatabaseEnabled(true);
        wv.loadUrl("http://sso.mju.ac.kr/swift/login/login_myiweb.jsp");
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

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptLogin() {


        // Store values at the time of the login attempt.
        String email = personID.getText().toString();
        String password = mPasswordView.getText().toString();

        wv.loadUrl("javascript: {" +
                "document.getElementById('userID').value = '"+email +"';" +
                "document.getElementById('userPW').value = '"+password+"';" +
                "var frms = document.getElementsByTagName('input');" +
                "frms[2].click(); };");
        wv.loadUrl("javascript:CheckSubmit()");
//
//
//        // Check for a valid email address.
//        if (TextUtils.isEmpty(email)) {
//            personID.setError(getString(R.string.error_field_required));
//            focusView = personID;
//            cancel = true;
//        }
//        if (cancel) {
//            focusView.requestFocus();
//        } else {
//            //showProgress(true);
////            mAuthTask = new UserLoginTask(email, password);
////            mAuthTask.execute((Void) null);
//            wv.loadUrl("javascript:document.getElementById('userID').value = '"+personID+"';");
//            wv.loadUrl("javascript:document.getElementById('userPW').value = '"+password+"';");
//            wv.loadUrl("javascript:document.CheckSubmit();");
//        }
    }



    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }


        @Override
        protected Boolean doInBackground(Void... params) {

            return null;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            //showProgress(false);

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            //showProgress(false);
        }
    }
}

class WebClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}

