package com.noone.coronatracker;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaApiService {

    String BASE_URL = "https://api.rootnet.in/covid19-in/unofficial/covid19india.org/";
    @GET("statewise")
    Call<StateWiseDataWrapper> getCoronaInfo();


    //Call<List<Model>> getCoronaInfo();

}
