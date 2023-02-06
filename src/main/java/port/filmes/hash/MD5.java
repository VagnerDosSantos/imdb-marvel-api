package port.filmes.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String hash(String value) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(value.getBytes(), 0, value.length());

        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
