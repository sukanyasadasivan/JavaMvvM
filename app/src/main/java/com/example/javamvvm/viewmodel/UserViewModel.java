package com.example.javamvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javamvvm.data.repository.UserRepository;
import com.example.javamvvm.model.UserByPageRoot;

public class UserViewModel extends ViewModel {

    private final UserRepository userRepo;
    private MutableLiveData<UserByPageRoot> mutableLiveData;

    public UserViewModel() {
        userRepo = new UserRepository();
    }

    public LiveData<UserByPageRoot> getUsersByPage() {
        if (mutableLiveData == null) {
            mutableLiveData = userRepo.requestHolidays();
        }
        return mutableLiveData;
    }

}
