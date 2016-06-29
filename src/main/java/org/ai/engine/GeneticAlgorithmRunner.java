package org.ai.engine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GeneticAlgorithmRunner<T> {

    public void generate(int nrOfGenerations, EvolutionConfig<T> evolutionConfig) {
        List<T> firstGeneration = new ArrayList<>();
        for (int nrOfSpecimen = 0; nrOfSpecimen < evolutionConfig.getGenerationSize(); nrOfSpecimen++) {
            firstGeneration.add(evolutionConfig.getSpecimenGenerator().generateSpecimen());
        }

        for (int generationCounter = 0;generationCounter < nrOfGenerations; generationCounter++) {
            //TODO
            // a) determine fitness for all specimen, using the config.getFitnessStrategy
            // b) determine survivors (how? First 10? Add a strategy for this?)
            // c) generate a new generation of [size] specimen, using the config.getReproductionStrategy,
            // repeat
        }
    }
}
