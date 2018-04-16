package file.structure.sorting.imp;

import file.structure.sorting.SortingAlgorithm;
/**
 * Implementation of Quick Sorting Algorithm using iterative code.
 * @author Michael.
 * 
 * @param <T>
 * type of the class.
 */
public class IterativeQuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sortArray(T[] array) {
		int[] query = new int[array.length];
		int i = 0;
		query[i++] = 0;
		query[i] = array.length - 1;
		while (i > 0) {
			int high = query[i--];
			int low = query[i];
			int part = partition(array, low, high);
			if (part - 1 > low) {
				query[i++] = low;
				query[i] = part - 1;
			}
			if (part + 1 < high) {
				query[i++] = part + 1;
				query[i] = high;
			}
		}
	}
	/**
	 * partitioning arrays.
	 * @param array
	 * array to be sorted.
	 * @param low
	 * start index of sub array in the array.
	 * @param high
	 * final index of sub array in the array.
	 * @return
	 * index of pivot.
	 */
	public int partition(T[] array, int low, int high) {
		T pivot = array[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (array[j].compareTo(pivot) < 0) {
				swapValues(array, j, i);
				i++;
			}
		}
		swapValues(array, high, i);
		return i;
	}
	/**
	 * swap two elements in the array.
	 * @param array
	 * array to be sorted.
	 * @param a
	 * index of elementA.
	 * @param b
	 * index of elementB.
	 */
	public void swapValues(T[] array, int a, int b) {
		T temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
