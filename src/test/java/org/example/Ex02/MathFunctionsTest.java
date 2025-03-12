package org.example.Ex02;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionsTest {

    // a)
    @Property
    void testDoubleNumberGreatOrEqual(@ForAll @IntRange(max = 100, min=1) int a) {
        assertTrue(a * 2 >= a);
    }

    // b)
    @Provide
    Arbitrary<Integer> specificNumbers() {
        return Arbitraries.of(-10, -1, 0, 1, 10);
    }

    @Property
    void testValueSpecificNumbers(@ForAll("specificNumbers") int a) {
        assertEquals(a * 2, MathFunctions.multiplyByTwo(a));
    }

    // c)
    @Property
    void testValueMultiplyByTwo (@ForAll @IntRange(max = 100, min=1) int a){
        int result = MathFunctions.multiplyByTwo(a);
        assertEquals(0, result % 2 );
    }
}