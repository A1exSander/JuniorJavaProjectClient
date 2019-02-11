package com.example.myapplication2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2.entity.Ration;
import com.example.myapplication2.entity.dialog.LoginFailedDialog;
import com.example.myapplication2.entity.dialog.SetBrDinSupDialog;

import java.text.DateFormat;

import static com.example.myapplication2.StaticValues.getCurrentDate;

public class DayActivity extends AppCompatActivity {

    Ration ration = new Ration();

    public void createRationTemplate(String brDinSup){
        Log.i("WWW", ration.toString());
        String[] params = {brDinSup, getCurrentDate()};
        Intent addPortionActivity = new Intent(DayActivity.this, AddPortionActivity.class);
        addPortionActivity.putExtra("params", params);
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

