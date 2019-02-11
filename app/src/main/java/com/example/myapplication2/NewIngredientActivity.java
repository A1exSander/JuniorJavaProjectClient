package com.example.myapplication2;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication2.entity.Ingredient;
import com.example.myapplication2.filter.MinMaxFilterDouble;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.myapplication2.StaticValues.JSON;


public class NewIngredientActivity extends Activity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_ingredient);

        final Button addButton = findViewById(R.id.IngredientAddButton);
        final EditText ingredientName = findViewById(R.id.IngredientName);
        final EditText ingredientEnergy = findViewById(R.id.ingredientEnergy);
        ingredientEnergy.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "1000")});
        final EditText ingredientProtein = findViewById(R.id.IngredientProtein);
        ingredientProtein.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientFat = findViewById(R.id.IngredientFat);
        ingredientFat.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientCarbohydrates = findViewById(R.id.IngredientCarbohydrates);
        ingredientCarbohydrates.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientSugar = findViewById(R.id.IngredientSugar);
        ingredientSugar.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientFatSaturated = findViewById(R.id.IngredientFatSaturated);
        ingredientFatSaturated.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientFatPolyUnsaturated = findViewById(R.id.IngredientFatPolyUnsaturated);
        ingredientFatPolyUnsaturated.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientFatMonoUnsaturated = findViewById(R.id.IngredientFatMonoUnsaturated);
        ingredientFatMonoUnsaturated.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientGlycemicIndex = findViewById(R.id.IngredientGlycemicIndex);
        ingredientGlycemicIndex.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});
        final EditText ingredientGlycemicLoad = findViewById(R.id.IngredientGlycemicLoad);
        ingredientGlycemicLoad.setFilters(new InputFilter[]{ new MinMaxFilterDouble("0", "100")});

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.IngredientAddButton:
                        Ingredient.IngredientBuilder ingredientBuilder = new Ingredient.IngredientBuilder
                                (ingredientName.getText().toString(),
                                        Double.parseDouble(ingredientEnergy.getText().toString()),
                                        Double.parseDouble(ingredientProtein.getText().toString()),
                                        Double.parseDouble(ingredientFat.getText().toString()),
                                        Double.parseDouble(ingredientCarbohydrates.getText().toString()));
                        if(!ingredientSugar.getText().toString().equals(""))ingredientBuilder.setSugar(Double.parseDouble(ingredientSugar.getText().toString()));
                        if(!ingredientFatSaturated.getText().toString().equals(""))ingredientBuilder.setFatSaturated(Double.parseDouble(ingredientFatSaturated.getText().toString()));
                        if(!ingredientFatPolyUnsaturated.getText().toString().equals(""))ingredientBuilder.setFatPolyUnsaturated(Double.parseDouble(ingredientFatPolyUnsaturated.getText().toString()));
                        if(!ingredientFatMonoUnsaturated.getText().toString().equals(""))ingredientBuilder.setFatMonoUnsaturated(Double.parseDouble(ingredientFatMonoUnsaturated.getText().toString()));
                        if(!ingredientGlycemicIndex.getText().toString().equals(""))ingredientBuilder.setGlycemicIndex(Double.parseDouble(ingredientGlycemicIndex.getText().toString()));
                        if(!ingredientGlycemicLoad.getText().toString().equals(""))ingredientBuilder.setGlycemicLoad(Double.parseDouble(ingredientGlycemicLoad.getText().toString()));
                        Ingredient ingredient = new Ingredient(ingredientBuilder);

                        OkHttpClient client = new OkHttpClient();
                        String url = "http://10.0.2.2:8080/ingredient/create";

                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        ObjectMapper mapper = new ObjectMapper();

                        String ingredientJson = null;
                        try {
                            ingredientJson = mapper.writeValueAsString(ingredient);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        RequestBody body = RequestBody.create(JSON, ingredientJson);
                        Log.i("WWW",  ingredientJson);
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
