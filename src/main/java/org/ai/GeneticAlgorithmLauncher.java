package org.ai;

import org.ai.engine.EvolutionConfig;
import org.ai.engine.GeneticAlgorithmRunner;
import org.ai.number.ExampleNumber;
import org.ai.number.GibberishNumberGenerator;
import org.ai.number.LooksLikeNumberEvaluator;
import org.ai.number.NumberReproductionStrategy;

public class GeneticAlgorithmLauncher {
    public static void main( String[] args ) {
        GeneticAlgorithmRunner runner = new GeneticAlgorithmRunner();

        // this config runs for 1000 generations.
        // Fitness is determined by how "close" a number is to the given number.
        // Reproduction has some random parameters to generate of variation

        EvolutionConfig<Integer> evolutionConfig = new EvolutionConfig(1000,
                new LooksLikeNumberEvaluator(ExampleNumber.TWO),
                new NumberReproductionStrategy(5),
                new GibberishNumberGenerator());

        runner.generate(100, evolutionConfig);
    }
}
