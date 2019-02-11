package com.example.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;

import java.util.Arrays;

public class AddPortionActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_portion);

        ScrollView scrollView = findViewById(R.id.addPortionView);
        Intent intent = getIntent();
        System.out.println(Arrays.toString(intent.getStringArrayExtra("params")));
    }

}
