package org.ai;

import org.ai.engine.EvolutionConfig;
import org.ai.engine.GeneticAlgorithmRunner;
import org.ai.number.ExampleNumber;
import org.ai.number.LikeNumberStrategy;
import org.ai.number.NumberGenerator;
import org.ai.number.NumberVariationStrategy;

public class GeneticAlgorithmLauncher {
    public static void main( String[] args ) {
        GeneticAlgorithmRunner runner = new GeneticAlgorithmRunner();

        // this config runs for 100 generations.
        // Fitness is determined by how "close" a number is to the number ONE.
        // Reproduction has some random parameters to generate lots of variation
        EvolutionConfig<Number> evolutionConfig = new EvolutionConfig(100,
                new LikeNumberStrategy(ExampleNumber.ONE),
                new NumberVariationStrategy(),
                new NumberGenerator());

        runner.generate(100, evolutionConfig);
    }
}
