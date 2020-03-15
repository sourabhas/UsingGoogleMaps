package com.soushetty.usinggooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //creating Markers for each place needed and an array list of type Marker to store them all
    private Marker everestMarker;
    private Marker ladakMarker;
    private Marker katmanduMarker;
    private ArrayList<Marker> markerslist;

    //Latitude and longitude values
    private LatLng mounteverest=new LatLng(27.989067, 86.925061);
    private LatLng ladak=new LatLng(34.481615, 78.271703);
    private LatLng katmandu=new LatLng(27.722268, 85.325422);

    //creating  Marker options variables and a list to hold them all
    private MarkerOptions everestmo;
    private MarkerOptions ladakmo;
    private MarkerOptions katmandumo;
    private List<MarkerOptions> markerOptionsList;

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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //to set any type of map to appear

       /*
       //Here we are adding to mMap the marker twice.Code works fine,but its redundant.
       //Hence better to use MarkerOptions List

       markerslist=new ArrayList<>();

        everestMarker=mMap.addMarker(new MarkerOptions().position(mounteverest)
        .title("Mt. Everest")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        markerslist.add(everestMarker);

        katmanduMarker=mMap.addMarker(new MarkerOptions().position(katmandu)
                    .title("Katmandu"));
        markerslist.add(katmanduMarker);

        ladakMarker=mMap.addMarker(new MarkerOptions().position(ladak)
                        .title("Ladak")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        markerslist.add(ladakMarker);

        for(Marker marker:markerslist){
            LatLng latLng=new LatLng(marker.getPosition().latitude,marker.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,4));

        }

        */


       //using MarkerOptions
        markerOptionsList=new ArrayList<>();

        //Initializing the marker option for Mt everest
        everestmo=new MarkerOptions().position(mounteverest).title("Mt. Everest")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        //adding it to the arraylist of Marker options
        markerOptionsList.add(everestmo);

        ladakmo=new MarkerOptions().position(ladak).title("Ladak")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        markerOptionsList.add(ladakmo);

        katmandumo=new MarkerOptions().position(katmandu)
                .title("Katmandu");
        markerOptionsList.add(katmandumo);

        //transversing through the Marker options List

        for(MarkerOptions markoption:markerOptionsList){
            LatLng latLng=new LatLng(markoption.getPosition().latitude,markoption.getPosition().longitude);
            mMap.addMarker(markoption);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,4));

        }








        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    /*    LatLng india=new LatLng(12.9538477,77.350729);

        //to define a title to be shown and also can alter how the icon should look and its color
        mMap.addMarker(new MarkerOptions().position(india).title("Marker in india").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))----to change the Zoom type-newLAtLngZoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(india,6));
        */

    }
}
