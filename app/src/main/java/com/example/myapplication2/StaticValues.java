package com.example.myapplication2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.MediaType;

public class StaticValues {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean isLoggedIn = false;

    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(calendar.getTime());
    }
}
