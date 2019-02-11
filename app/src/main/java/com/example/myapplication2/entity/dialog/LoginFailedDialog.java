package com.example.myapplication2.entity.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;

import com.example.myapplication2.R;

public class LoginFailedDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Alert")
                .setMessage("Login or password is incorrect")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("WWW", "login failed");
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}