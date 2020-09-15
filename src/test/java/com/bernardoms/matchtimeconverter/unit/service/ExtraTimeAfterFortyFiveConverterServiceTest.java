package com.bernardoms.matchtimeconverter.unit.service;

import com.bernardoms.matchtimeconverter.model.MatchTimeType;
import com.bernardoms.matchtimeconverter.service.ExtraTimeAfterFortyFiveConverterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtraTimeAfterFortyFiveConverterServiceTest {

    private final ExtraTimeAfterFortyFiveConverterService extraTimeAfterFortyFiveConverterService = new ExtraTimeAfterFortyFiveConverterService();

    @Test
    void should_return_true_if_is_possible_to_convert() {
        assertTrue(extraTimeAfterFortyFiveConverterService.isPossibleToConvert("H1"));
        assertTrue(extraTimeAfterFortyFiveConverterService.isPossibleToConvert("HT"));
    }

    @Test
    void should_add_extra_time_and_the_match_type_if_is_after_forty_five() {
        assertEquals("45:00 +00:01 - FIRST_HALF",extraTimeAfterFortyFiveConverterService.converter(45,1, MatchTimeType.H1));
        assertEquals("45:00 +01:12 - FIRST_HALF",extraTimeAfterFortyFiveConverterService.converter(46,12, MatchTimeType.H1));
        assertEquals("45:00 +00:01 - HALF_TIME",extraTimeAfterFortyFiveConverterService.converter(45,1, MatchTimeType.HT));
        assertEquals("45:00 +01:12 - HALF_TIME",extraTimeAfterFortyFiveConverterService.converter(46,12, MatchTimeType.HT));
    }


    @Test
    void should_not_add_extra_time_and_the_match_type_if_is_not_after_forty_five() {
        assertEquals("44:59 - FIRST_HALF",extraTimeAfterFortyFiveConverterService.converter(44,59, MatchTimeType.H1));
        assertEquals("45:00 - FIRST_HALF",extraTimeAfterFortyFiveConverterService.converter(45,0, MatchTimeType.H1));
        assertEquals("44:59 - HALF_TIME",extraTimeAfterFortyFiveConverterService.converter(44,59, MatchTimeType.HT));
        assertEquals("45:00 - HALF_TIME",extraTimeAfterFortyFiveConverterService.converter(45,0, MatchTimeType.HT));
    }

    @Test
    void should_return_false_if_is_possible_to_convert() {
        assertFalse(extraTimeAfterFortyFiveConverterService.isPossibleToConvert("H2"));
        assertFalse(extraTimeAfterFortyFiveConverterService.isPossibleToConvert("FT"));
        assertFalse(extraTimeAfterFortyFiveConverterService.isPossibleToConvert("PM"));
    }
}
