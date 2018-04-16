package file.structure.sorting.imp;

import file.structure.binary.heap.MaxHeap;
import file.structure.binary.heap.imp.MaxHeapImp;
import file.structure.sorting.SortingAlgorithm;

/**
 * Implementation of the heap sorting algorithm.
 * @author Amr
 * @param <T>
 * Class to be sorted.
 */
public class HeapSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
	/**
	 * heap used in the algorithm.
	 */
	private MaxHeap<T> heap;
	/**
	 * Constructor of the class.
	 */
	public HeapSort() {
		heap = new MaxHeapImp<T>();
	}
	@Override
	public final void sortArray(final T[] array) {
		heap.heapSort(array);
	}

}
