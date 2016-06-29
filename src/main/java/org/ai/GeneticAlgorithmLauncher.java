package org.ai;

import org.ai.engine.EvolutionConfig;
import org.ai.engine.GeneticAlgorithmRunner;
import org.ai.number.ExampleNumber;
import org.ai.number.rommert.GibberishNumberGenerator;
import org.ai.number.rommert.LooksLikeNumberEvaluator;
import org.ai.number.rommert.NumberReproductionStrategy;

public class GeneticAlgorithmLauncher {
    public static void main( String[] args ) {
        GeneticAlgorithmRunner runner = new GeneticAlgorithmRunner();

        // this config runs for 100 generations.
        // Fitness is determined by how "close" a number is to the number ONE.
        // Reproduction has some random parameters to generate lots of variation

        EvolutionConfig<Integer> evolutionConfig = new EvolutionConfig(100,
                new LooksLikeNumberEvaluator(ExampleNumber.ONE),
                new NumberReproductionStrategy(5),
                new GibberishNumberGenerator());

        runner.generate(100, evolutionConfig);
    }
}
