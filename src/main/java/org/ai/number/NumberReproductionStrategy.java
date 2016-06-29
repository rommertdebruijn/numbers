package org.ai.number;

import org.ai.engine.ReproductionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberReproductionStrategy implements ReproductionStrategy<NumberSpecimen> {

    private int mutationChance;

    /**
     * @param mutationChance defines the chance that a mutation occurs
     */
    public NumberReproductionStrategy(int mutationChance) {
        this.mutationChance = mutationChance;
    }

    /**
     * Generates a new generation
     * @param survivors
     * @param newGenerationSize
     * @return a new generation of NumberSpecimens
     */
    @Override
    public List<NumberSpecimen> generateOffspring(List<NumberSpecimen> survivors, int newGenerationSize) {
        List<NumberSpecimen> offspring = new ArrayList<>();
        while (offspring.size() < newGenerationSize) {
            NumberSpecimen parent = getRandomParent(survivors);
            NumberSpecimen child = generateChild(parent);
            offspring.add(child);
        }
        return offspring;
    }

    /**
     * Given a parent, generates a child that is similar to the parent
     * @param parent
     * @return the child
     */
    private NumberSpecimen generateChild(NumberSpecimen parent) {
        String parentString = parent.getNumberString();

        StringBuilder childString = new StringBuilder();
        for (int pos=0; pos < NumberSpecimen.WIDTH * NumberSpecimen.HEIGHT; pos++) {
            char c = mutationHappens() ? flipChar(parentString.charAt(pos)) : parentString.charAt(pos);
            childString.append(c);
        }
        return new NumberSpecimen(childString.toString());
    }

    private boolean mutationHappens() {
        Random random = new Random();
        int value = random.nextInt(100);
        return value < mutationChance;
    }

    private NumberSpecimen getRandomParent(List<NumberSpecimen> survivors) {
        ArrayList<NumberSpecimen> shuffled = new ArrayList<>(survivors);
        Collections.shuffle(shuffled);
        return shuffled.get(0);
    }

    private char flipChar(char original) {
        return original == 'X' ? ' ' : 'X';
    }
}
