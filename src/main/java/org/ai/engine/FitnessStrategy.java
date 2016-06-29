package org.ai.engine;

public interface FitnessStrategy<T> {

    int determineFitness(T specimen);
}
