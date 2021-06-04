package nl.belastingdienst.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5EncryptionStrategy {

    private static final String ALGORITHM = "MD5";

    public String encrypt(String phrase) {
        try {
            MessageDigest m = MessageDigest.getInstance(ALGORITHM);
            m.update(phrase.getBytes(), 0, phrase.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//[a-z0-9]
