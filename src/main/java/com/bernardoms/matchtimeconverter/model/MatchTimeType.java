package com.bernardoms.matchtimeconverter.model;

import lombok.Getter;

@Getter
public enum MatchTimeType {
    PM("PRE_MATCH"),
    H1("FIRST_HALF"),
    HT("HALF_TIME"),
    H2("SECOND_HALF"),
    FT("FULL_TIME");

    private String value;

    MatchTimeType(String value) {
        this.value = value;
    }
}
