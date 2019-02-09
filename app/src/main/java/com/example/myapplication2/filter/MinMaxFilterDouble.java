package com.example.myapplication2.filter;
import android.text.InputFilter;
import android.text.Spanned;

public class MinMaxFilterDouble implements InputFilter {

    private double mIntMin, mIntMax;

    public MinMaxFilterDouble(double minValue, double maxValue) {
        this.mIntMin = minValue;
        this.mIntMax = maxValue;
    }

    public MinMaxFilterDouble(String minValue, String maxValue) {
        this.mIntMin = Double.parseDouble(minValue);
        this.mIntMax = Double.parseDouble(maxValue);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            Double input = Double.parseDouble(dest.toString() + source.toString());
            if (isInRange(mIntMin, mIntMax, input))
                return null;
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        return "";
    }

    private boolean isInRange(Double a, Double b, Double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
