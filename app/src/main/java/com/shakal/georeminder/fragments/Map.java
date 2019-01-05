package com.shakal.georeminder.fragments;


import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shakal.georeminder.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.CustomZoomButtonsController;
import org.osmdroid.views.MapView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Map extends Fragment implements LocationListener {

    MapView map;
    Activity parentActivity;
    Location currentLocation;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location,container,false);
        parentActivity = getActivity();
        Configuration.getInstance().load(parentActivity, PreferenceManager.getDefaultSharedPreferences(parentActivity));
        map = v.findViewById(R.id.mapView);
        currentLocation = new Location("gps");
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        map.setMultiTouchControls(true);
        setPoint();
        return v;
    }

    private void setPoint(){
        IMapController mapController = map.getController();
        mapController.setZoom(9d);
        GeoPoint startPoint = new GeoPoint(currentLocation.getAltitude(), currentLocation.getLongitude());
        mapController.setCenter(startPoint);
    }

    @Override
    public void onLocationChanged(android.location.Location location) {
        currentLocation.setAltitude(location.getAltitude());
        currentLocation.setLatitude(location.getLatitude());
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
