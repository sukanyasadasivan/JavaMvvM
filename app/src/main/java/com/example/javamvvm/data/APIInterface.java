package com.example.javamvvm.data;

import com.example.javamvvm.model.UserByPageRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/api/users?")
    Call<UserByPageRoot> getListOfUser(@Query("page") String pageNumber);

}
