package com.ozzero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void Test1() {
        assertEquals(1, Solution.func(2, new int[]{1, 2}));
    }

    @Test
    public void Test2() {
        assertEquals(4, Solution.func(5, new int[]{1, 1, 5, 5, 5}));
    }

    @Test
    public void Test3() {
        assertEquals(-1, Solution.func(3, new int[]{3, 2, 1}));
    }

    @Test
    public void Test4() {
        assertEquals(0, Solution.func(1, new int[]{3}));
    }


    @Test
    public void Test5() {
        assertEquals(4, Solution.func(5, new int[]{1, 2, 5, 5, 5}));
    }

    @Test 
    public void Test6() {
        assertEquals(-1, Solution.func(7, new int[]{4, 1, 1, 3, 3, 3, 3}));
    }

    @Test
    public void Test7() {
        assertEquals(6, Solution.func(7, new int[]{3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void Test8() {
        assertEquals(0, Solution.func(7, new int[]{3, 3, 3, 3, 3, 3, 3}));
    }

    @Test
    public void Test9() {
        assertEquals(0, Solution.func(0, new int[]{}));
    }

    @Test
    public void Test10() {
        assertEquals(-1, Solution.func(4, new int[]{3, 1, 1, 3}));
    }
}
