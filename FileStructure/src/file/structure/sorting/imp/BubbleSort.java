package file.structure.sorting.imp;

import file.structure.sorting.SortingAlgorithm;
/**
 * Bubble sort implementation.
 * @author Amr
 *
 * @param <T>
 * The class of the array to be sorted.
 */
public class BubbleSort<T extends Comparable<T>>
	implements SortingAlgorithm<T> {

	@Override
	public final void sortArray(final T[] array) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1].compareTo(array[i]) > 0) {
					swapValues(array, i, i - 1);
					swapped = true;
				}
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
