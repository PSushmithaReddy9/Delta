//<!-- copyrighted content owned by Android Arena (www.androidarena.co.in)-->
package com.example.logindesign;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import listapps.AllAppsActivity;

public class Login extends Activity {

    LoginDataBaseAdapter loginDataBaseAdapter;
    EditText Firstname, Lastname, email, username, password;
    Button register, cancel, submit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        Firstname = (EditText) findViewById(R.id.fname);
        Lastname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.submit);



        register.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String Firstname1 = Firstname.getText().toString();
                String Lastname1 = Lastname.getText().toString();
                String email1 = email.getText().toString();
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();

                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    System.out.println("#$#$^%zzzzz&*^%$#%^&*(&^%$");
                    url = new URL("http://10.0.2.2:8082/Delta1/registration.jsp?fname=" + Firstname1 + "&lname=" + Lastname1 + "" +
                            "&email=" + email1 + "&uname=" + username1 + "&pass=" + password1);
                    System.out.println("#$#$^%&*^%gggg$#%^&*(&^%$");
                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);
                    System.out.println("#$#$^%&bbbb*^%$#%^&*(&^%$");
                    if (username1.equals("") || password1.equals("")) {
                        Toast.makeText(getApplicationContext(), "Fill All Fields", Toast.LENGTH_LONG).show();
                        return;
                    }

                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(Firstname1, Lastname1, email1, username1, password1);

                    // reg_btn.setVisibility(View.GONE);


                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    Log.d("PASSWORD", password1);
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }


                }
            }

        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.logindesign/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.logindesign/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}