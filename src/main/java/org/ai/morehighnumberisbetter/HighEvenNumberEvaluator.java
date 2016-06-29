package org.ai.morehighnumberisbetter;

import org.ai.engine.FitnessEvaluator;

public class HighEvenNumberEvaluator implements FitnessEvaluator<Integer> {
    @Override
    public int determineFitness(Integer specimen) {
        if (specimen % 2 != 0) {
            return 0;
        }
        return specimen;
    }
}
