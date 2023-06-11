package day5.part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class NiceOrNaughtyTest {
    @Test
    void shouldBeNice() {
        assertEquals("nice", NiceOrNaughty.solve("qjhvhtzxzqqjkmpb"));
        assertEquals("nice", NiceOrNaughty.solve("xxyxx"));
    }

    @Test
    void shouldBeNaughty() {
        assertEquals("naughty", NiceOrNaughty.solve("uurcxstgmygtbstg"));
        assertEquals("naughty", NiceOrNaughty.solve("ieodomkazucvgmuy"));
        assertEquals("naughty", NiceOrNaughty.solve("aaa"));
    }

    @Test
    void shouldCountHowManyNiceStringsExist() {
        try {
            final List<String> strings = Files.readAllLines(Path.of("src/test/java/day5/input"));
            assertEquals(51, NiceOrNaughty.solve(strings));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
