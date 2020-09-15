package com.bernardoms.matchtimeconverter.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.util.MatchTimeFormatter;
import com.bernardoms.matchtimeconverter.util.MatchTimeUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Pattern;

@Service
public class MatchTimeValidatorServiceImpl implements MatchTimeValidator {
    private final Pattern pattern = Pattern.compile("\\[[a-zA-Z-0-9]{2}] [0-9]{1,2}:[0-9]{2}.[0-9]{3}");

    public boolean isValid(String timeFormat) {
        return validateFormat(timeFormat) && validateTypes(MatchTimeUtils.removeBracket(timeFormat.split(" ")[0])) && validateTypeValue(timeFormat);
    }

    private boolean validateFormat(String timeFormat){
        return pattern.matcher(timeFormat).matches();
    }

    private boolean validateTypes(String type) {
        return Arrays.stream(MatchTimeType.values()).anyMatch(a->a.name().equalsIgnoreCase(type));
    }

    private boolean validateTypeValue(String timeFormat) {
        String matchTimeType = MatchTimeUtils.removeBracket(timeFormat.split(" ")[0]);
        MatchTimeFormatter format = MatchTimeFormatter.format(timeFormat);

        return !MatchTimeType.H2.name().equals(matchTimeType) || format.getMinute() >= 45;
    }
}
