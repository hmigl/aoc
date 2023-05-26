package day1.part1;

public class NotQuiteLisp {
  public static int solve(final String instructions) {
    int floor = 0;

    for (char c : instructions.toCharArray()) {
      if (c == '(') {
        ++floor;
      } else {
        --floor;
      }
    }
    return floor;
  }
}