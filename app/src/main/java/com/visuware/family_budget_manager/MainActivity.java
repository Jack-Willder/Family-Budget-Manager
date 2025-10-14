package com.visuware.family_budget_manager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                Toast.makeText(getApplicationContext(),"Welcome to visuware", Toast.LENGTH_LONG).show();
        }
}
