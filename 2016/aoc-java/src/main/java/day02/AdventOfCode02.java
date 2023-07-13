package day02;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventOfCode02 {
    static class Keypad {
        private final String[][] simpleKeypad = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        private final Point posSimpleKeypad = new Point(1, 1);
        private final String[][] enhancedKeypad = {
                {" ", " ", "1", " ", " "},
                {" ", "2", "3", "4", " "},
                {"5", "6", "7", "8", "9"},
                {" ", "A", "B", "C", " "},
                {" ", " ", "D", " ", " "}
        };
        private final Point posEnhancedKeypad = new Point(2, 0);

        public String instructionsToSimpleButton(final String instructions) {
            int x = posSimpleKeypad.x, y = posSimpleKeypad.y;

            for (char c : instructions.toCharArray()) {
                switch (c) {
                    case 'U' -> {
                        if (x > 0) --x;
                    }
                    case 'D' -> {
                        if (x < simpleKeypad.length - 1) ++x;
                    }
                    case 'L' -> {
                        if (y > 0) --y;
                    }
                    default -> {
                        if (y < simpleKeypad.length - 1) ++y;
                    }
                }
            }
            posSimpleKeypad.setLocation(x, y);
            return simpleKeypad[posSimpleKeypad.x][posSimpleKeypad.y];
        }

        public String instructionsToEnhancedButton(final String instructions) {
            int x = posEnhancedKeypad.x, y = posEnhancedKeypad.y;

            for (char c : instructions.toCharArray()) {
                switch (c) {
                    case 'U' -> {
                        if (x > 0 && !enhancedKeypad[x - 1][y].equals(" ")) --x;
                    }
                    case 'D' -> {
                        if (x < enhancedKeypad.length - 1 && !enhancedKeypad[x + 1][y].equals(" ")) ++x;
                    }
                    case 'L' -> {
                        if (y > 0 && !enhancedKeypad[x][y - 1].equals(" ")) --y;
                    }
                    default -> {
                        if (y < enhancedKeypad.length - 1 && !enhancedKeypad[x][y + 1].equals(" ")) ++y;
                    }
                }
            }
            posEnhancedKeypad.setLocation(x, y);
            return enhancedKeypad[posEnhancedKeypad.x][posEnhancedKeypad.y];
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Keypad k = new Keypad();
        Scanner s = new Scanner(new File("src/main/java/day02/input"));
        StringBuilder bathroomCode = new StringBuilder(), actualBathroomCode = new StringBuilder();

        while (s.hasNext()) {
            String lineOfInstructions = s.nextLine();
            String button = k.instructionsToSimpleButton(lineOfInstructions);
            String actualButton = k.instructionsToEnhancedButton(lineOfInstructions);
            bathroomCode.append(button);
            actualBathroomCode.append(actualButton);
        }

        System.out.println(bathroomCode); // part1
        System.out.println(actualBathroomCode); // part2
    }
}
