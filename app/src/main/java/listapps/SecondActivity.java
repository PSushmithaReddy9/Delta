package listapps;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logindesign.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        TextView t1 = (TextView) findViewById(R.id.textView);
        TextView t2 = (TextView) findViewById(R.id.textView4);
        Bundle b = getIntent().getExtras();
      final  String vab = b.getString("aa");
        t1.setText(vab);
      final  String i2 = b.getString("ab");

        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(i2, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
       final String version = pInfo.versionName;
        t2.setText(version);
        Button bt = (Button) findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    System.out.println("#$#$^%zzzzz&*^%$#%^&*(&^%$");
                    url = new URL("http://10.0.2.2:8082/Delta1/Update?aa='"+vab+"'&bb='"+version+"'");
                    System.out.println("#$#$^%&*^%gggg$#%^&*(&^%$"+"http://10.0.2.2:8082/Delta1/Update?aa='"+vab+"'&bb='"+version+"'");
                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);
                    BufferedReader bufferedReader = new BufferedReader(isw);
                    String line = "";
                    String result = "";
                    while ((line = bufferedReader.readLine()) != null)
                        result += line;
                    if(result.equals("no")){
                        Toast.makeText(getApplicationContext(),"No Updations So Far",Toast.LENGTH_LONG).show();
                    }else {
                        System.out.println("#$#$^%&bbbQQQQQb*^%$#%^&*(&^%$" + result + "@");


                        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sendspace.com/file/w6e9jx"));

                        startActivity(it);
                    } } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();


                    }
                }

            }
        });


    }
}