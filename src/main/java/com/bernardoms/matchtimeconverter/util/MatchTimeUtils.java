package com.bernardoms.matchtimeconverter.util;

public class MatchTimeUtils {

    private MatchTimeUtils(){}

    public static String padNumber(int number) {
        return String.valueOf(number).length() == 1 ?  String.format("%02d", number) : String.valueOf(number);
    }

    public static String removeBracket(String time) {
        time = time.replace("[", "");
        time = time.replace("]", "");
        return time;
    }
}
