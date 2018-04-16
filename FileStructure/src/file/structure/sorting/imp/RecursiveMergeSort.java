package file.structure.sorting.imp;

import file.structure.sorting.SortingAlgorithm;
/**
 * Implementation of mergeSort by using Recursive code
 * @author Michael.
 *
 * @param <T>
 * the class to sort
 */
public class RecursiveMergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

	@Override
	public void sortArray(T[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	/**
	 * main method of merge sort that
	 * divides the array into sub arrays to merge them.
	 * @param array
	 * array to be sorted.
	 * @param low
	 * start index of sub array.
	 * @param high
	 * last index of sub array.
	 */
	private void mergeSort(T[] array, int low, int high) {
		if (high > low) {
			int mid = (low + high) / 2;
			mergeSort(array, mid + 1, high);
			mergeSort(array, low, mid);
			merge(array, low, mid, high);
		}
	}
	/**
	 * it sorts sub array.
	 * @param array
	 * array to be sorted.
	 * @param low
	 * first index of sub array.
	 * @param mid
	 * middle index of sub array.
	 * @param high
	 * last index of sub array.
	 */
	@SuppressWarnings("unchecked")
	private void merge(T[] array, int low, int mid, int high) {
		int leftLength = mid - low + 1;
		int rightLength = high - mid;
		T[] leftArray = (T[]) new Comparable[leftLength];
		T[] rightArray = (T[]) new Comparable[rightLength];
		for (int i = 0; i < leftLength; i++) {
			leftArray[i] = array[low + i];
		}
		for (int i = 0; i < rightLength; i++) {
			rightArray[i] = array[mid + 1 + i];
		}
		int i = 0, j = 0, k = low;
		while (i < leftLength && j < rightLength) {
			if (leftArray[i].compareTo(rightArray[j]) > 0) {
				array[k] = rightArray[j];
				j++;
			} else {
				array[k] = leftArray[i];
				i++;
			}
			k++;
		}
		while (j < rightLength) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
		while (i < leftLength) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
	}
}