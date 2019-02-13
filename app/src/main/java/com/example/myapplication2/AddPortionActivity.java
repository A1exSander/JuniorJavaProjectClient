package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication2.dialog.SetMassDialog;
import com.example.myapplication2.entity.Portion;
import com.example.myapplication2.entity.ReceivedIngredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.myapplication2.StaticValues.JSON;
import static com.example.myapplication2.StaticValues.userThis;


public class AddPortionActivity extends AppCompatActivity {

    Portion portion = new Portion();
    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();



    public void setMassWithDialog(double mass){
        portion.setMass(mass);
        Log.i("WWW", portion.toString());
        String url = "http://10.0.2.2:8080/portion/add";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        String portionJson = null;
        try {
            portionJson = mapper.writeValueAsString(portion);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(JSON, portionJson);
        Log.i("WWW",  portionJson);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Log.i("WWW", response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_portion);

        final ListView listView  = findViewById(R.id.ingredientsList);
        Intent intent = getIntent();

        portion.setBrDinSup(intent.getStringExtra("brDinSup"));
        portion.setDate(intent.getStringExtra("currentDate"));
        portion.setUserId(userThis.getUserId());

        String url = "http://10.0.2.2:8080/ingredient/getAll";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            System.out.println(responseBody);


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
                                                    Log.i("WWW","Works fine for now");
                                                    ReceivedIngredient chosenIngredient = ingredientList.get((int) id);
                                                    portion.setIngredientId(chosenIngredient.getIngredientId());
                                                    Log.i("WWW", portion.toString());
                                                    FragmentManager manager = getSupportFragmentManager();
                                                    SetMassDialog setMassDialog = new SetMassDialog();
                                                    setMassDialog.show(manager, "getting mass");
                                                }
                                            }
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
