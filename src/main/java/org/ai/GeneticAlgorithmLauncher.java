package org.ai;

import org.ai.engine.EvolutionConfig;
import org.ai.engine.GeneticAlgorithmRunner;
import org.ai.number.*;

import java.util.List;

public class GeneticAlgorithmLauncher {
    public static void main( String[] args ) {

        // this runs for 100 generations, generating a 1000 children out of the best 10 parents.
        // Fitness is determined by how "close" a number is to the given number.
        // Reproduction strategy has a parameter to generate mutation

        int generationSize = 1000;
        EvolutionConfig<NumberSpecimen> evolutionConfig = new EvolutionConfig<>(
                generationSize,
                new LooksLikeNumberEvaluator(ExampleNumber.TWO),
                new NumberReproductionStrategy(5),
                new GibberishNumberGenerator());

        GeneticAlgorithmRunner<NumberSpecimen> runner = new GeneticAlgorithmRunner<>();
        List<NumberSpecimen> survivors = runner.generate(100, evolutionConfig);
        System.out.println("Final survors: " + survivors.toString());
    }
}
