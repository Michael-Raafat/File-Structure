package file.structure.binary.heap.imp;

import file.structure.binary.heap.MaxHeap;

/**
 *
 * @author Michael.
 * @param <T>
 * type of class.
 */
public class HeapImp<T extends Comparable<T>> implements MaxHeap<T>{
	/**
	 * heap size.
	 */
	private int heapSize = 0;
	/**
	 * array of heap.
	 */
	private T[] arr;
	/**
	 * constructor without including size.
	 */
	public HeapImp() {
		this(10000);
	}
	/**
	 * constructor with heap size.
	 * @param size 
	 * size of Binary Heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImp(int size){
		this.arr = (T[]) new Comparable[size];
	}
	@Override
	public void buildMaxHeap(T[] array) {
		this.arr = array;
		this.heapSize = array.length;
		for (int i = (
				this.heapSize / 2) - 1; i >= 0; i--) {
			this.maxHeapify(i);
		}
	}
	@Override
	public void heapSort(T[] arr) {
		this.buildMaxHeap(arr);
		int i = this.heapSize - 1;
		while (i > 0) {
			this.swapValues(i, 0);
			this.heapSize--;
			this.maxHeapify(0);
			i--;
		}
	}
	@Override
	public void maxHeapify(int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = 0;
		if (left < this.heapSize &&
				arr[left].compareTo(arr[i]) > 0 ) {
			max = left;
		} else {
			max = i;
		}
		if (right < this.heapSize &&
				arr[right].compareTo(arr[max]) > 0 ) {
			max = right;
		}
		if (max  != i ) {
			this.swapValues(max, i);
			maxHeapify(max);
		}	
	}
	
	private void swapValues(int a , int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public void bubbleUp(int i) {
		if (i < 1) {
			return;
		}
		int temp = (i % 2 == 0) ?
				(i / 2 - 1) : (i / 2);
		if (arr[i].compareTo(arr[temp]) > 0) {
			this.swapValues(i, temp);
			this.bubbleUp(temp);
		}
	}
	@Override
	public void maxHeapInsert(T value) {
		if (this.heapSize == this.arr.length) {
			throw new RuntimeException();
		}
		this.arr[this.heapSize] = value;
		this.bubbleUp(heapSize);
		this.heapSize++;
		
	}
	
	public T[] getHeap() {
		return this.arr;
	}
	@Override
	public T maxHeapExtract() {
		if (this.heapSize < 1) {
			throw new RuntimeException();
		}
		this.heapSize--;
		T temp = this.arr[0];
		this.swapValues(0, this.heapSize);
		this.maxHeapify(0);
		return temp;
	}

}