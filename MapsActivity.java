package com.example.shiva.cureall;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationListener l;
    LocationManager m;
    String adds="";
    String address="";

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    m.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 20, l);
                }

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        m = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
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
        l = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                LatLng ul = new LatLng(location.getLatitude(),location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(ul).title("Current Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ul));
                Geocoder geo=new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    List<Address> ListAddress =geo.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if(ListAddress!=null && ListAddress.size()>0){
                        adds=ListAddress.get(0).toString();
                        if(ListAddress.get(0).getSubThoroughfare()!=null){
                            address +=ListAddress.get(0).getSubThoroughfare()+" , ";
                        }
                        if(ListAddress.get(0).getSubThoroughfare()!=null){
                            address +=ListAddress.get(0).getCountryName()+" , ";
                        }
                        if(ListAddress.get(0).getSubThoroughfare()!=null){
                            address +=ListAddress.get(0).getCountryCode()+" , ";
                        }
                        if(ListAddress.get(0).getSubThoroughfare()!=null) {
                            address += ListAddress.get(0).getPostalCode() + ".";
                        }

                        Toast.makeText(MapsActivity.this,adds,Toast.LENGTH_LONG).show();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };


            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            else{
                m.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 20, l);
            }
            }
            /*public void add(View v){
                Button b=(Button)findViewById(R.id.button2);
                ImageButton b2=(ImageButton)findViewById(R.id.imageButton);
                b.setVisibility(View.INVISIBLE);

                TextView t=(TextView)findViewById(R.id.textView);

                t.setText(address);
                t.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                }
               public void im(View v){
                    Button b=(Button)findViewById(R.id.button2);
                    ImageButton b2=(ImageButton)findViewById(R.id.imageButton);


                    TextView t=(TextView)findViewById(R.id.textView);

                    t.setText("");
                    t.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    b.setVisibility(View.VISIBLE);
                }*/
}
