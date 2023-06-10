package day4;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TheIdealStockingStuffer {
    private static final MessageDigest MESSAGE_DIGEST;

    static {
        try {
            MESSAGE_DIGEST = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static int solve(final String secretKey, final String prefix) {
        int lowestPositiveNumber = 1;

        while (true) {
            byte[] bytes =
                    secretKey
                            .concat(String.valueOf(lowestPositiveNumber))
                            .getBytes(StandardCharsets.UTF_8);
            String hash = String.format("%032x", new BigInteger(1, MESSAGE_DIGEST.digest(bytes)));
            if (hash.startsWith(prefix)) {
                break;
            }
            ++lowestPositiveNumber;
        }
        return lowestPositiveNumber;
    }
}
