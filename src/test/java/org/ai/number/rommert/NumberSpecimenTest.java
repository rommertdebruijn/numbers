package org.ai.number.rommert;

import org.ai.number.NumberSpecimen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberSpecimenTest {

    @Test
    public void testToString() {
                String expected =
                "   XXX  \n" +
                "  X   X \n" +
                "      X \n" +
                "   XXX  \n" +
                "     X  \n" +
                "      X \n" +
                "  X   X \n" +
                "  X   X \n" +
                "   XXX  \n";

        String longString =
                "   XXX  " +
                "  X   X " +
                "      X " +
                "   XXX  " +
                "     X  " +
                "      X " +
                "  X   X " +
                "  X   X " +
                "   XXX  ";
        NumberSpecimen specimen = new NumberSpecimen(longString);
        assertEquals(expected, specimen.toString());

    }

}