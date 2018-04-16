package file.structure.sorting.imp;

import file.structure.sorting.SortingAlgorithm;

/**
 * Quick sort implemented in recursive formula.
 * @author Amr
 * @param <T>
 * The class of the array to be sorted.
 */
public class RecursiveQuickSort<T extends Comparable<T>>
	implements SortingAlgorithm<T> {

	@Override
	public final void sortArray(final T[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * The quick sort recursive function.
	 * @param array
	 * The array to sort.
	 * @param pivotIndex
	 * The index of the pivot.
	 * @param finishIndex
	 * The index of the last item in the array.
	 */
	private void quickSort(final T[] array,
			final int pivotIndex, final int finishIndex) {
		if (pivotIndex < finishIndex) {
			int currentPivotIndex = partition(array, pivotIndex, finishIndex);
			quickSort(array, pivotIndex, currentPivotIndex - 1);
			quickSort(array, currentPivotIndex + 1, finishIndex);
		}
	}
	/**
	 * The partition function.
	 * @param array
	 * The array to partition.
	 * @param pivotIndex
	 * The index of the pivot.
	 * @param finishIndex
	 * The index of the last element in the array.
	 * @return
	 * The current index of the pivot after the partition.
	 */
	private int partition(final T[] array, final int pivotIndex,
			final int finishIndex) {
		T temp = array[finishIndex];
		int i = pivotIndex - 1;
		for (int j = pivotIndex; j < finishIndex; j++) {
			if (array[j].compareTo(temp) < 1) {
				i++;
				swapValues(array, i, j);
			}
		}
		swapValues(array, i + 1, finishIndex);
		return i + 1;
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
