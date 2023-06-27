package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class SingleNightDelivery {
    private static final Pattern PATTERN = Pattern.compile("(.*) to (.*) = (\\d+)");

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> cities = new HashSet<>();
        Map<String, Integer> distancesBetweenCities = new HashMap<>();

        Scanner scanner = new Scanner(new File("src/main/java/day9/input"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Matcher matcher = PATTERN.matcher(line);
            if (matcher.matches()) {
                cities.add(matcher.group(1));
                cities.add(matcher.group(2));

                distancesBetweenCities.put(matcher.group(1).concat("->").concat(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                distancesBetweenCities.put(matcher.group(2).concat("->").concat(matcher.group(1)), Integer.parseInt(matcher.group(3)));
            }
        }

        List<Integer> totalDistances = new ArrayList<>();
        for (List<String> permutation : permutations(cities.stream().toList())) {
            int distance = 0;
            for (int i = 0; i < permutation.size() - 1; ++i) {
                distance += distancesBetweenCities.get(permutation.get(i).concat("->").concat(permutation.get(i + 1)));
            }
            totalDistances.add(distance);
        }

        // System.out.println(totalDistances);
        System.out.println(Collections.min(totalDistances)); // part 1
        System.out.println(Collections.max(totalDistances)); // part 2
    }

    private static List<List<String>> permutations(List<String> list) {
        if (list.isEmpty()) {
            List<List<String>> permutations = new ArrayList<>();
            permutations.add(new ArrayList<>());
            return permutations;
        }

        int n = IntStream.rangeClosed(1, list.size()).reduce(1, (x, y) -> x * y);
        Set<List<String>> possiblePermutations = new HashSet<>();
        List<String> modifiableList = new ArrayList<>(list);
        while (possiblePermutations.size() != n) {
            Collections.shuffle(modifiableList);
            possiblePermutations.add(new ArrayList<>(modifiableList));
        }
        return possiblePermutations.stream().toList();
    }
}
