package com.example.logindesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Sushmitha on 15-03-2016.
 */
public class Update extends Activity{

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        URL url;
                HttpURLConnection urlConnection = null;
                try {
                    System.out.println("#$#$^%zzzzz&*^%$#%^&*(&^%$");
                    url = new URL("http://10.0.2.2:8082/Delta1/self");
                    System.out.println("#$#$^%&*^%gggg$#%^&*(&^%$");
                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);
                    BufferedReader bufferedReader = new BufferedReader( isw);
                    String line = "";
                    String result = "";
                    while((line = bufferedReader.readLine()) != null)
                        result += line;
                    System.out.println("#$#$^%&bbbb*^%$#%^&*(&^%$" +result+"@");
                  String aa[]=result.split(",");
                   final  ListView lv=(ListView)findViewById(R.id.listView);
                    final ArrayAdapter adapter = new ArrayAdapter(this,
                            android.R.layout.simple_list_item_1, aa);

                    lv.setAdapter(adapter);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String aa=lv.getItemAtPosition(position).toString();
                            URL url;
                            HttpURLConnection urlConnection = null;
                            try {
                                System.out.println("#$#$^%zzzzz&*^%$#%^&*(&^%$");
                                url = new URL("http://10.0.2.2:8082/Delta1/Url?aa='"+aa+"'");
                                System.out.println("#$#$^%&*^%gggg$#%^&*(&^%$");
                                urlConnection = (HttpURLConnection) url
                                        .openConnection();

                                InputStream in = urlConnection.getInputStream();

                                InputStreamReader isw = new InputStreamReader(in);
                                BufferedReader bufferedReader = new BufferedReader( isw);
                                String line = "";
                                String result = "";
                                while((line = bufferedReader.readLine()) != null)
                                    result += line;
                                System.out.println("#$#$^%&bbbQQQQQb*^%$#%^&*(&^%$" +result+"@");

                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sendspace.com")) ;

                                startActivity(it);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                if (urlConnection != null) {
                                    urlConnection.disconnect();
                                }

                            }}
                    });


                    } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }


                }
            }




}

