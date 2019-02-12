package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication2.entity.Ration;
import com.example.myapplication2.entity.dialog.SetBrDinSupDialog;

import static com.example.myapplication2.StaticValues.getCurrentDate;

public class DayActivity extends AppCompatActivity {

    Ration ration = new Ration();

    public void createRationTemplate(String brDinSup){
        Log.i("WWW", ration.toString());
        Intent addPortionActivity = new Intent(DayActivity.this, AddPortionActivity.class);
        addPortionActivity.putExtra("brDinSup", brDinSup);
        addPortionActivity.putExtra("currentDate", getCurrentDate());
        startActivity(addPortionActivity);
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_activity);

        Button addPortion = findViewById(R.id.AddPortionButton);
        addPortion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                SetBrDinSupDialog setBrDinSupDialog = new SetBrDinSupDialog();
                setBrDinSupDialog.show(manager, "Choosing BDS");


            }
        });
    }

}

