package com.example.androiduberanimation;

import com.example.androiduberanimation.Remote.IGoogleApi;
import com.example.androiduberanimation.Remote.RetrofitClient;

public class Common {

    public static final String baseURL="https://googleapis.com";
    public static IGoogleApi getGoogleApi(){
        return RetrofitClient.getClient(baseURL).create(IGoogleApi.class);
    }
}
