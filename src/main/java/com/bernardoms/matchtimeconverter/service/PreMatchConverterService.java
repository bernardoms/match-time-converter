package com.bernardoms.matchtimeconverter.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.util.MatchTimeUtils;
import org.springframework.stereotype.Service;

@Service
public class PreMatchConverterService implements MatchTimeConverter {
    @Override
    public String converter(int minutes, int seconds, MatchTimeType matchType) {

        return MatchTimeUtils.padNumber(minutes)
                + ":"
                +  MatchTimeUtils.padNumber(seconds)
                + " - "
                +  matchType.getValue();
    }

    @Override
    public boolean isPossibleToConvert(String type) {
        return MatchTimeType.PM.equals(MatchTimeType.valueOf(type));
    }
}
