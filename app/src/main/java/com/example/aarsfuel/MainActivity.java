package com.example.aarsfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout FRAGMENT_CONTAINER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        FRAGMENT_CONTAINER = findViewById(R.id.fragment_container);
        Home_Page home_page = new Home_Page();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, home_page)
                .commit();


    }
}