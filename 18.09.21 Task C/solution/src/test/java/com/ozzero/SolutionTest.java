package com.ozzero;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import com.ozzero.Solution.MyClass;

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
        assertArrayEquals(new int[]{3, 2, 2, 3}, Solution.dist(4, 2, new MyClass[]
        {
            new MyClass(1, 0),
            new MyClass(2, 1), 
            new MyClass(3, 2),
            new MyClass(4, 3)
        }));
    }

    @Test
    public void Test2() {
        assertArrayEquals(new int[]{4, 2, 8, 4, 2}, Solution.dist(5, 3, new MyClass[]
        {
            new MyClass(3, 0),
            new MyClass(2, 1),
            new MyClass(5, 2),
            new MyClass(1, 3),
            new MyClass(2, 4)
        }));
    }

    @Test
    public void Test3() {
        assertArrayEquals(new int[]{3, 2, 3, 3, 2, 3}, Solution.dist(6, 2, new MyClass[]
        {
            new MyClass(3, 0), 
            new MyClass(2, 1), 
            new MyClass(1, 2), 
            new MyClass(101, 3), 
            new MyClass(102, 4), 
            new MyClass(103, 5)
        }));
        
    }
}
