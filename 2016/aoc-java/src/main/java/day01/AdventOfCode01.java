package day01;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.*;

public class AdventOfCode01 {
    enum Direction {
        NORTH(0, -1),
        SOUTH(0, 1),
        EAST(1, 0),
        WEST(-1, 0);

        static {
            NORTH.right = EAST;
            NORTH.left = WEST;

            SOUTH.right = WEST;
            SOUTH.left = EAST;

            EAST.right = SOUTH;
            EAST.left = NORTH;

            WEST.right = NORTH;
            WEST.left = SOUTH;
        }

        private final int dx, dy;
        private Direction left, right;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

    }

    public static void main(String[] args) {
        final List<String> sequences;

        try {
            String s = Files.readString(Path.of("src/main/java/day01/input"));
            sequences = new ArrayList<>(Arrays.stream(s.split(", ")).toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int distance = 0, x = 0, y = 0;
        final Point origin = new Point(0, 0);
        Direction current = Direction.NORTH;
        Set<Point> visited = new HashSet<>();

        for (String sequence : sequences) {
            int blocks = Integer.parseInt(sequence.substring(1));
            current = sequence.startsWith("L") ? current.left : current.right;

            for (int i = 0; i < blocks; ++i) {
                x += current.dx;
                y += current.dy;

                final Point p = new Point(x, y);
                distance = Math.abs(origin.x - x) + Math.abs(origin.y - y);
                if (visited.contains(p)) {
                    System.out.println("got'em " + distance); // part 2
                    continue;
                }
                visited.add(p);
            }
        }

        System.out.println(distance); // part 1
    }
}
