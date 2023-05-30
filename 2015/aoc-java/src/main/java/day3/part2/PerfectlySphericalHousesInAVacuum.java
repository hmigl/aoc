package day3.part2;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PerfectlySphericalHousesInAVacuum {

  private static Point getNextPosition(final Point currentPosition, final char move) {
    if (move == '>') {
      return new Point(currentPosition.x + 1, currentPosition.y);
    } else if (move == '^') {
      return new Point(currentPosition.x, currentPosition.y + 1);
    } else if (move == '<') {
      return new Point(currentPosition.x - 1, currentPosition.y);
    }
    return new Point(currentPosition.x, currentPosition.y - 1);
  }

  public static long solve(final String moves) {
    int x = 0, y = 0;
    Map<Point, Boolean> visitedHouses = new HashMap<>();
    Point santaCurrentPosition = new Point(x, y), roboSantaCurrentPosition = new Point(x, y);

    visitedHouses.put(santaCurrentPosition, true);
    for (int i = 0; i < moves.length(); ++i) {
      char move = moves.charAt(i);
      if (i % 2 == 0) {
        Point nextPosition = getNextPosition(santaCurrentPosition, move);
        visitedHouses.put(nextPosition, true);
        santaCurrentPosition = nextPosition;
      } else {
        Point nextPosition = getNextPosition(roboSantaCurrentPosition, move);
        visitedHouses.put(nextPosition, true);
        roboSantaCurrentPosition = nextPosition;
      }
    }
    return visitedHouses.values().size();
  }
}
