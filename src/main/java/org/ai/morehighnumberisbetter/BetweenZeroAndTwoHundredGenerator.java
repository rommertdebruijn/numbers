package org.ai.morehighnumberisbetter;

import org.ai.engine.SpecimenGenerator;

import java.util.Random;

public class BetweenZeroAndTwoHundredGenerator implements SpecimenGenerator<Integer> {

    public static final int TWO_HUNDRED = 200;

    @Override
    public Integer generateSpecimen() {
        Random random = new Random();
        return random.nextInt(TWO_HUNDRED + 1);
    }
}
