package org.ai.morehighnumberisbetter;

import org.ai.engine.ReproductionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlusOrMinusTwentyStrategy implements ReproductionStrategy<Integer> {
    @Override
    public List<Integer> generateOffspring(List<Integer> survivors, int newGenerationSize) {
        List<Integer> offspring = new ArrayList<>();
        while (offspring.size() < newGenerationSize) {
            Integer parent = getRandomParent(survivors);
            offspring.add(generateRandomOffspring(parent));
        }
        return offspring;
    }

    private Integer getRandomParent(List<Integer> survivors) {
        ArrayList<Integer> shuffled = new ArrayList<>(survivors);
        Collections.shuffle(shuffled);
        return shuffled.get(0);
    }

    public Integer generateRandomOffspring(Integer parent) {
        // adds random value between -20 to +20 to parent
        Random r = new Random();
        int low = -20;
        int high = +20;
        return parent + r.nextInt(high-low) + low;
    }
}
