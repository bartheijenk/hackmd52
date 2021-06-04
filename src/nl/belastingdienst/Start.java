package nl.belastingdienst;

import nl.belastingdienst.force.MD5Decryptor;

public class Start {
    public static void main(String[] args) {
//        HashBuilder hashBuilder = new HashBuilder();
//        for (int i = 0; i < 200; i++) {
//            System.out.println(hashBuilder.get());
//        }
        trueStart();
    }

    public static void trueStart() {
        MD5Decryptor md5Decryptor = new MD5Decryptor();
        String password = md5Decryptor.decryptPassword("46838bd056169ce807f24062aeab0efe");
        System.out.println(password);
    }

    //hanif00 de5949721e6352f01dfef317c3e898a8
    //admin   46838bd056169ce807f24062aeab0efe
}
