package file.structure.sorting.imp;

import file.structure.sorting.SortingAlgorithm;
/**
 * Implementation of the merge sort by using iterative code.
 * @author Amr
 *
 * @param <T>
 * The class to sort.
 */
public class IterativeMergeSort<T extends Comparable<T>>
	implements SortingAlgorithm<T> {

	@Override
	public final void sortArray(final T[] array) {
		for (int subSize = 1; subSize < array.length;
				subSize = subSize * 2) {
			for (int startIndex = 0; startIndex < array.length - 1;
					startIndex += subSize * 2) {
				int finishIndex = Math.min(startIndex + subSize * 2 - 1,
						array.length - 1);
				int middleIndex = startIndex + subSize - 1;
				if (subSize < finishIndex - startIndex + 1) {
					merge(array, startIndex,
						middleIndex,
						finishIndex);
				}
			}
		}
	}
	/**
	 * Merging function.
	 * @param array
	 * The array we are merging.
	 * @param left
	 * The left index of the array to merge.
	 * @param right
	 * The right index of the array to merge.
	 * @param mid
	 * The middle index separating the two sorted sub-arrays.
	 */
	@SuppressWarnings("unchecked")
	private void merge(final T[] array, final int left,
			final int mid, final int right) {
		int leftArrayLength = mid + 1 - left;
		int rightArrayLength = right - mid;
		T[] leftArray = (T[]) new Comparable[leftArrayLength];
		T[] rightArray = (T[]) new Comparable[rightArrayLength];
		for (int i = 0; i < leftArrayLength; i++) {
			leftArray[i] = array[left + i];
		}
		for (int i = 0; i < rightArrayLength; i++) {
			rightArray[i] = array[mid + 1 + i];
		}
		int i = 0, j = 0, k = left;
		while (i < leftArrayLength && j < rightArrayLength) {
			if (leftArray[i].compareTo(rightArray[j]) > 0) {
				array[k] = rightArray[j];
				j++;
			} else {
				array[k] = leftArray[i];
				i++;
			}
			k++;
		}
		while (j < rightArrayLength) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
		while (i < leftArrayLength) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
	}
}
