package com.thoughtworks.bitemoi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class RestaurantListAdapter extends BaseAdapter {
    private final Context applicationContext;
    private int count;
    private final List<Restaurant> restaurants;

    public RestaurantListAdapter(Context applicationContext, List<Restaurant> restaurants) {
        this.applicationContext = applicationContext;
        this.restaurants = restaurants;
    }

    public RestaurantListAdapter(YelpSearchActivity applicationContext, int simple_list_item_1) {
        //To change body of created methods use File | Settings | File Templates.
        restaurants = null;
        this.applicationContext = null;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Object getItem(int i) {
        return restaurants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void addAll(List<String> result) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
