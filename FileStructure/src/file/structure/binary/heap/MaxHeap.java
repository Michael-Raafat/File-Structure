package file.structure.binary.heap;
/**
 * Interface of a max binary heap.
 * @author Amr
 *
 * @param <T>
 */
public interface MaxHeap<T> {
	/**
	 * Does the heapify process which is responsible of
	 * keeping our strucutre right.
	 * @param i
	 * The index to heapify at.
	 */
	void maxHeapify(int i);
	/**
	 * Inserts a new element in the binary heap.
	 * @param element
	 * Element to be added
	 */
	void maxHeapInsert(T element);
	/**
	 * Extracts the maximum element in the binary heap.
	 * @return
	 * The maximum value in the binary heap.
	 */
	T maxHeapExtract(); 
	/**
	 * Builds the binary heap from an existing array.
	 * @param array
	 * The array to build from the heap. A pointer is taken to the array.
	 */
	void buildMaxHeap(T[] array);
	/**
	 * Heap sort.
	 * @param array
	 * array to be sorted.
	 */
	void heapSort(T[] array);
}
