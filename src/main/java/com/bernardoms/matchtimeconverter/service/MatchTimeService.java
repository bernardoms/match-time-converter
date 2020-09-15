package com.bernardoms.matchtimeconverter.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.exception.InvalidMatchTimeException;
import com.bernardoms.matchtimeconverter.util.MatchTimeFormatter;
import com.bernardoms.matchtimeconverter.util.MatchTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchTimeService {
    private final List<MatchTimeConverter> matchTimeConverters;
    private final MatchTimeValidator matchTimeValidatorService;

    public String converter(String matchTime) throws InvalidMatchTimeException {
        final var matchWithoutBrackets = MatchTimeUtils.removeBracket(matchTime);
        if (matchTimeValidatorService.isValid(matchTime)) {
            var matchTimeConverter = matchTimeConverters
                    .stream()
                    .filter(mc -> mc.isPossibleToConvert(matchWithoutBrackets.split(" ")[0]))
                    .findFirst()
                    .orElseThrow(() -> new InvalidMatchTimeException("Format " + matchWithoutBrackets + " is invalid!"));

            var matchTimeFormatter = MatchTimeFormatter.format(matchTime);

            return matchTimeConverter.converter(matchTimeFormatter.getMinute(),
                    matchTimeFormatter.getSeconds(),
                    MatchTimeType.valueOf(matchWithoutBrackets.split(" ")[0]));
        }
        return "INVALID";
    }
}
