package day5.part1;

import java.util.List;
import java.util.regex.Pattern;

public class NiceOrNaughty {
    private static final String VOWELS = "aeiou";
    private static final Pattern DISALLOWED_STRINGS = Pattern.compile("ab|cd|pq|xy");

    /*
     * A nice string is one with all the following properties:
     * It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
     * It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
     * It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
     * */
    public static String solve(final String str) {
        int vowels = 0;
        boolean atLeastThreeVowels = false, doubleLetter = false, noDisallowedSubstrings = true;

        for (int i = 1; i < str.length(); ++i) {
            char currentChar = str.charAt(i), previousChar = str.charAt(i - 1);

            if (VOWELS.indexOf(currentChar) != -1) {
                ++vowels;
            }
            if (currentChar == previousChar) {
                doubleLetter = true;
            }
            if (DISALLOWED_STRINGS.matcher("" + previousChar + currentChar).matches()) {
                noDisallowedSubstrings = false;
            }
        }
        if (vowels >= 3 || vowels == 2 && VOWELS.indexOf(str.charAt(0)) != -1) {
            atLeastThreeVowels = true;
        }
        return atLeastThreeVowels && doubleLetter && noDisallowedSubstrings ? "nice" : "naughty";
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
