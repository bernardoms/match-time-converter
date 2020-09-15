package com.bernardoms.matchtimeconverter.unit.service;

import com.bernardoms.matchtimeconverter.service.MatchTimeValidatorServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchTimeValidatorServiceImplTest {
    private final MatchTimeValidatorServiceImpl matchTimeValidatorService = new MatchTimeValidatorServiceImpl();

    @Test
    void should_return_true_when_match_time_format_is_valid() {
        assertTrue(matchTimeValidatorService.isValid("[PM] 35:10.408"));
    }

    @Test
    void should_return_false_when_match_time_format_is_invalid() {
        assertFalse(matchTimeValidatorService.isValid("90:00"));
        assertFalse(matchTimeValidatorService.isValid("[PM] -10:00.000"));
        assertFalse(matchTimeValidatorService.isValid("FOO"));
    }

    @Test
    void should_return_invalid_when_match_type_dont_exist() {
        assertFalse(matchTimeValidatorService.isValid("[H3] 35:10.408"));
    }
}
