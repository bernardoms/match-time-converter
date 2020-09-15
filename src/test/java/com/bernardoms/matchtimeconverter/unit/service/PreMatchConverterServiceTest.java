package com.bernardoms.matchtimeconverter.unit.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.service.PreMatchConverterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreMatchConverterServiceTest {
    private final PreMatchConverterService preMatchConverterService = new PreMatchConverterService();

    @Test
    void should_return_true_if_is_possible_to_convert() {
        assertTrue(preMatchConverterService.isPossibleToConvert("PM"));
    }

    @Test
    void should_format_string_in_pre_match_format() {
        assertEquals("90:01 - PRE_MATCH",preMatchConverterService.converter(90,1, MatchTimeType.PM));
        assertEquals("91:12 - PRE_MATCH",preMatchConverterService.converter(91,12, MatchTimeType.PM));
        assertEquals("45:00 - PRE_MATCH",preMatchConverterService.converter(45,0, MatchTimeType.PM));
        assertEquals("44:59 - PRE_MATCH",preMatchConverterService.converter(44,59, MatchTimeType.PM));
    }

    @Test
    void should_return_false_if_is_possible_to_convert() {
        assertFalse(preMatchConverterService.isPossibleToConvert("H1"));
        assertFalse(preMatchConverterService.isPossibleToConvert("HT"));
        assertFalse(preMatchConverterService.isPossibleToConvert("FT"));
        assertFalse(preMatchConverterService.isPossibleToConvert("H2"));
    }
}
