package com.example.carpickerdbxampp;

import android.os.StrictMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHandler {
    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    /**
     * Changed this method to also parse image urls
     * Warning! URLs should not contain commas!
     **/
    List<Brand> getCarData(String url) throws Exception {
        List<Brand> brandsList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        try {
            JSONObject jsonObject = new JSONObject(data);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String brandName = keys.next();
                JSONObject innerJsonObject = jsonObject.getJSONObject(brandName);
                String models = innerJsonObject.getString("grouped_models");
                String imageUrls = innerJsonObject.getString("images");
                brandsList.add(new Brand(brandName, models, imageUrls));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return brandsList;
    }
    public void logHistory(String url) throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
    }
}
