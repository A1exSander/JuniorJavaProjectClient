package com.example.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication2.entity.Ration;
import com.example.myapplication2.entity.ReceivedIngredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.myapplication2.StaticValues.userThis;


public class AddPortionActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_portion);

        final ListView listView  = findViewById(R.id.ingredientsList);
        Intent intent = getIntent();

        final Ration ration = new Ration();
        ration.setBrDinSup(intent.getStringExtra("brDinSup"));
        ration.setDate(intent.getStringExtra("currentDate"));
        ration.setUserID(userThis.getUserId());

        OkHttpClient client = new OkHttpClient();
        String url = "http://10.0.2.2:8080/ingredient/getAll";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            System.out.println(responseBody);

            ObjectMapper mapper = new ObjectMapper();

            final List<ReceivedIngredient> ingredientList =
                    mapper.readValue(responseBody,
                            new TypeReference<List<ReceivedIngredient>>() {
                            });

            ArrayAdapter arrayAdapter = new ArrayAdapter(AddPortionActivity.this,
                    android.R.layout.simple_list_item_1, ingredientList);
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    System.out.println("Works fine for now");
                                                    ReceivedIngredient chosenIngredient = ingredientList.get((int) id);
                                                    ration.setIngredientID(chosenIngredient.getIngredientId());
                                                    Log.i("WWW", ration.toString());

                                                }
                                            }
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
