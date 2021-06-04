package nl.belastingdienst.force;

import nl.belastingdienst.force.generator.OriginalPasswordGenerator;
import nl.belastingdienst.force.generator.PasswordGenerator;
import nl.belastingdienst.force.generator.SplitPasswordGenerator;
import nl.belastingdienst.md5.MD5EncryptionStrategy;
import nl.belastingdienst.md5.MD5Encryptor;

public class MD5Decryptor {

    private static final int maxLength = 8;

    private final MD5Encryptor md5Encryptor = new MD5EncryptionStrategy();
    private final PasswordGenerator passwordGenerator = new SplitPasswordGenerator();

    public String decryptPassword(String hash) {
        String result = "";
        String generatedPass = "";

        while(!result.equals(hash)){
            generatedPass = passwordGenerator.getPassword();
            if(generatedPass.length() > maxLength) return "";
            result = md5Encryptor.encrypt(generatedPass);
        }

        return generatedPass;
    }
}
