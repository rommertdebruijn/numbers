package org.ai.simple;

import org.ai.engine.SpecimenGenerator;

import java.util.Random;

/**
 * Generates a number between 0 and 200
 */
public class BetweenZeroAndTwoHundredGenerator implements SpecimenGenerator<Integer> {

    public static final int TWO_HUNDRED = 200;

    @Override
    public Integer generateSpecimen() {
        Random random = new Random();
        return random.nextInt(TWO_HUNDRED + 1);
    }
}
