package day11;

public class CorporatePolicy {

    private static boolean increasingStraight(String password) {
        for (int i = 0; i < password.length() - 2; ++i) {
            int[] letters = {
                (int) password.charAt(i), (int) password.charAt(i + 1), (int) password.charAt(i + 2)
            };
            if (letters[0] == letters[1] - 1 && letters[1] == letters[2] - 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean twoDifferentPairsOfLetters(String password) {
        for (int i = 0; i < password.length() - 2; ++i) {
            if (password.charAt(i) != password.charAt(i + 1)) {
                continue;
            }
            char c = password.charAt(i);
            for (int j = i + 2; j < password.length() - 1; ++j) {
                if (password.charAt(j) != c && password.charAt(j) == password.charAt(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean compliablePassword(final String password) {
        if (password.indexOf('i') != -1
                || password.indexOf('o') != -1
                || password.indexOf('l') != -1) {
            return false;
        }
        return increasingStraight(password) && twoDifferentPairsOfLetters(password);
    }

    private static String nextPassword(final String password) {
        StringBuilder nextPassword = new StringBuilder(password);

        int i = nextPassword.length() - 1;
        while (i != 0) {
            if (nextPassword.charAt(i) != 'z') {
                nextPassword.setCharAt(i, (char) (nextPassword.charAt(i) + 1));
                break;
            } else {
                nextPassword.setCharAt(i, 'a');
                --i;
            }
        }
        return nextPassword.toString();
    }

    public static void main(String[] args) {
        String nextPassword = "cqjxjnds";

        // part 1
        while (!compliablePassword(nextPassword)) {
            nextPassword = nextPassword(nextPassword);
        }
        System.out.println(nextPassword);

        // part 2
        nextPassword = nextPassword(nextPassword);
        while (!compliablePassword(nextPassword)) {
            nextPassword = nextPassword(nextPassword);
        }
        System.out.println(nextPassword);
    }
}
