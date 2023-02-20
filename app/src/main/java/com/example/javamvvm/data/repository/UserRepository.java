package com.example.javamvvm.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.javamvvm.data.APIClient;
import com.example.javamvvm.data.APIInterface;
import com.example.javamvvm.model.UserByPageRoot;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    public MutableLiveData<UserByPageRoot> requestHolidays() {
        final MutableLiveData<UserByPageRoot> mutableLiveData = new MutableLiveData<>();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<UserByPageRoot> userListingFun = apiInterface.getListOfUser("1");

        userListingFun.enqueue(new Callback<UserByPageRoot>() {
            @Override
            public void onResponse(@NonNull Call<UserByPageRoot> call, @NonNull Response<UserByPageRoot> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mutableLiveData.setValue(response.body());
                } else {
                    System.out.println("RESPONSE IS NOT SUCCESSFUL");
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserByPageRoot> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        return mutableLiveData;
    }

}
