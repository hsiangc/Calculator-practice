package net.macdidi.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class WebMapActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getName();
    private static final String FILENAME = "myFile.html";
    public WebView WebMap;
    public ImageView Webimage;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_map);

        mContext = getApplicationContext();
        WebMap = (WebView) findViewById(R.id.webView2);
        Webimage = (ImageView) findViewById(R.id.imageView);

        WebMap.getSettings().setBuiltInZoomControls(true);
        WebMap.getSettings().setJavaScriptEnabled(true);

//       methodOne();
        methodTwo();

        Picasso.with(this).load("https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap\n" +
                "&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318\n" +
                "&markers=color:red%7Clabel:C%7C40.718217,-73.998284\n" +
                "&key=AIzaSyDE1oplXF_vYDLeqFLL1lYtUpSUFi0j4g4").into(Webimage);

//        WebMap.loadUrl("https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap\n" +
//                "&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318\n" +
//                "&markers=color:red%7Clabel:C%7C40.718217,-73.998284\n" +
//                "&key=AIzaSyDE1oplXF_vYDLeqFLL1lYtUpSUFi0j4g4");

//        WebMap.loadUrl("file:///android_asset/maptest.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for(int i = 0; i < 5; i++){
            menu.add(Menu.NONE, Menu.FIRST + i, Menu.NONE, "Item " + Integer.toString(i + 1));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getGroupId() == Menu.NONE) {
            Toast.makeText(getApplicationContext(),
                    item.getTitle(),
                    Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    //以讀檔的方式寫
public void methodOne ()
    {
        String strdata =
                "<html>\n" +
                "  <head>\n" +
                "    <style type=\"text/css\">\n" +
                "      html, body { height: 100%; margin: 0; padding: 0; }\n" +
                "      #map { height: 100%; }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div id=\"map\"></div>\n" +
                "    <script type=\"text/javascript\">\n" +
                "\n" +
                "var map;\n" +
                "function initMap() {\n" +
                "  map = new google.maps.Map(document.getElementById('map'), {\n" +
                "    center: {lat: 24.397, lng: 121.644},\n" +
                "    zoom: 13\n" +
                "  });\n" +
                "}\n" +
                "\n" +
                "    </script>\n" +
                "    <script async defer\n" +
                "      src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDE1oplXF_vYDLeqFLL1lYtUpSUFi0j4g4&callback=initMap\">\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>";

        writeToFile(strdata);
        //openFileOutput的儲存地點在data/data/<package name>/files/內
        WebMap.loadUrl("file:///data/data/net.macdidi.calculator/files/myFile.html");


    }

    //寫出檔案
    private void writeToFile(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e(TAG, "File write failed: " + e.toString());
        }

    }

    //讀入檔案（未用到）
    private String readFromFile() {

        String ret = "";

        try {
            InputStream inputStream = openFileInput(FILENAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }

        return ret;
    }

    public void methodTwo(){

        String varlat = "-22.5";
        String varlng = "130.5";

        String strFront = "<html>\n" +
                "  <head>\n" +
                "    <style type=\"text/css\">\n" +
                "      html, body { height: 100%; margin: 0; padding: 0; }\n" +
                "      #map { height: 100%; }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div id=\"map\"></div>\n" +
                "    <script type=\"text/javascript\">\n" +
                "\n" +
                "var map;\n";

        String strCus = "function initMap() {\n" +
                "  var myLatLng = {lat:" + varlat +", lng: "+ varlng + "};\n" +
                "  var map = new google.maps.Map(document.getElementById('map'), {\n" +
                "    zoom: 4,\n" +
                "    center: myLatLng\n" +
                "  });\n" +
                "\n" +
                "  var marker = new google.maps.Marker({\n" +
                "    position: myLatLng,\n" +
                "    map: map,\n" +
                "    title: 'Hello World!'\n" +
                "  });\n" +
                "}";
        String strEnd =
                "    </script>\n" +
                "    <script async defer\n" +
                "      src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDE1oplXF_vYDLeqFLL1lYtUpSUFi0j4g4&callback=initMap\">\n" +
                "    </script>\n" +
                "  </body>\n" +
                "</html>";




        String strData = strFront + strCus + strEnd ;

        WebMap.loadData(strData, "text/html", "UTF-8");
    }
}

