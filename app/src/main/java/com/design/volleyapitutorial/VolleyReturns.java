package com.design.volleyapitutorial;

import org.json.JSONArray;

public interface VolleyReturns {

        void onSuccess(JSONArray result);
        void onFailure(String result);

}
