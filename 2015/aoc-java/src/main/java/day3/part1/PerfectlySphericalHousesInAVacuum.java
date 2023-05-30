package day3.part1;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PerfectlySphericalHousesInAVacuum {
  public static long solve(final String moves) {
    int x = 0, y = 0;
    Map<Point, Boolean> visitedHouses = new HashMap<>();

    visitedHouses.put(new Point(x, y), true);
    for (char move : moves.toCharArray()) {
      if (move == '>') {
        visitedHouses.put(new Point(++x, y), true);
      } else if (move == '^') {
        visitedHouses.put(new Point(x, ++y), true);
      } else if (move == '<') {
        visitedHouses.put(new Point(--x, y), true);
      } else {
        visitedHouses.put(new Point(x, --y), true);
      }
    }
    return visitedHouses.values().size();
  }
}
