package com.thoughtworks.bitemoi;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.thoughtworks.yelp.service.proxies.YelpProxy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class YelpSearchActivity extends Activity {

    private TextView mSearchResultsText;

    @Override
    public void onCreate(Bundle b){
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(b);
        setContentView(R.layout.search);
        setTitle("Food search");
    }

    private String processJson(String jsonStuff) throws JSONException {
        JSONObject json = new JSONObject(jsonStuff);
        JSONArray businesses = json.getJSONArray("businesses");
        ArrayList<String> businessNames = new ArrayList<String>(businesses.length());
        for (int i = 0; i < businesses.length(); i++) {
            JSONObject business = businesses.getJSONObject(i);
            businessNames.add(business.getString("name"));
        }
        return TextUtils.join("\n", businessNames);
    }

    public void searchForRestaurant(View v)  {

        EditText searchKey = (EditText)findViewById(R.id.search);
        final String val = searchKey.getText().toString();
        mSearchResultsText = (TextView)findViewById(R.id.searchResult);

        setProgressBarIndeterminateVisibility(true);
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                YelpProxy yelp = YelpProxy.getYelp(YelpSearchActivity.this);
                String businesses = yelp.search(val, 37.788022, -122.399797);
                try {
                    return processJson(businesses);
                } catch (JSONException e) {
                    return businesses;
                }
            }
            @Override
            protected void onPostExecute(String result) {
                mSearchResultsText.setText(result);
                setProgressBarIndeterminateVisibility(false);
            }
        }.execute();

    }

}
