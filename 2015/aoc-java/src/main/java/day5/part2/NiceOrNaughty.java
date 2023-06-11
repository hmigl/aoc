package day5.part2;

import java.util.List;

public class NiceOrNaughty {
    public static String solve(final String str) {
        boolean letterWhichRepeats = false, pairOfLettersThatAppearsTwice = false;

        for (int i = 0; i < str.length() - 2; ++i) {
            if (str.charAt(i) == str.charAt(i + 2)) {
                letterWhichRepeats = true;
                break;
            }
        }
        for (int i = 0; i < str.length() - 2; ++i) {
            String pair = "" + str.charAt(i) + str.charAt(i + 1);
            if (str.substring(i + 2).indexOf(pair) != -1) {
                pairOfLettersThatAppearsTwice = true;
                break;
            }
        }
        return letterWhichRepeats && pairOfLettersThatAppearsTwice ? "nice" : "naughty";
    }

    public static int solve(final List<String> strings) {
        int nice = 0;

        for (String s : strings) {
            if (solve(s).equals("nice")) {
                ++nice;
            }
        }
        return nice;
    }
}
