package day10;

public class ElvesLookElvesSay {

    public static String elvesLookElvesSay(final String sequence) {
        StringBuilder next = new StringBuilder();

        for (int i = 0; i < sequence.length(); ++i) {
            int numberOfDigits = 1;
            char c = sequence.charAt(i);

            while (i + 1 < sequence.length() && sequence.charAt(i + 1) == c) {
                ++i;
                ++numberOfDigits;
            }
            next.append(numberOfDigits).append(c);
        }
        return next.toString();
    }

    public static void main(String[] args) {
        String sequence = "1113122113";

        int n = 50;
        for (int i = 0; i < n; ++i) {
            sequence = elvesLookElvesSay(sequence);
        }
        System.out.println(sequence.length());
    }
}
