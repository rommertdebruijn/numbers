package org.ai.morehighnumberisbetter;

import org.ai.engine.FitnessStrategy;

public class HighEvenNumberStrategy implements FitnessStrategy<Integer> {
    @Override
    public int determineFitness(Integer specimen) {
        if (specimen % 2 != 0) {
            return 0;
        }
        return specimen;
    }
}
