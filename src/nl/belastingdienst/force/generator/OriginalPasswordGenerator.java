package nl.belastingdienst.force.generator;

import java.util.LinkedList;

public class OriginalPasswordGenerator implements PasswordGenerator {
    private LinkedList<CharacterSupplier> characterSuppliers = new LinkedList<>();


    public OriginalPasswordGenerator() {
        characterSuppliers.add(new CharacterSupplier());
    }

    @Override
    public String getPassword() {
        boolean didGet = false;
        StringBuilder result = new StringBuilder();
        for (CharacterSupplier currentSupplier : characterSuppliers) {
            if (didGet) {
                result.append(currentSupplier.peek());
            } else {
                Character c;
                if (currentSupplier.hasNext()) {
                    c = currentSupplier.next();
                    didGet = true;
                } else {
                    currentSupplier.reset();
                    c = currentSupplier.next();
                }
                result.append(c);
            }
        }

        if(!didGet) {
            addCharacterSupplier();
            return this.getPassword();
        }

        return result.toString();
    }

    private void addCharacterSupplier() {
        characterSuppliers.add(new CharacterSupplier());
        for(CharacterSupplier characterSupplier : characterSuppliers) {
            characterSupplier.reset();
        }
    }

}
