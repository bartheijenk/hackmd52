package nl.belastingdienst.force;

import java.util.LinkedList;
import java.util.function.Supplier;

public class HashBuilder implements Supplier<String> {
    private LinkedList<CharacterSupplier> characterSuppliers = new LinkedList<>();


    public HashBuilder() {
        characterSuppliers.add(new CharacterSupplier());
    }

    @Override
    public String get() {
        // links eerst, if exhausted, go right

        boolean didGet = false;
        StringBuilder result = new StringBuilder();
        for (CharacterSupplier currentSupplier : characterSuppliers) {
            if (didGet) {
                result.append(currentSupplier.peek());
            } else {
                Character c = currentSupplier.get();
                if (c != null) {
                    didGet = true;
                } else {
                    currentSupplier.reset();
                    c = currentSupplier.get();
                }
                result.append(c);
            }
        }

        if(!didGet) {
//            characterSuppliers.add(new CharacterSupplier());
            addCharacterSupplier();
            return this.get();
        }

        System.out.println(result);
        return result.toString();
    }

    private void addCharacterSupplier() {
        characterSuppliers.add(new CharacterSupplier());
        for(CharacterSupplier characterSupplier : characterSuppliers) {
            characterSupplier.reset();
        }
    }

    private void resetAll() {
        for (CharacterSupplier sup :
                characterSuppliers) {
            sup.reset();
        }
    }
    // Deze bepaalt de lengte
    /*
     aaaa
     baaa

     abaa
     acaa
     --
     aaa
     baa
     caa
     ..
     zaa
     aba
     bba
    */

}
