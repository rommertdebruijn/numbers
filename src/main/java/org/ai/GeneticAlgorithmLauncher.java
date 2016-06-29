package org.ai;

import org.ai.engine.EvolutionConfig;
import org.ai.engine.GeneticAlgorithmRunner;
import org.ai.morehighnumberisbetter.BetweenZeroAndTwoHundredGenerator;
import org.ai.morehighnumberisbetter.HighEvenNumberEvaluator;
import org.ai.morehighnumberisbetter.PlusOrMinusTwentyReproductionStrategy;

public class GeneticAlgorithmLauncher {
    public static void main( String[] args ) {
        GeneticAlgorithmRunner runner = new GeneticAlgorithmRunner();

        // this config runs for 100 generations.
        // Fitness is determined by how "close" a number is to the number ONE.
        // Reproduction has some random parameters to generate lots of variation

//        EvolutionConfig<Number> evolutionConfig = new EvolutionConfig(100,
//                new LikeNumberStrategy(ExampleNumber.ONE),
//                new NumberVariationStrategy(),
//                new NumberGenerator());

        EvolutionConfig<Integer> evolutionConfig = new EvolutionConfig(100,
                new HighEvenNumberEvaluator(),
                new PlusOrMinusTwentyReproductionStrategy(),
                new BetweenZeroAndTwoHundredGenerator());

        runner.generate(100, evolutionConfig);
    }
}
