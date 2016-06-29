package org.ai.number;

public enum ExampleNumber {

    ONE(1, new String[] {
            "    X   ",
            "   XX   ",
            "  X X   ",
            "    X   ",
            "    X   ",
            "    X   ",
            "    X   ",
            "    X   ",
            "  XXXXX "}),
    TWO(2, new String[] {
            "   XX   ",
            "  X   X ",
            "  X   X ",
            "     X  ",
            "    X   ",
            "   X    ",
            "  X     ",
            "  X     ",
            "  XXXXX ",
    }),
    THREE(3, new String[] {
            "   XXX  ",
            "  X   X ",
            "      X ",
            "   XXX  ",
            "     X  ",
            "      X ",
            "  X   X ",
            "  X   X ",
            "   XXX  ",
    });

    private int digit;
    private final String[] stringRepresentation;

    ExampleNumber(int digit, String[] stringRepresentation) {
        this.digit = digit;
        this.stringRepresentation = stringRepresentation;
    }

    public int getDigit() {
        return digit;
    }

    public String[] getStringRepresentation() {
        return stringRepresentation;
    }
}
