package file.structure.sorting;
/**
 * Strategy design pattern for sorting algorithms.
 * Interface for all types of sorting.
 * @author Amr
 *
 * @param <T>
 * Class to be sorted.
 */
public interface SortingAlgorithm<T> {
	/**
	 * Sorts an array in ascending order.
	 * @param array
	 * The array to be sorted.
	 */
	void sortArray(T[] array);
}
