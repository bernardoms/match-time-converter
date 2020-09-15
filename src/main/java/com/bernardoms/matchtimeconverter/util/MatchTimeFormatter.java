package com.bernardoms.matchtimeconverter.util;

import lombok.Getter;

@Getter
public class MatchTimeFormatter {
    private final int minute;
    private final int seconds;

    private MatchTimeFormatter(int minute, int seconds) {
        this.minute = minute;
        this.seconds = seconds;
    }

    public static MatchTimeFormatter format(String matchTime) {
        var time = matchTime.split(" ")[1];
        var minutes = time.split(":")[0];
        var seconds = time.split(":")[1].split("\\.")[0];
        var millis = time.split(":")[1].split("\\.")[1];

        var intMinutes = Integer.parseInt(minutes);
        var intSeconds =  Integer.parseInt(seconds);
        var intMillis = Integer.parseInt(millis);

        if(intMillis >= 500) {
            intSeconds += 1;
        }
        if(intSeconds >= 60) {
            intMinutes += 1;
            intSeconds = 0;
        }

        return new MatchTimeFormatter(intMinutes, intSeconds);
    }
}
