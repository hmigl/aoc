package day2.part1;

import java.util.Arrays;
import java.util.List;

public class IWasToldThereWouldBeNoMath {
  public static int solve(final String presentDimensions) {
    int[] dimensions =
        Arrays.stream(presentDimensions.split("x")).mapToInt(Integer::parseInt).toArray();
    int[] areas = {
      dimensions[0] * dimensions[1], dimensions[1] * dimensions[2], dimensions[0] * dimensions[2]
    };

    int smallestArea = Integer.MAX_VALUE;
    for (int area : areas) {
      smallestArea = Math.min(area, smallestArea);
    }

    return 2 * areas[0] + 2 * areas[1] + 2 * areas[2] + smallestArea;
  }

  public static int solve(final List<String> dimensions) {
    int total = 0;
    for (String presentDimension : dimensions) {
      total += solve(presentDimension);
    }
    return total;
  }
}
