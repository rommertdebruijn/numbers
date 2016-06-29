package org.ai.number;

import org.ai.engine.FitnessEvaluator;

import java.util.ArrayList;
import java.util.Arrays;

public class LooksLikeNumberEvaluator implements FitnessEvaluator<NumberSpecimen> {


    private ExampleNumber exampleNumber;

    public LooksLikeNumberEvaluator(ExampleNumber exampleNumber) {
        this.exampleNumber = exampleNumber;
    }

    /**
     * Compares the string of the specimen with the string of the example
     * @param specimen
     * @return a score, higher if the specimen was more similar to the example
     */
    @Override
    public int determineFitness(NumberSpecimen specimen) {
        int score = 0;
        String specimenString = specimen.getNumberString();
        for (int pos=0; pos < specimenString.length()-1; pos++) {
            if (specimenString.charAt(pos) == exampleNumber.getStringRepresentation().charAt(pos)) {
                score++;
            }
        }
        return score;
    }
}
