package com.bernardoms.matchtimeconverter.unit.util;

import com.bernardoms.matchtimeconverter.util.MatchTimeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTimeUtilsTest {
    @Test
    void should_remove_bracket_when_has_brackets_on_string() {
        assertEquals("PM", MatchTimeUtils.removeBracket("[PM]") );
    }
    @Test
    void should_do_nothing_when_there_is_no_brackets_on_string() {
        assertEquals( "PM", MatchTimeUtils.removeBracket("PM"));
    }

    @Test
    void should_pad_number_when_has_only_one_digit() {
        assertEquals("09", MatchTimeUtils.padNumber(9));
        assertEquals("00", MatchTimeUtils.padNumber(0));
    }

    @Test
    void should_do_nothing_when_number_has_at_least_two_digits() {
        assertEquals("99", MatchTimeUtils.padNumber(99));
        assertEquals("100", MatchTimeUtils.padNumber(100));
    }
}
