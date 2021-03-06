package com.anartzmugika.floatingactionmenu;

import android.os.Build;
import android.text.TextUtils;

/**********************************************************************************
 * Created by anartzmugika on 18/11/16.
 *********************************************************************************/

public class Device {
    /** Returns the consumer friendly device name */
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

//        String phrase = "";
        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
//                phrase += Character.toUpperCase(c);
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
//            phrase += c;
            phrase.append(c);
        }

        return phrase.toString();
    }

    public static String getDeviceManuFacturer()
    {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel()
    {
        return Build.MODEL;
    }

    public static String getDeviceProduct()
    {
        return Build.PRODUCT;
    }
}
