package com.example.myapplication2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication2.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.myapplication2.StaticValues.JSON;

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
                final EditText login = findViewById(R.id.LoginField);
                final EditText password = findViewById(R.id.PasswordField);

                User user = new User();
                user.setLogin(login.getText().toString());
                user.setPassword(password.getText().toString());
                System.out.println(user.toString());
                OkHttpClient client = new OkHttpClient();
                String url = "http://10.0.2.2:8080/user/login";

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                ObjectMapper mapper = new ObjectMapper();

                String userJson = null;
                try {
                    userJson = mapper.writeValueAsString(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                RequestBody body = RequestBody.create(JSON, userJson);
                Log.i("WWW",  userJson);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    Log.i("WWW", response.body().string());
                    if (response.code()==500)  {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Alert")
                                .setMessage("Login or password is incorrect")
                                .setCancelable(false)
                                .setNegativeButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                        Log.i("WWW", "Failed login");
                    } else {
                        Intent dayActivity = new Intent(this, DayActivity.class);
                        startActivity(dayActivity);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                client.newCall(request).enqueue(new Callback() {
//                    public void onFailure(Call call, IOException e) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                        builder.setTitle("Alert")
//                                .setMessage("Login or password is incorrect")
//                                .setCancelable(false)
//                                .setNegativeButton("OK",
//                                        new DialogInterface.OnClickListener() {
//                                            public void onClick(DialogInterface dialog, int id) {
//                                                dialog.cancel();
//                                            }
//                                        });
//                        AlertDialog alert = builder.create();
//                        alert.show();
//                        Log.i("Login attempt", e.printStackTrace().);
//                    }
//
//                    public void onResponse(Call call, Response response)
//                            throws IOException {
//                        String responseBody = response.body().string();
//                        System.out.println(responseBody);
//
//                    }
//                });

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
