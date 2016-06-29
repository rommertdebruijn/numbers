package org.ai.engine;

import java.util.List;

public interface ReproductionStrategy<T> {

    List<T> nextGeneration(List<T> members, int newGenerationSize);
}
