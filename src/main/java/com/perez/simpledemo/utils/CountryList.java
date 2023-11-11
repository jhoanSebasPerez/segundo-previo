package com.perez.simpledemo.utils;
import java.util.Locale;

public class CountryList {

    private CountryList(){}

    public static String[] getAllCountries() {
        String[] countries = Locale.getISOCountries();
        String[] countryNames = new String[countries.length];

        for (int i = 0; i < countries.length; i++) {
            Locale locale = new Locale("", countries[i]);
            countryNames[i] = locale.getDisplayCountry();
        }

        return countryNames;
    }
}
