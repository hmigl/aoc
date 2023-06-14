package day6.part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProbablyAFireHazardTest {
    @Test
    void shouldIncreaseTotalBrightnessBy2000000() {
        assertEquals(2000000, ProbablyAFireHazard.solve());
    }

    @Test
    void shouldGetTotalBrightness() {
        assertEquals(14110788, ProbablyAFireHazard.solve());
    }
}
