package org.ai.number.rommert;

import org.ai.engine.FitnessEvaluator;
import org.ai.number.ExampleNumber;

import java.util.ArrayList;
import java.util.Arrays;

public class LooksLikeNumberEvaluator implements FitnessEvaluator<NumberSpecimen> {


    private String exampleNumberString;

    public LooksLikeNumberEvaluator(ExampleNumber exampleNumber) {
        // concat the string representation of the example number to 1 long string
        String[] representation = exampleNumber.getStringRepresentation();
        StringBuilder sb = new StringBuilder();
        new ArrayList<>(Arrays.asList(representation)).forEach(sb::append);
        exampleNumberString = sb.toString(); // store it for future comparison
    }

    @Override
    public int determineFitness(NumberSpecimen specimen) {
        int score = 0;
        String specimenString = specimen.getNumberString();
        for (int pos = 0; pos < specimenString.length()-1;pos++) {
            if (specimenString.charAt(pos) == exampleNumberString.charAt(pos)) {
                score++;
            }
        }
        return score;
    }
}
