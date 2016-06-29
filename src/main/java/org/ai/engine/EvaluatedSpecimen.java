package org.ai.engine;

public class EvaluatedSpecimen<T> {

    private T specimen;
    private int score;

    public EvaluatedSpecimen(T specimen) {
        this.specimen = specimen;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public T getSpecimen() {
        return specimen;
    }

    public int getScore() {
        return score;
    }
}
