package org.ai.engine;

public class EvolutionConfig<T> {
    private final int generationSize;
    private final FitnessStrategy<T> fitnessStrategy;
    private final ReproductionStrategy<T> reproductionStrategy;
    private SpecimenGenerator<T> specimenGenerator;

    /**
     * EvolutionConfig determines the size of each generation,
     * and strategies for a) determining the fitness of a specimen, and b) determining how
     * a new generation is generated from a small number of "survivor" specimen
     * @param generationSize the nr of specimen in a generation
     * @param fitnessStrategy used to determine the fitness of specimens
     * @param reproductionStrategy used to generate new generation from surviving specimens
     * @param specimenGenerator used to generate first generation
     */
    public EvolutionConfig(int generationSize,
                           FitnessStrategy<T> fitnessStrategy,
                           ReproductionStrategy<T> reproductionStrategy,
                           SpecimenGenerator<T> specimenGenerator) {
        this.generationSize = generationSize;
        this.fitnessStrategy = fitnessStrategy;
        this.reproductionStrategy = reproductionStrategy;
        this.specimenGenerator = specimenGenerator;
    }

    public int getGenerationSize() {
        return generationSize;
    }

    public FitnessStrategy<T> getFitnessStrategy() {
        return fitnessStrategy;
    }

    public ReproductionStrategy<T> getReproductionStrategy() {
        return reproductionStrategy;
    }

    public SpecimenGenerator<T> getSpecimenGenerator() {
        return specimenGenerator;
    }
}
