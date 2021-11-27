package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Activities.AgreeActivity;
import com.example.myapplication.R;

public class LoginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        Button loginBtn = findViewById(R.id.registerButton);
    }

    public void clickRegister(View view) {
        Intent intent = new Intent(this, AgreeActivity.class);
        startActivity(intent);
    }

    public void goMainPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}