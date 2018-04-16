package file.structure.sorting.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import file.structure.sorting.SortingAlgorithm;
import file.structure.sorting.imp.BubbleSort;
import file.structure.sorting.imp.HeapSort;
import file.structure.sorting.imp.InsertionSort;
import file.structure.sorting.imp.IterativeMergeSort;
import file.structure.sorting.imp.IterativeQuickSort;
import file.structure.sorting.imp.RecursiveMergeSort;
import file.structure.sorting.imp.RecursiveQuickSort;
import file.structure.sorting.imp.SelectionSort;

public class SortFunctionalityTest {

	private static final int TEST_SIZE = 1000;
	private SortingAlgorithm<Integer> algo;
	@Before
	public void loadData() {
		algo = new RecursiveMergeSort<Integer>();
//		algo = new IterativeMergeSort<Integer>();
//		algo = new IterativeQuickSort<Integer>();
//		algo = new InsertionSort<Integer>();
//		algo = new RecursiveQuickSort<Integer>();
//		algo = new BubbleSort<Integer>();
//		algo = new SelectionSort<Integer>();
//		algo = new HeapSort<Integer>();
	}
	/**
	 * test with Random array.
	 */
	@Test
	public void testFunctionalityRandom() {
		Integer[] temp = new Integer[TEST_SIZE];
		Random rand = new Random();
		for (int i = 0; i < TEST_SIZE; i++) {
			temp[i] = rand.nextInt(TEST_SIZE);
		}
		Integer[] temp2 = Arrays.copyOf(temp, TEST_SIZE);
		algo.sortArray(temp);
		Arrays.sort(temp2);
		for (int i = 0; i < TEST_SIZE; i++) {
			assertEquals(temp2[i], temp[i]);
		}
	}
	
	/**
	 * test using System.out to output sorted array.
	 */
	@Test
	public void testFunctionalityWithConsole() {
		Integer[] temp = { 7,9,-2,5,4,6,3,8,-1 };
		Integer[] temp2 = Arrays.copyOf(temp, 9);
		algo.sortArray(temp);
		for (int i = 0; i < 9; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
		Arrays.sort(temp2);
		for (int i = 0; i < 9; i++) {
			assertEquals(temp2[i], temp[i]);
		}
	}

}
