package net.macdidi.calculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;

    //經緯度

    private static final LatLng PERTH = new LatLng(-31.90, 115.86);
    private static final LatLng MELBOURNE = new LatLng(-37.813, 144.962);
    private static final LatLng SYDNEY = new LatLng(-34, 151);
    private static final LatLng COLORTEST = new LatLng(-35, 123);
    private static final LatLng TPARENTTEST = new LatLng(-32, 130);
    private static final LatLng FLATTEST = new LatLng(-31, 140);
    private static final LatLng ROTATIONTEST = new LatLng(-36, 145);
    private static final LatLng CUSTOMTEST = new LatLng(-30, 110);

    //記號

    private Marker sydney;
    private Marker perth;
    private Marker melbourne;
    private Marker colortest;
    private Marker tparenttest;
    private Marker flattest;
    private Marker rotationtest;
    private Marker customtest;

    private EditText editName;
    private String stringName ="hi";


    //客製化標記圖案
    public Bitmap bmp = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
    public Canvas canvas = new Canvas(bmp);
    public Paint color = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        customMarker();
        addMarkstoMap();
        editName = (EditText) findViewById(R.id.inputName);


        mMap.addMarker(new MarkerOptions().position(SYDNEY).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SYDNEY));

        mMap.setOnMarkerClickListener(this);
        mMap.setOnMarkerDragListener(this);
    }

    public void addMarkstoMap() {

        perth = mMap.addMarker(new MarkerOptions()
                .position(PERTH)
                .draggable(true));

        melbourne = mMap.addMarker(new MarkerOptions()
                .position(MELBOURNE)
                .title("Melbourne")
                .snippet("Population: 4,137,400")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.changeicon)));

        colortest = mMap.addMarker(new MarkerOptions()
                .position(COLORTEST)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        tparenttest = mMap.addMarker(new MarkerOptions()
                .position(TPARENTTEST)
                .alpha(0.7f));

        flattest = mMap.addMarker(new MarkerOptions()
                .position(FLATTEST)
                .flat(true));

        rotationtest = mMap.addMarker(new MarkerOptions()
                .position(ROTATIONTEST)
                .anchor(0.5f, 0.5f)
                .rotation((float) 90.0));

        customtest = mMap.addMarker(new MarkerOptions()
                .position(CUSTOMTEST)
                .icon(BitmapDescriptorFactory.fromBitmap(bmp))
                .anchor(0.5f, 1));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.setAlpha(0.1f);
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        marker.setAlpha(0.2f);
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        marker.setAlpha(0.5f);
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        marker.setAlpha(1f);
    }

    public void editMarker(View view) {

        stringName = editName.getText().toString();


        //modify canvas
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.littlemarker), 0,0, color);
        canvas.drawText(stringName, 20, 40, color);
        customtest.setIcon(BitmapDescriptorFactory.fromBitmap(bmp));

    }

    public void customMarker(){


        // paint defines the text color,
        // stroke width, size
        color.setTextSize(35);
        color.setColor(Color.BLUE);

        //modify canvas
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.littlemarker), 0,0, color);
        canvas.drawText(stringName, 20, 40, color);


    }

    public void openWeb(View view){

        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
    }

    public void openMap(View view){

        Uri uri = Uri.parse("geo:40, 100");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

