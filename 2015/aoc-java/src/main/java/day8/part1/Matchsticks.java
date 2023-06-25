package day8.part1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Matchsticks {
    public static void main(String[] args) {
        int numOfCharsInMemory, numOfCharsInCodeRepr;
        final List<String> strings;

        try {
            strings =
                    Files.readAllLines(Path.of("src/main/java/day8/input"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        numOfCharsInCodeRepr = strings.stream().mapToInt(String::length).sum();
        numOfCharsInMemory =
                strings.stream()
                        .map(str -> str.replaceAll("\\\\\\\\", "b")) // (escaped backslash)
                        .map(str -> str.replaceAll("\\\\\"", "q")) // (escaped quote)
                        .map(str -> str.replaceAll("\"", "")) // (lone quote)
                        .map(str -> str.replaceAll("\\\\x[0-9a-f]{2}", "x")) // (single char)
                        .mapToInt(String::length)
                        .sum();

        System.out.println(numOfCharsInCodeRepr - numOfCharsInMemory);
    }
}
