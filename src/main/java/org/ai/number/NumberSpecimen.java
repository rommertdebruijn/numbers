package org.ai.number;

public class NumberSpecimen {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 9;

    private String numberString;

    public NumberSpecimen(String numberString) {
        this.numberString = numberString;
    }

    public String getNumberString() {
        return numberString;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (int height=0; height < HEIGHT; height++) {
            int start = height * WIDTH;
            int end = (height * WIDTH) + WIDTH;
            sb.append(numberString.substring(start, end)).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
