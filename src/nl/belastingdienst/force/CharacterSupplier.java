package nl.belastingdienst.force;

import java.util.function.Supplier;

public class CharacterSupplier implements Supplier<Character> {

    private static final char[] charList = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
//    private static final char[] charList = "abc".toCharArray();
    private int index = 0;

    public Character peek() {
        return index < charList.length ? charList[index] : charList[0];
//        return charList[index];
    }

    @Override
    public Character get() {
        if (index < charList.length) {
            return charList[index++];
        }
        return null;
    }

    public void reset() {
        this.index = 0;
    }
}
