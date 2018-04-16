package file.structure.sorting.imp;

import file.structure.sorting.SortingAlgorithm;
/**
 * Selection sort.
 * @author Amr
 *
 * @param <T>
 * Class to be sorted.
 */
public class SelectionSort<T extends Comparable<T>>
	implements SortingAlgorithm<T> {

	@Override
	public final void sortArray(final T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
		    for (int j = i + 1; j < array.length; j++) {
		        if (array[j].compareTo(array[min]) < 0) {
		            min = j;
		        }
		    }
		    if (min != i) {
		        swapValues(array, min, i);
		    }
		}
	}
	/**
	 * Swapping function for two elements in the array.
	 * @param array
	 * The array to swap its items.
	 * @param i
	 * The index of the first element.
	 * @param j
	 * The index of the second element.
	 */
	private void swapValues(final T[] array,
			final int i, final int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
