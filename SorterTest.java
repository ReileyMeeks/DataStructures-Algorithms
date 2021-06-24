/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_7;

import lab_7.Sorter;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 *
 * @author dhruv
 */
public class SorterTest {

    public SorterTest() {
    }

    /**
     * Test of quickSort method, of class Sorter.
     */
    @Test
    public void test1() {
        System.out.println("quickSort (Even sized array)");

        Integer[] unsorted = {25, 39, 42, 78, 52, 68, 28, 32, 0, 47};
        Sorter<Integer> instance = new Sorter<Integer>(unsorted);
        Integer[] result = instance.quickSort();

        Integer[] sorted = unsorted.clone();
        Arrays.sort(sorted, 0, sorted.length);

        System.out.println("\tExpected: " + Arrays.toString(sorted));
        System.out.println("\tResult: " + Arrays.toString(result));

        assertArrayEquals(sorted, result);
    }

    /**
     * Test of mergeSort method, of class Sorter.
     */
    @Test
    public void test2() {
        System.out.println("mergeSort (Even sized array)");

        Integer[] unsorted = {25, 39, 42, 78, 52, 68, 28, 32, 0, 47};
        Sorter<Integer> instance = new Sorter<Integer>(unsorted);
        Integer[] result = instance.mergeSort();

        Integer[] sorted = unsorted.clone();
        Arrays.sort(sorted, 0, sorted.length);

        System.out.println("\tExpected: " + Arrays.toString(sorted));
        System.out.println("\tResult: " + Arrays.toString(result));

        assertArrayEquals(sorted, result);
    }

    /**
     * Test of quickSort method, of class Sorter.
     */
    @Test
    public void test4() {
        System.out.println("quickSort (Odd sized array)");

        Integer[] unsorted = {25, 39, 42, 52, 68, 28, 32, 0, 47};
        Sorter<Integer> instance = new Sorter<Integer>(unsorted);
        Integer[] result = instance.quickSort();

        Integer[] sorted = unsorted.clone();
        Arrays.sort(sorted, 0, sorted.length);

        System.out.println("\tExpected: " + Arrays.toString(sorted));
        System.out.println("\tResult: " + Arrays.toString(result));

        assertArrayEquals(sorted, result);
    }

    /**
     * Test of mergeSort method, of class Sorter.
     */
    @Test
    public void test5() {
        System.out.println("mergeSort (Odd sized array)");

        Integer[] unsorted = {25, 39, 42, 52, 68, 28, 32, 0, 47};
        Sorter<Integer> instance = new Sorter<Integer>(unsorted);
        Integer[] result = instance.mergeSort();

        Integer[] sorted = unsorted.clone();
        Arrays.sort(sorted, 0, sorted.length);

        System.out.println("\tExpected: " + Arrays.toString(sorted));
        System.out.println("\tResult: " + Arrays.toString(result));

        assertArrayEquals(sorted, result);
    }
}
