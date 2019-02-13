package com.example.myapplication2.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;

import com.example.myapplication2.DayActivity;

public class SetBrDinSupDialog extends AppCompatDialogFragment {
    String brDinSup;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] optionsArray = {"Breakfast", "Dinner", "Supper"};
        builder.setTitle("Chose one")
                .setItems(optionsArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        ((DayActivity)getActivity()).createPortionTemplate(optionsArray[which]);
                        System.out.println(optionsArray[which]);

                    }
                });

        return builder.create();
    }


}
