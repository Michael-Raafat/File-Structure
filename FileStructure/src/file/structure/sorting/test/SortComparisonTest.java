package file.structure.sorting.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import file.structure.sorting.SortingAlgorithm;
import file.structure.sorting.imp.BubbleSort;
import file.structure.sorting.imp.HeapSort;
import file.structure.sorting.imp.InsertionSort;
import file.structure.sorting.imp.IterativeMergeSort;
import file.structure.sorting.imp.IterativeQuickSort;
import file.structure.sorting.imp.RecursiveMergeSort;
import file.structure.sorting.imp.RecursiveQuickSort;
import file.structure.sorting.imp.SelectionSort;

/**
 * Comparison between the multiple tests.
 * @author Amr
 *
 */
public final class SortComparisonTest {
	/**
	 * Test size.
	 */
	private static final int TEST_SIZE = 70000;
	/**
	 * Average case number.
	 */
	private static final int AVERAGE_NUMBER = 5;
	/**
	 * Private constructor.
	 */
	private SortComparisonTest() {
	}
	/**
	 * Main function to test.
	 * @param args
	 * arguments in cmd.
	 */
	public static void main(final String[] args) {
		List<SortingAlgorithm<Integer>> sortTechniques
			= new ArrayList<SortingAlgorithm<Integer>>();
		addSortingAlgorithms(sortTechniques);
		float[] resultAverage = new float[sortTechniques.size()];
		Random rand = new Random();
		int[] arrayToSort = new int[TEST_SIZE];
		for (int j = 0; j < AVERAGE_NUMBER; j++) {
			for (int i = 0; i < TEST_SIZE; i++) {
				arrayToSort[i] = rand.nextInt();
			}
			for (int i = 0; i < sortTechniques.size(); i++) {
				Integer[] temp = copyArray(arrayToSort);
				float curTime = System.nanoTime();
				sortTechniques.get(i).sortArray(temp);
				float endTime = System.nanoTime();
				resultAverage[i] += (endTime - curTime) ;
			}
		}
		for (int i = 0; i < resultAverage.length; i++) {
			resultAverage[i] /= AVERAGE_NUMBER;
			System.out.println(sortTechniques.get(i).getClass().getName()
					+ " : " + resultAverage[i]);
		}
	}
	/**
	 * Adds the available sorting techniques to a list.
	 * @param list
	 * List of sorting algorithm.
	 */
	private static void addSortingAlgorithms(
			final List<SortingAlgorithm<Integer>> list) {
		list.add(new BubbleSort<Integer>());
		list.add(new SelectionSort<Integer>());
		list.add(new InsertionSort<Integer>());
		list.add(new IterativeMergeSort<Integer>());
		list.add(new IterativeQuickSort<Integer>());
		list.add(new RecursiveMergeSort<Integer>());
		list.add(new RecursiveQuickSort<Integer>());
		list.add(new HeapSort<Integer>());
	}
	/**
	 * Copies an array a deep copy.
	 * @param arr
	 * The array to copy.
	 * @return
	 * A copy of the array.
	 */
	private static Integer[] copyArray(final int [] arr) {
		Integer[] temp = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
}
