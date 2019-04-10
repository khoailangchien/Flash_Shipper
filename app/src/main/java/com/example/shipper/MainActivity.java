package com.example.shipper;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import Module.DirectionFinder;
import Module.DirectionFinderListener;
import Module.Route;


public class MainActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener{

    private Context mContext;
    private GoogleMap mMap;
    private LinearLayout btnFindPath;

    private LinearLayout btnTest;

    private String etOrigin;
    private String etDestination;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    private PlaceAutocompleteFragment fragment_diemdi;
    private PlaceAutocompleteFragment fragment_diemden;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_home);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);

        btnFindPath = findViewById(R.id.btn_tieptuc);
//        etOrigin = (EditText) findViewById(R.id.et_diemdi);
//        etDestination = (EditText) findViewById(R.id.et_diemden);
        fragment_diemdi = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.text_diemdi);
        fragment_diemdi.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                final LatLng latLng = place.getLatLng();
                if(marker!= null) {
                    marker.remove();
                }
                etOrigin = place.getName().toString();
                mMap.addMarker(new MarkerOptions().position(latLng).title("!"+place.getName().toString()));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15), 3000, null);
            }
            @Override
            public void onError(Status status) {
            }
        });

        fragment_diemden = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.text_diemden);
        fragment_diemden.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                final LatLng latLng = place.getLatLng();
                if(marker!= null) {
                    marker.remove();
                }
                etDestination = place.getName().toString();
                mMap.addMarker(new MarkerOptions().position(latLng).title("!"+place.getName().toString()));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15), 3000, null);
            }
            @Override
            public void onError(Status status) {
            }
        });


        btnFindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openActivity() {
        Intent intent = new Intent(this , customer_order_detail.class);
        startActivity(intent);
    }

    public LatLng getLocationFromAddress(String strAddress) {
        Geocoder coder = new Geocoder(mContext);
        List<Address> address;
        LatLng p1 = null;
        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return p1;
    }


    private void sendRequest() {

        if (etOrigin.isEmpty()) {
            Toast.makeText(this, "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etDestination.isEmpty()) {
            Toast.makeText(this, "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder(this, etOrigin, etDestination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng fpthanoi = new LatLng(21.013732, 105.526430);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fpthanoi, 18));
        originMarkers.add(mMap.addMarker(new MarkerOptions()
                .title("Đại học FPT Ha Noi")
                .position(fpthanoi)));

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
        mMap.setMyLocationEnabled(true);
    }


    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Finding direction..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView) findViewById(R.id.tv_distance)).setText(route.distance.text);

            Location locationA = new Location("A");
            locationA.setLatitude(route.startLocation.latitude);
            locationA.setLongitude(route.startLocation.longitude);

            Location locationB = new Location("B");
            locationB.setLatitude(route.endLocation.latitude);
            locationB.setLongitude(route.endLocation.longitude);
            float airDistance = locationA.distanceTo(locationB);
            String airDistance2 = airDistance+" km";

            ((TextView) findViewById(R.id.tv_air_distance)).setText(airDistance2);


            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }
}

