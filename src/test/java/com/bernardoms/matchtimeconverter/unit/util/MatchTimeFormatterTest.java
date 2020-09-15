package com.bernardoms.matchtimeconverter.unit.util;

import com.bernardoms.matchtimeconverter.util.MatchTimeFormatter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTimeFormatterTest {
    @Test
    void should_format_match_rounding_down() {
        var format = MatchTimeFormatter.format("[PM] 35:59.408");
        assertEquals(35, format.getMinute());
        assertEquals(59, format.getSeconds());
    }

    @Test
    void should_format_match_rounding_up() {
        var format = MatchTimeFormatter.format("[PM] 35:59.608");
        assertEquals(36, format.getMinute());
        assertEquals(0, format.getSeconds());
    }
}
