package day2.part1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IWasToldThereWouldBeNoMathTest {
  @Test
  void shouldOrder58() {
    final String presentDimensions = "2x3x4";
    assertEquals(58, IWasToldThereWouldBeNoMath.solve(presentDimensions));
  }

  @Test
  void shouldOrder43() {
    final String presentDimensions = "1x1x10";
    assertEquals(43, IWasToldThereWouldBeNoMath.solve(presentDimensions));
  }

  @Test
  void shouldOrder101() {
    List<String> dimensions = Arrays.asList("2x3x4", "1x1x10");
    assertEquals(101, IWasToldThereWouldBeNoMath.solve(dimensions));
  }

  @Test
  void shouldOrder1586300() {
    try {
      List<String> dimensions = Files.readAllLines(Path.of("src/main/java/day2/part1/input"));
      assertEquals(1586300, IWasToldThereWouldBeNoMath.solve(dimensions));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
