package day1.part2;

public class NotQuiteLisp {
  public static int solve(final String instructions) {
    int floor = 0, pos = 1;

    for (char c : instructions.toCharArray()) {
      if (c == '(') {
        ++floor;
      } else {
        --floor;
      }
      if (floor == -1) {
        break;
      }
      ++pos;
    }
    return pos;
  }
}
