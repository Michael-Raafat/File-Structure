package file.structure.sorting.imp;

import file.structure.sorting.SortingAlgorithm;
/**
 * Insertion Sorting Algorithm.
 * @author Michael.
 *
 * @param <T>
 * type of the class.
 */
public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sortArray(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T temp = array[i];
			int j = i;
			while (j > 0 && array[j - 1].compareTo(temp) > 0) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
	}

}
