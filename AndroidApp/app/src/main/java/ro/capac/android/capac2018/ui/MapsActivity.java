package ro.capac.android.capac2018.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import io.reactivex.annotations.NonNull;
import ro.capac.android.capac2018.R;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private int MY_LOCATION_REQUEST_CODE = 1337;
    private static final LatLng BAZA_SPORTIVA_UNIREA = new LatLng(46.749174, 23.541094);
    private static final LatLng BAZINUL_OLIMPIC_GRIGORESCU = new LatLng(46.763138, 23.543387);
    private static final LatLng PARCUL_BABES = new LatLng(46.765009, 23.558786);
    private static final LatLng SALA_SPORTURILOR = new LatLng(46.765971, 23.564350);
    private static final LatLng PARCUL_ROZELOR = new LatLng(46.764301, 23.553313);
    private static final LatLng PARCUL_CENTRAL = new LatLng(46.769640, 23.577815);
    private static final LatLng BAZA_SPORTIVA_GHEORGHENI = new LatLng(46.769639, 23.634498);
    private static final LatLng PARK_IULIUS_MALL = new LatLng(46.773015, 23.624950);
    private static final LatLng CENTRUL_VECHI = new LatLng(46.770882, 23.589807);
    private static final LatLng PARCUL_PRIMAVERII = new LatLng(46.757680, 23.556856);
    private static final LatLng WORLDCLASS = new LatLng(46.774299, 23.582210);
    private static final LatLng CLUJ_ARENA = new LatLng(46.768745, 23.571997);

    public static LatLng desiredLocation;
    public static String desiredLocationName;

    private Marker mUnirea;
    private Marker mBazinGrigorescu;
    private Marker mBabes;
    private Marker mSalaSporturilor;
    private Marker mRozelor;
    private Marker mCentral;
    private Marker mGheorgheni;
    private Marker mIuliusPark;
    private Marker mCentrulVechi;
    private Marker mParculPrimaverii;
    private Marker mWorldClass;
    private Marker mClujArena;

    private Button mBtn;
    private boolean animated = false;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MapsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mBtn = findViewById(R.id.location_selected_btn);
        mapFragment.getMapAsync(this);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @android.support.annotation.NonNull String[] permissions, @android.support.annotation.NonNull int[] grantResults) {
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0].equals(Manifest.permission.ACCESS_FINE_LOCATION) &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                onMapReady(mMap);
            } else {
                Toast.makeText(this, "LOCATION PERMISSION DENIED ABORTING..", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mMap != null) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_LOCATION_REQUEST_CODE);
                return;
            }
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        UiSettings mapSettings;
        mapSettings = mMap.getUiSettings();
        mapSettings.setZoomControlsEnabled(true);
        mapSettings.setScrollGesturesEnabled(true);
        mapSettings.setTiltGesturesEnabled(true);
        mapSettings.setRotateGesturesEnabled(true);
        // Set the type of map
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        // Enable MyLocation Layer of Google Map
        // Get LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();
        // Get the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);
        // Get Current Location
        Location myLocation = locationManager.getLastKnownLocation(provider);
        // Get latitude of the current location
        double latitude = 46.769640;
        double longitude = 23.577815;
        if(myLocation!=null) {
            latitude = myLocation.getLatitude();
            // Get longitude of the current location
            longitude = myLocation.getLongitude();
        }

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);
        // Show the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(2000));
        mUnirea = mMap.addMarker(new MarkerOptions().position(BAZA_SPORTIVA_UNIREA).title("Baza Sportivă Unirea"));
        mBazinGrigorescu = mMap.addMarker(new MarkerOptions().position(BAZINUL_OLIMPIC_GRIGORESCU).title("Bazin Olimpic Grigorescu"));
        mBabes = mMap.addMarker(new MarkerOptions().position(PARCUL_BABES).title("Parcul Sportiv I.Haţieganu"));
        mSalaSporturilor = mMap.addMarker(new MarkerOptions().position(SALA_SPORTURILOR).title("Sala Sporturilor Horia Demian"));
        mRozelor = mMap.addMarker(new MarkerOptions().position(PARCUL_ROZELOR).title("Skatepark Parcul Rozelor"));
        mCentral = mMap.addMarker(new MarkerOptions().position(PARCUL_CENTRAL).title("Parcul Central Simion Bărnuţiu"));
        mGheorgheni = mMap.addMarker(new MarkerOptions().position(BAZA_SPORTIVA_GHEORGHENI).title("Centrul Sportiv Gheorgheni"));
        mIuliusPark = mMap.addMarker(new MarkerOptions().position(PARK_IULIUS_MALL).title("Park Iulius Mall"));
        mCentrulVechi = mMap.addMarker(new MarkerOptions().position(CENTRUL_VECHI).title("Centrul Vechi"));
        mParculPrimaverii = mMap.addMarker(new MarkerOptions().position(PARCUL_PRIMAVERII).title("Parcul Primaverii"));
        mWorldClass = mMap.addMarker(new MarkerOptions().position(WORLDCLASS).title("WorldClass"));
        mClujArena = mMap.addMarker(new MarkerOptions().position(CLUJ_ARENA).title("Cluj Arena"));
        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                desiredLocation = marker.getPosition();
                desiredLocationName = marker.getTitle();
                if(!animated) {
                    mBtn.animate()
                            .translationY(-mBtn.getHeight())
                            .setDuration(0)
                            .setListener(null);
                    mBtn.setVisibility(View.VISIBLE);
                    mBtn.animate()
                            .translationY(mBtn.getHeight())
                            .setDuration(750)
                            .setListener(null);
                    animated = true;
                }
                return false;
            }
        });
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
    }

    @Override
    public boolean onMyLocationButtonClick() {
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

}
