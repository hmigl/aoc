package day2.part2;

import java.util.Arrays;
import java.util.List;

public class IWasToldThereWouldBeNoMath {
  public static int solve(final String presentDimensions) {
    int[] dimensions =
        Arrays.stream(presentDimensions.split("x")).mapToInt(Integer::parseInt).toArray();
    int[] perimeters = {
      2 * (dimensions[0] + dimensions[1]),
      2 * (dimensions[1] + dimensions[2]),
      2 * (dimensions[0] + dimensions[2])
    };

    int volume = dimensions[0] * dimensions[1] * dimensions[2];
    int smallestPerimeter = Integer.MAX_VALUE;
    for (int perimeter : perimeters) {
      smallestPerimeter = Math.min(perimeter, smallestPerimeter);
    }
    return smallestPerimeter + volume;
  }

  public static int solve(final List<String> dimensions) {
    int total = 0;

    for (String presentDimension : dimensions) {
      total += solve(presentDimension);
    }
    return total;
  }
}
