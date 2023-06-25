package day8.part2;

import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Matchsticks {
    public static void main(String[] args) {
        final List<String> strings;
        int numOfCharsInCodeRepr, numOfCharsNewlyEncodedString;

        try {
            strings =
                    Files.readAllLines(Path.of("src/main/java/day8/input"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        numOfCharsInCodeRepr = strings.stream().mapToInt(String::length).sum();

        numOfCharsNewlyEncodedString =
                strings.stream()
                        .map(StringEscapeUtils::escapeJava)
                        .mapToInt(str -> str.length() + 2)
                        .sum();

        System.out.println(numOfCharsNewlyEncodedString - numOfCharsInCodeRepr);
    }
}
