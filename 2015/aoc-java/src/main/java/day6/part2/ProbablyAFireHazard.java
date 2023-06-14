package day6.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProbablyAFireHazard {
    private static final int GRID_SIZE = 1000;
    private static final Pattern INSTRUCTION_PATTERN =
            Pattern.compile("(turn on|turn off|toggle) (\\d+,\\d+) through (\\d+,\\d+)");

    public static void executeInstruction(
            int[][] grid, int[] startCoords, int[] endCoords, String command) {
        for (int i = startCoords[0]; i <= endCoords[0]; ++i) {
            for (int j = startCoords[1]; j <= endCoords[1]; ++j) {
                if (command.equals("toggle")) {
                    grid[i][j] += 2;
                } else {
                    grid[i][j] += command.equals("turn on") ? 1 : -1;
                    if (grid[i][j] < 0) {
                        grid[i][j] = 0;
                    }
                }
            }
        }
    }

    public static int solve() {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        final List<String> instructions;

        try {
            instructions =
                    Files.readAllLines(Path.of("src/main/java/day6/input"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String instruction : instructions) {
            Matcher matcher = INSTRUCTION_PATTERN.matcher(instruction);
            if (matcher.matches()) {
                String command = matcher.group(1);
                int[] startCoords =
                        Arrays.stream(matcher.group(2).split(","))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                int[] endCoords =
                        Arrays.stream(matcher.group(3).split(","))
                                .mapToInt(Integer::parseInt)
                                .toArray();

                executeInstruction(grid, startCoords, endCoords, command);
            }
        }

        int totalBrightness = 0;
        for (int i = 0; i < GRID_SIZE; ++i) {
            for (int j = 0; j < GRID_SIZE; ++j) {
                totalBrightness += grid[i][j];
            }
        }
        return totalBrightness;
    }
}
