package com.bernardoms.matchtimeconverter.unit.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.service.ExtraTimeAfterNinthConverterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtraTimeAfterNinthConverterServiceTest {
    private final ExtraTimeAfterNinthConverterService extraTimeAfterNinthConverterServiceTest = new ExtraTimeAfterNinthConverterService();

    @Test
    void should_return_true_if_is_possible_to_convert() {
        assertTrue(extraTimeAfterNinthConverterServiceTest.isPossibleToConvert("FT"));
        assertTrue(extraTimeAfterNinthConverterServiceTest.isPossibleToConvert("H2"));
    }

    @Test
    void should_add_extra_time_and_the_match_type_if_is_after_ninth() {
        assertEquals("90:00 +00:01 - SECOND_HALF",extraTimeAfterNinthConverterServiceTest.converter(90,1, MatchTimeType.H2));
        assertEquals("90:00 +01:12 - SECOND_HALF",extraTimeAfterNinthConverterServiceTest.converter(91,12, MatchTimeType.H2));
        assertEquals("90:00 +00:01 - FULL_TIME",extraTimeAfterNinthConverterServiceTest.converter(90,1, MatchTimeType.FT));
        assertEquals("90:00 +01:12 - FULL_TIME",extraTimeAfterNinthConverterServiceTest.converter(91,12, MatchTimeType.FT));
    }


    @Test
    void should_not_add_extra_time_and_the_match_type_if_is_not_after_ninth() {
        assertEquals("89:59 - SECOND_HALF",extraTimeAfterNinthConverterServiceTest.converter(89,59, MatchTimeType.H2));
        assertEquals("90:00 - SECOND_HALF",extraTimeAfterNinthConverterServiceTest.converter(90,0, MatchTimeType.H2));
        assertEquals("89:59 - FULL_TIME",extraTimeAfterNinthConverterServiceTest.converter(89,59, MatchTimeType.FT));
        assertEquals("90:00 - FULL_TIME",extraTimeAfterNinthConverterServiceTest.converter(90,0, MatchTimeType.FT));
    }

    @Test
    void should_return_false_if_is_possible_to_convert() {
        assertFalse(extraTimeAfterNinthConverterServiceTest.isPossibleToConvert("H1"));
        assertFalse(extraTimeAfterNinthConverterServiceTest.isPossibleToConvert("HT"));
        assertFalse(extraTimeAfterNinthConverterServiceTest.isPossibleToConvert("PM"));
    }
}
