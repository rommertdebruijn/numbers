package org.ai.engine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class GeneticAlgorithmRunner<T> {

    private static final Comparator<EvaluatedSpecimen> SORT_BY_SCORE_DESC = (s1, s2) -> s2.getScore() - (s1.getScore());
    private EvolutionConfig<T> evolutionConfig;

    public List<T> generate(int nrOfGenerations, EvolutionConfig<T> evolutionConfig) {
        this.evolutionConfig = evolutionConfig;
        List<T> firstGeneration = new ArrayList<>();
        for (int nrOfSpecimen = 0; nrOfSpecimen < evolutionConfig.getGenerationSize(); nrOfSpecimen++) {
            firstGeneration.add(evolutionConfig.getSpecimenGenerator().generateSpecimen());
        }

        List<EvaluatedSpecimen<T>> generationWithScore = populateEvaluatedList(firstGeneration);
        List<T> survivors = new ArrayList<>();
        for (int generationCounter = 0;generationCounter < nrOfGenerations; generationCounter++) {
            List<EvaluatedSpecimen<T>> evaluatedSpecimen = evaluate(generationWithScore);
            survivors = determineSurvivors(evaluatedSpecimen);

            renderGeration(generationCounter, survivors);

            if (generationCounter < nrOfGenerations -1) {
                // if this is not the last generation, create offspring and repeat
                List<T> offspring = evolutionConfig.getReproductionStrategy().generateOffspring(survivors, evolutionConfig.getGenerationSize());
                generationWithScore = populateEvaluatedList(offspring);
            }
        }
        return survivors;
    }

    private void renderGeration(int generationCounter, List<T> survivors) {
        System.out.println("generation " + generationCounter + ": " + survivors);
    }

    private List<T> determineSurvivors(List<EvaluatedSpecimen<T>> evaluatedSpecimen) {
        return evaluatedSpecimen.stream().sorted(SORT_BY_SCORE_DESC)
                        .map(EvaluatedSpecimen::getSpecimen)
                        .limit(10)
                        .collect(Collectors.toList());
    }

    private List<EvaluatedSpecimen<T>> populateEvaluatedList(List<T> generation) {
        return generation.stream().map(s -> new EvaluatedSpecimen<T>(s))
                .collect(Collectors.toList());
    }

    private List<EvaluatedSpecimen<T>> evaluate(List<EvaluatedSpecimen<T>> generation) {
        generation.forEach(ev -> ev.setScore(evolutionConfig.getFitnessEvaluator().determineFitness(ev.getSpecimen())));
        return generation;
    }
}
