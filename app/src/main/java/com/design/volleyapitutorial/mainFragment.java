package com.design.volleyapitutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseSupportFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class mainFragment extends BrowseSupportFragment {
    Activity ACT;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ACT = requireActivity();
        final TextView textView = ACT.findViewById(R.id.textview);
        String url = "https://data.cityofchicago.org/resource/v6vf-nfxy.json";

        consumeHTTP getapi = new consumeHTTP(ACT,url);

        getapi.getVolley(new VolleyReturns(){
            @Override
            public void onSuccess(JSONArray result){
                String write = null;
                for(int i=0;i<result.length();i++){

                    try {
                        JSONObject obj = result.getJSONObject(i);

                        write += obj.getString("sr_type")+",";

                    }catch(Exception e){

                        write += e.toString();
                    }

                }

                textView.setText(write);

            }

            @Override
            public void onFailure(String result) {
                textView.setText(result);
            }
        });


// Request a string response from the provided URL.


// Add the request to the RequestQueue.


    }



}


