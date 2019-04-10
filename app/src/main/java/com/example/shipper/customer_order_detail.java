package com.example.shipper;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import Module.DirectionFinderListener;
import Module.Route;

public class customer_order_detail extends AppCompatActivity implements OnMapReadyCallback, DirectionFinderListener, LocationListener {

    private GoogleMap mMap;

    private Location mlocation;
    private PlaceAutocompleteFragment placeAutocompleteFragment;

    Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_suggest_demo);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maptest);
        mapFragment.getMapAsync(this);



        placeAutocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autop_fragment);
        placeAutocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                final LatLng latLng = place.getLatLng();

                if(marker!= null) {
                    marker.remove();
                }
                mMap.addMarker(new MarkerOptions().position(latLng).title("!"+place.getName().toString()));
                //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));

//                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15), 3000, null);
                Toast.makeText(customer_order_detail.this, place.getName().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Status status) {

            }
        });


    }

    public void setLoca() {

    }

    @Override
    public void onDirectionFinderStart() {

    }

    @Override
    public void onDirectionFinderSuccess(List<Route> route) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        LatLng fpthanoi = new LatLng(21.013732, 105.526430);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fpthanoi, 18));
//        mMap.addMarker(new MarkerOptions()
//                .title("Đại học FPT Ha Noi")
//                .position(fpthanoi));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);


    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
