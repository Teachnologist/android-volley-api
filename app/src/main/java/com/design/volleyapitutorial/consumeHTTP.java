package com.design.volleyapitutorial;

import android.app.Activity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class consumeHTTP {

    String URL;
    Activity ACTIVITY;

    public consumeHTTP(Activity act, String URI){
        URL = URI;
        ACTIVITY = act;
    }

    public void getVolley(final VolleyReturns callback) {

        RequestQueue queue = Volley.newRequestQueue(ACTIVITY);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONArray jresponse = new JSONArray(response);

                        callback.onSuccess(jresponse);
                    }catch(Exception e){
                        System.out.println(e.toString());
                        callback.onFailure(e.toString());
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
                callback.onFailure(error.toString());
            }
        });

        queue.add(stringRequest);

    }






}
