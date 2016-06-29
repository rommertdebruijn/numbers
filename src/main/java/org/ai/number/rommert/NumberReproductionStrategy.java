package org.ai.number.rommert;

import org.ai.engine.ReproductionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberReproductionStrategy implements ReproductionStrategy<NumberSpecimen> {

    private int changePercentageChance;

    public NumberReproductionStrategy(int changePercentageChance) {
        this.changePercentageChance = changePercentageChance;
    }

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

    private NumberSpecimen generateChild(NumberSpecimen parent) {
        String parentString = parent.getNumberString();

        StringBuilder childString = new StringBuilder();
        for (int pos = 0;pos<NumberSpecimen.WIDTH*NumberSpecimen.HEIGHT;pos++) {
            if (mutationHappens()) {
                childString.append(flipChar(parentString.charAt(pos)));
            } else {
                childString.append(parentString.charAt(pos));
            }
        }
        return new NumberSpecimen(childString.toString());
    }

    private boolean mutationHappens() {
        Random random = new Random();
        int value = random.nextInt(100);
        return value < changePercentageChance;
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
