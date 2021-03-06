package com.thoughtworks.bitemoi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelloAndroidActivity extends Activity {

//    private static String TAG = "bitemoi";

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void locationService(View view){
    	  Intent locationIntent = new Intent(view.getContext(), LocationActivity.class);
          startActivityForResult(locationIntent, 0);
    }

    public void yelpSearch(View view) {
        Intent intent = new Intent(this, YelpSearchActivity.class);
        startActivity(intent);
    }
}

