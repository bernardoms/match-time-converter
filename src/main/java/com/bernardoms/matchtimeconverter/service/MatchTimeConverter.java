package com.bernardoms.matchtimeconverter.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;

public interface MatchTimeConverter {
    String converter(int minutes, int seconds, MatchTimeType matchType);
    boolean isPossibleToConvert(String type);
}
