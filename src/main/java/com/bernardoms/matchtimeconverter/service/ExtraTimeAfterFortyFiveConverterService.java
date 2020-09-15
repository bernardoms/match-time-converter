package com.bernardoms.matchtimeconverter.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.util.MatchTimeUtils;
import org.springframework.stereotype.Service;

@Service
public class ExtraTimeAfterFortyFiveConverterService implements MatchTimeConverter {
    @Override
    public String converter(int minutes, int seconds, MatchTimeType matchType) {
        if (minutes >= 45 && seconds > 0) {
            var extraTimeMinutes = minutes - 45;
            var extraTimeSeconds = seconds;
            minutes = 45;
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
        return MatchTimeType.HT.equals(MatchTimeType.valueOf(type)) || MatchTimeType.H1.equals(MatchTimeType.valueOf(type));
    }
}
