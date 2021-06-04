package nl.belastingdienst.force;

import nl.belastingdienst.md5.MD5EncryptionStrategy;

public class MD5Decryptor {

    public String decryptPassword(String hash) {
        MD5EncryptionStrategy md5EncryptionStrategy = new MD5EncryptionStrategy();
        HashBuilder hashBuilder = new HashBuilder();
        String result = "";
        String generatedPass = "";
        while(!result.equals(hash)){
            generatedPass = hashBuilder.get();
            result = md5EncryptionStrategy.encrypt(generatedPass);
        }
        return generatedPass;
    }
}
