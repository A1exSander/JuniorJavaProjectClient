package com.example.myapplication2;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapplication2.entity.User;
import com.example.myapplication2.filter.MinMaxFilterDouble;
import com.example.myapplication2.filter.MinMaxFilterInt;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.myapplication2.StaticValues.JSON;

public class RegisterScreenActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        final Button regApply = findViewById(R.id.ApplyReg);
        final EditText login = findViewById(R.id.UserLogin);
        final EditText password = findViewById(R.id.UserPassword);
        final EditText weight = findViewById(R.id.UserWeight);
        weight.setFilters(new InputFilter[]{ new MinMaxFilterDouble("1", "300")});
        final EditText height = findViewById(R.id.UserHeight);
        height.setFilters(new InputFilter[]{ new MinMaxFilterDouble("1", "250")});
        final EditText age = findViewById(R.id.UserAge);
        height.setFilters(new InputFilter[]{ new MinMaxFilterInt("1", "150")});

        List<String> genderOptions =  new ArrayList<String>();
        genderOptions.add("MALE");
        genderOptions.add("FEMALE");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, genderOptions);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner gender = findViewById(R.id.userGender);
        gender.setAdapter(adapter);

        regApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ApplyReg:

                        User user = new User();
                        user.setLogin(login.getText().toString());
                        user.setPassword(password.getText().toString());
                        user.setHeight(Double.parseDouble(height.getText().toString()));
                        user.setWeight(Double.parseDouble(weight.getText().toString()));
                        user.setAge(Integer.parseInt(age.getText().toString()));
                        String selected = gender.getSelectedItem().toString();
                        user.setGender(selected);

                        OkHttpClient client = new OkHttpClient();
                        String url = "http://10.0.2.2:8080/user/create";

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
                            System.out.println(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                }

            }
        });
    }
}
