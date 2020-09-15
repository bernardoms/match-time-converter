package com.bernardoms.matchtimeconverter.integration;

import com.bernardoms.matchtimeconverter.exception.InvalidMatchTimeException;
import com.bernardoms.matchtimeconverter.service.MatchTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTimeServiceIntegrationTest extends IntegrationTestConfig {

    @Autowired
    private MatchTimeService matchTimeService;

    @Test
    void should_return_invalid() throws InvalidMatchTimeException {
        assertEquals("INVALID", matchTimeService.converter("90:00"));
        assertEquals("INVALID", matchTimeService.converter("[H3] 90:00.000"));
        assertEquals("INVALID", matchTimeService.converter("[PM] -10:00.000"));
        assertEquals("INVALID", matchTimeService.converter("FOO"));
    }

    @Test
    void should_correct_output() throws InvalidMatchTimeException {

        assertEquals("00:00 - PRE_MATCH", matchTimeService.converter("[PM] 0:00.000"));
        assertEquals("00:15 - FIRST_HALF", matchTimeService.converter("[H1] 0:15.025"));
        assertEquals("03:08 - FIRST_HALF", matchTimeService.converter("[H1] 3:07.513"));
        assertEquals("45:00 - FIRST_HALF", matchTimeService.converter("[H1] 45:00.001"));
        assertEquals("45:00 +01:16 - FIRST_HALF", matchTimeService.converter("[H1] 46:15.752"));
        assertEquals("45:00 - HALF_TIME", matchTimeService.converter("[HT] 45:00.000"));
        assertEquals("90:00 +00:01 - SECOND_HALF", matchTimeService.converter("[H2] 90:00.908"));
        assertEquals("90:00 - FULL_TIME", matchTimeService.converter("[FT] 90:00.000"));

    }
}
