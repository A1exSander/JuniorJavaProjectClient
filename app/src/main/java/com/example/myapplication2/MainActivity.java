package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button loginButton = findViewById(R.id.LoginButton);
        final Button registerButton = findViewById(R.id.RegisterButton);
        final Button addIngredientButton = findViewById(R.id.AddIngredientButton);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        addIngredientButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LoginButton:
                System.out.println("Login");
                break;
            case R.id.RegisterButton:
                Intent register = new Intent(this, RegisterScreenActivity.class);
                startActivity(register);
                break;
            case R.id.AddIngredientButton:
                Intent addIngredient = new Intent(this, NewIngredientActivity.class);
                startActivity(addIngredient);
                break;

        }
    }



}
