package day5.part1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class NiceOrNaughtyTest {
    @Test
    void shouldBeNiceString() {
        assertEquals("nice", NiceOrNaughty.solve("ugknbfddgicrmopn"));
        assertEquals("nice", NiceOrNaughty.solve("aaa"));
        assertEquals("nice", NiceOrNaughty.solve("aaaa"));
    }

    @Test
    void shouldBeNaughty() {
        assertEquals("naughty", NiceOrNaughty.solve("jchzalrnumimnmhp"));
        assertEquals("naughty", NiceOrNaughty.solve("haegwjzuvuyypxyu"));
        assertEquals("naughty", NiceOrNaughty.solve("dvszwmarrgswjxmb"));
    }

    @Test
    void shouldCountNiceStrings() {
        try {
            final List<String> strings = Files.readAllLines(Path.of("src/test/java/day5/input"));
            assertEquals(236, NiceOrNaughty.solve(strings));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
