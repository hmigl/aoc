package day6.part1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProbablyAFireHazardTest {
    @Test
    void shouldTurnOnXLines() {
        assertEquals(377891, ProbablyAFireHazard.solve());
    }
}
