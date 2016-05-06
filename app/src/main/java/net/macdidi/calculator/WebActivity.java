package net.macdidi.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {

    public WebView openWeb;

    public EditText latnum;
    public EditText lngnum;
    public EditText zoomnum;
    public String location="https://www.google.com.tw/maps/@23.5,122.5151193,30z";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

      //  String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        openWeb = (WebView) findViewById(R.id.webview);
        latnum = (EditText) findViewById(R.id.LatNum);
        lngnum = (EditText) findViewById(R.id.LngNum);
        zoomnum = (EditText) findViewById(R.id.zoomNum);

        openWeb.getSettings().setJavaScriptEnabled(true);
        openWeb.setWebViewClient(new WebViewClient());
        openWeb.loadUrl("https://www.google.com.tw/maps/@25.0182342,121.5312909,15z");
    }

    public void clickHappy(View view){

        openWeb.loadUrl("https://www.google.com.tw/maps/@25.020319,121.5151193,14.56z");

    }

    public void clickAngry(View view){


        openWeb.loadUrl("https://www.google.com.tw/maps/@24.9201622,121.4214239,13.46z");


    }

    public void clickSad(View view){


        openWeb.loadUrl("https://www.google.com.tw/maps/@24.9534588,121.4907581,14.89z");

    }

    public void changeLatLng(View view){

        location = ("https://www.google.com.tw/maps/@"
                +latnum.getText().toString()
                +","
                +lngnum.getText().toString()
                +","
                +zoomnum.getText().toString()
                +"z");

        openWeb.loadUrl(location);

    }

}

