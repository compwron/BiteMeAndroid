package com.thoughtworks.bitemoi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationActivity extends Activity {

	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    private GoogleMap map;
    private static String TAG = "bitemoi";

	    /**
	     * Called when the activity is first created.
	     * @param savedInstanceState If the activity is being re-initialized after 
	     * previously being shut down then this Bundle contains the data it most 
	     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
	     */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
			Log.i(TAG, "onCreate");
	        setContentView(R.layout.location);
	        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		    Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG).title("Hamburg"));
		    Marker kiel = map.addMarker(new MarkerOptions()
		          .position(KIEL)
		          .title("Kiel")
		          .snippet("Kiel is cool")
		          .icon(BitmapDescriptorFactory
		              .fromResource(R.drawable.ic_launcher)));

		    // Move the camera instantly to hamburg with a zoom of 15.
		    map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));

		    // Zoom in, animating the camera.
		    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	      getMenuInflater().inflate(R.menu.location, menu);
	      return true;
	    }

}
