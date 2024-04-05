package me.nego.shortenurl.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Nick
 * @since 2024-04-05
 */
public class HashDigestor {

    private static final String ALGORITHM = "SHA-1";
    public static final String DIGIT_FORMAT = "%02x";

    public static String hash(String original) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(original.getBytes());
        byte[] hashedBytes = digest.digest();
        StringBuilder result = new StringBuilder();
        for (byte hashedByte : hashedBytes) {
            result.append(String.format(DIGIT_FORMAT, hashedByte));
        }
        return result.toString();
    }

}
