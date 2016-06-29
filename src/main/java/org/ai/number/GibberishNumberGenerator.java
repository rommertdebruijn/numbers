package org.ai.number;

import org.ai.engine.SpecimenGenerator;

import java.util.Random;

/**
 * Generates random numbers out of 'X' and ' '
 */
public class GibberishNumberGenerator implements SpecimenGenerator<NumberSpecimen> {
    @Override
    public NumberSpecimen generateSpecimen() {

        StringBuilder specimenString = new StringBuilder();
        for (int length=0; length < NumberSpecimen.WIDTH * NumberSpecimen.HEIGHT; length++) {
            specimenString.append(getRandomChar());
        }
        return new NumberSpecimen(specimenString.toString());
    }

    private char getRandomChar() {
        Random random = new Random();
        return random.nextBoolean() ? 'X' : ' ';
    }
}
