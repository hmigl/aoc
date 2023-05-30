package day3.part2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class PerfectlySphericalHousesInAVacuumTest {
  @Test
  void shouldDeliverPresentsTo3Houses() {
    final String moves = "^>v<";
    assertEquals(3, PerfectlySphericalHousesInAVacuum.solve(moves));
  }

  @Test
  void shouldDeliverPresentsTo11Houses() {
    final String moves = "^v^v^v^v^v";
    assertEquals(11, PerfectlySphericalHousesInAVacuum.solve(moves));
  }

  @Test
  void shouldDeliverPresentsToXHouses() {
    try {
      final String moves = Files.readString(Path.of("src/main/java/day3/part2/input"));
      assertEquals(2341, PerfectlySphericalHousesInAVacuum.solve(moves));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
