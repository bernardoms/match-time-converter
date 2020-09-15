package com.bernardoms.matchtimeconverter.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.util.MatchTimeUtils;
import org.springframework.stereotype.Service;

@Service
public class ExtraTimeAfterNinthConverterService implements MatchTimeConverter {
    @Override
    public String converter(int minutes, int seconds, MatchTimeType matchType) {
        if (minutes >= 90 && seconds > 0) {
            var extraTimeMinutes = minutes - 90;
            var extraTimeSeconds = seconds;
            minutes = 90;
            seconds = 0;

            return MatchTimeUtils.padNumber(minutes)
                    + ":" + MatchTimeUtils.padNumber(seconds)
                    + " +" + MatchTimeUtils.padNumber(extraTimeMinutes)
                    + ":" + MatchTimeUtils.padNumber(extraTimeSeconds)
                    + " - " + matchType.getValue();
        }

        return MatchTimeUtils.padNumber(minutes)
                + ":" + MatchTimeUtils.padNumber(seconds)
                + " - " + matchType.getValue();
    }

    @Override
    public boolean isPossibleToConvert(String type) {
        return MatchTimeType.FT.equals(MatchTimeType.valueOf(type)) || MatchTimeType.H2.equals(MatchTimeType.valueOf(type));
    }
}
