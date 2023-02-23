package com.example.javamvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.javamvvm.R;
import com.example.javamvvm.model.User;
import com.example.javamvvm.model.UserByPageRoot;
import com.example.javamvvm.view.adaptor.RecAdapter;
import com.example.javamvvm.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recView = findViewById(R.id.recView);

        UserViewModel userViewModel = new UserViewModel();

        userViewModel.getUsersByPage().observe(this, userByPageRoot ->
                setListOfUserInAdaptor(userByPageRoot.getData()));
    }

    private void setListOfUserInAdaptor(List<User> userList) {
        RecAdapter recAdapter = new RecAdapter(userList);
        recView.setAdapter(recAdapter);
    }

}