//<!-- copyrighted content owned by Android Arena (www.androidarena.co.in)-->
package com.example.logindesign;


import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity {

    LoginDataBaseAdapter loginDataBaseAdapter;
    Button login;
    Button cancel, changepassword;
    EditText username, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.username);
        password1 = (EditText) findViewById(R.id.password1);
        login = (Button) findViewById(R.id.login);
        cancel = (Button) findViewById(R.id.cancel);
        changepassword = (Button) findViewById(R.id.changepassword);
        TextView reg = (TextView)findViewById(R.id.reg);

        loginDataBaseAdapter = new LoginDataBaseAdapter(getApplicationContext());
        loginDataBaseAdapter.open();


        login.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String u1=username.getText().toString();
                String p1=password1.getText().toString();
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    System.out.println("#$#$^%zzzzz&*^%$#%^&*(&^%$");
                    url = new URL("http://10.0.2.2:8082/Delta1/login.jsp?uname="+u1+"&pass="+p1);
                    System.out.println("#$#$^%&*^%gggg$#%^&*(&^%$");
                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);
                    System.out.println("#$#$^%&bbbb*^%$#%^&*(&^%$");

                    int data = isw.read();
                    if (data != -1) {
                        char current = (char) data;
                        Intent i=new Intent(MainActivity.this,intent.class);
                        startActivity(i);

                        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

                        System.out.print("@@@@@@@@" + current);
                        System.out.println("#$#$^%aaaaa&*^%$#%^&*(&^%$");

                        data = isw.read();
                        System.out.print(current);
                    }else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();

                    }}}});
        reg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent nxt = new Intent(getApplicationContext(),Login.class);
                startActivity(nxt);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }



}


