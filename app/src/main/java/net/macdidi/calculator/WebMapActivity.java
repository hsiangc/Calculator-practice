package net.macdidi.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;


public class WebMapActivity extends AppCompatActivity {



    public WebView WebMap;
    public ImageView Webimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_map);

        WebMap = (WebView) findViewById(R.id.webview);
        Webimage = (ImageView) findViewById(R.id.imageView);

        


    }
}
