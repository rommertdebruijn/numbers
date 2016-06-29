package org.ai.engine;

public interface FitnessEvaluator<T> {

    int determineFitness(T specimen);
}
