package day2.part2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class IWasToldThereWouldBeNoMathTest {
  @Test
  void shouldOrder34feet() {
    final String presentDimensions = "2x3x4";
    assertEquals(34, IWasToldThereWouldBeNoMath.solve(presentDimensions));
  }

  @Test
  void shouldOrder14feet() {
    final String presentDimensions = "1x1x10";
    assertEquals(14, IWasToldThereWouldBeNoMath.solve(presentDimensions));
  }

  @Test
  void shouldOrder48feet() {
    List<String> dimensions = Arrays.asList("2x3x4", "1x1x10");
    assertEquals(48, IWasToldThereWouldBeNoMath.solve(dimensions));
  }

  @Test
  void shouldOrder3737498Feet() {
    try {
      List<String> dimensions = Files.readAllLines(Path.of("src/main/java/day2/part2/input"));
      assertEquals(3737498, IWasToldThereWouldBeNoMath.solve(dimensions));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
