package org.ai.number.rommert;

import org.ai.engine.SpecimenGenerator;

import java.util.Random;

public class GibberishNumberGenerator implements SpecimenGenerator<NumberSpecimen> {
    @Override
    public NumberSpecimen generateSpecimen() {
        StringBuilder specimenString = new StringBuilder();
        for (int length = 0; length<NumberSpecimen.WIDTH * NumberSpecimen.HEIGHT;length++) {
            char aChar = getRandomChar();
            specimenString.append(aChar);
        }
        return new NumberSpecimen(specimenString.toString());
    }

    private char getRandomChar() {
        Random random = new Random();
        boolean b = random.nextBoolean();
        return b ? 'X' : ' ';
    }
}
