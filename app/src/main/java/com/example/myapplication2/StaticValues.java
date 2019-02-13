package com.example.myapplication2;

import com.example.myapplication2.entity.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import okhttp3.MediaType;

public class StaticValues {
    public static User userThis;

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
