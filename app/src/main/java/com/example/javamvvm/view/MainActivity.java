package com.example.javamvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.javamvvm.R;
import com.example.javamvvm.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserViewModel userViewModel = new UserViewModel();

        userViewModel.getUsersByPage().observe(this, userByPageRoot -> System.out.println("RESPONSE OF THE API" + userByPageRoot.getData()));
    }
}