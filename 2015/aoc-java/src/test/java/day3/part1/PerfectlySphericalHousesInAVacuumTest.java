package day3.part1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PerfectlySphericalHousesInAVacuumTest {
  @Test
  void shouldDeliverPresentsTo2Houses() {
    final String moves = "^v^v^v^v^v";
    assertEquals(2, PerfectlySphericalHousesInAVacuum.solve(moves));
  }

  @Test
  void shouldDeliverPresentsTo4Houses() {
    final String moves = "^>v<";
    assertEquals(4, PerfectlySphericalHousesInAVacuum.solve(moves));
  }

  @Test
  void shouldDeliverPresentsToXHouses() {
    try {
      final String moves = Files.readString(Path.of("src/main/java/day3/part1/input"));
      assertEquals(2081, PerfectlySphericalHousesInAVacuum.solve(moves));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
