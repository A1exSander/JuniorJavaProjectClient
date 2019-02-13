package com.example.myapplication2.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.InputFilter;
import android.widget.EditText;

import com.example.myapplication2.AddPortionActivity;
import com.example.myapplication2.filter.DecimalInputFilter;

public class SetMassDialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add mass");
        final EditText massInput = new EditText(getActivity());
        massInput.setFilters(new InputFilter[]{ new DecimalInputFilter()});
        massInput.setRawInputType(Configuration.KEYBOARD_12KEY);

        builder.setView(massInput);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                double mass = Double.parseDouble(massInput.getText().toString());
                ((AddPortionActivity)getActivity()).setMassWithDialog(mass);
            }
        });
        return builder.create();
    }
}
