package org.ai.simple;

import org.ai.engine.FitnessEvaluator;

/**
 * scores integers. Uneven integers always score low, even integers score better if they are are higher
 */
public class HighEvenNumberEvaluator implements FitnessEvaluator<Integer> {
    @Override
    public int determineFitness(Integer specimen) {
        if (specimen % 2 != 0) {
            return 0;
        }
        return specimen;
    }
}
