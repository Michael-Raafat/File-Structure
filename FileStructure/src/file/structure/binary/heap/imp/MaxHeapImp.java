package file.structure.binary.heap.imp;

import file.structure.binary.heap.MaxHeap;
/**
 * Implementation of the max binary heap.
 * @author Amr
 *
 * @param <T>
 * The class of elements in the heap.
 */
public class MaxHeapImp<T extends Comparable<T>> implements MaxHeap<T> {
	/**
	 * The array containing the elements of the heap.
	 */
	private T[] heapArray;
	/**
	 * The actual number of elements in the heap.
	 */
	private int heapSize;
	/**
	 * The default maximum size of the heap.
	 */
	private static final int DEFAULT_SIZE = 10000;
	/**
	 * Constructor with default size.
	 */
	public MaxHeapImp() {
		this(DEFAULT_SIZE);
	}
	/**
	 * Constructor of the binary heap.
	 * @param maxHeapSize
	 * The maximum size of the binary heap.
	 * Suppress warning :
	 * Casting the array to a generic type.
	 */
	@SuppressWarnings("unchecked")
	public MaxHeapImp(final int maxHeapSize) {
		heapSize = 0;
		heapArray = (T[]) new Comparable[maxHeapSize];  
	}
	@Override
	public final void maxHeapify(final int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < heapSize
				&& heapArray[left].compareTo(heapArray[largest]) > 0) {
			largest = left;
		}
		if (right < heapSize
				&& heapArray[right].compareTo(heapArray[largest]) > 0) {
			largest = right;
		}
		if (largest != i) {
			swapValues(i, largest);
			maxHeapify(largest);
		}
	}
	/**
	 * Swapping function for two elements in the array.
	 * @param i
	 * The index of the first element.
	 * @param j
	 * The index of the second element.
	 */
	private void swapValues(final int i, final int j) {
		T temp = heapArray[i];
		heapArray[i] = heapArray[j];
		heapArray[j] = temp;
	}
	/**
	 * Bubbles up a value to the right place.
	 * @param i
	 * The index of the value to bubble up.
	 */
	private void bubbleUp(final int i) {
		int parent;
		if (i % 2 == 0) {
			parent = i / 2 - 1;
		} else {
			parent = i / 2;
		}
		if (i == parent || parent == -1) {
			return;
		}
		if (heapArray[i].compareTo(heapArray[parent]) > 0) {
			swapValues(i, parent);
			bubbleUp(parent);
		}
	}
	/**
	 * Doubles the size of the heap array.
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		T[] temp = (T[]) new Comparable[heapArray.length * 2];
		for (int i = 0; i < heapSize; i++) {
			temp[i] = heapArray[i];
		}
		heapArray = temp;
	}
	@Override
	public final void maxHeapInsert(final T element) {
		if (heapSize == heapArray.length) {
			resize();
		}
		heapArray[heapSize] = element;
		bubbleUp(heapSize);
		heapSize++;
	}

	@Override
	public final T maxHeapExtract() {
		if (heapSize > 0) {
			heapSize--;
			T temp = heapArray[0];
			swapValues(heapSize, 0);
			maxHeapify(0);
			return temp;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public final void buildMaxHeap(final T[] array) {
		heapArray = array;
		heapSize = array.length;
		for (int i = array.length / 2 - 1; i > -1; i--) {
			maxHeapify(i);
		}
	}

	@Override
	public final void heapSort(final T[] array) {
		buildMaxHeap(array);
		for (int i = heapSize - 1; i > 0; i--) {
			swapValues(i, 0);
			heapSize--;
			maxHeapify(0);
		}
	}

}
