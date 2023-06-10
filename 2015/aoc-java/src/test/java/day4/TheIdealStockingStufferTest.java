package day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheIdealStockingStufferTest {
    @Test
    void shouldReturn609043() {
        assertEquals(609_043, TheIdealStockingStuffer.solve("abcdef", "00000"));
    }

    @Test
    void shouldReturn1048970() {
        assertEquals(1_048_970, TheIdealStockingStuffer.solve("pqrstuv", "00000"));
    }

    @Test
    void shouldReturnX() {
        assertEquals(282_749, TheIdealStockingStuffer.solve("yzbqklnj", "00000"));
    }

    @Test
    void shouldReturnXWithDifferentPrefix() {
        assertEquals(9_962_624, TheIdealStockingStuffer.solve("yzbqklnj", "000000"));
    }
}
