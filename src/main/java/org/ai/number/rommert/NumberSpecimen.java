package org.ai.number.rommert;

public class NumberSpecimen {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 9;
    private String numberString;

    public NumberSpecimen(String numberString) {
        if (numberString.length() != WIDTH * HEIGHT) {
            throw new IllegalArgumentException();
        }
        this.numberString = numberString;
    }

    public String getNumberString() {
        return numberString;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int height = 0;height<9;height++) {
            sb.append(numberString.substring(height*8, (height*WIDTH) + WIDTH))
            .append("\n");
        }
        return sb.toString();
    }
}
