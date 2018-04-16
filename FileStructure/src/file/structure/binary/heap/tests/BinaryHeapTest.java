package file.structure.binary.heap.tests;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import file.structure.binary.heap.MaxHeap;
import file.structure.binary.heap.imp.MaxHeapImp;
/**
 * Tests for the binary heap.
 * @author Amr
 *
 */
public class BinaryHeapTest {
	/**
	 * Heap to test.
	 */
	private MaxHeap<Integer> heap;
	/**
	 * The test size.
	 */
	private static final int TEST_SIZE = 10000;
	/**
	 * Sets up the usually used variables.
	 */
	@Before
	public final void setUp() {
		heap = new MaxHeapImp<Integer>(TEST_SIZE);
	}
	/**
	 * Test on the insertion and deletion of the binary heap
	 * and on the heapify process.
	 */
	@Test
	public final void testInsertionAndExtraction() {
		try {
			heap.maxHeapExtract();
			Assert.fail("Should throw error, extraction on empty heap.");
		} catch (Exception e) {
			for (int i = 0; i < TEST_SIZE; i++) {
				heap.maxHeapInsert(i);
			}
			for (int i = TEST_SIZE - 1; i > -1; i--) {
				Assert.assertEquals(i, (int) heap.maxHeapExtract());
			}
		}
	}
	/**
	 * Test on the building heap function.
	 */
	@Test
	public final void testBuildHeap1() {
		Integer[] testArray = new Integer[TEST_SIZE];
		for (int i = 0; i < TEST_SIZE; i++) {
			testArray[i] = i;
		}
		heap.buildMaxHeap(testArray);
		for (int i = TEST_SIZE - 1; i > -1; i--) {
			Assert.assertEquals(i, (int) heap.maxHeapExtract());
		}
	}
	/**
	 * Test on the building heap function.
	 */
	@Test
	public final void testBuildEmptyHeap2() {
		Integer[] testArray = new Integer[0];
		heap.buildMaxHeap(testArray);
	}
	/**
	 * Test sort array.
	 */
	@Test
	public final void testSortArray() {
		Integer[] testArray = new Integer[TEST_SIZE];
		for (int i = TEST_SIZE - 1; i > -1; i--) {
			testArray[TEST_SIZE - 1 - i] = i;
		}
		heap.heapSort(testArray);
		for (int i = 0; i < TEST_SIZE; i++) {
			Assert.assertEquals(i, (int) testArray[i]);
		}
	}
	/**
	 * Test on the extraction and build heap functions.
	 */
	@Test
	public final void testBuildAndExtract() {
		Integer[] testArray = new Integer[TEST_SIZE];
		Random rand = new Random();
		for (int i = 0; i < TEST_SIZE; i++) {
			testArray[i] = rand.nextInt();
		}
		Integer[] temp = Arrays.copyOf(testArray, TEST_SIZE);
		heap.buildMaxHeap(testArray);
		Arrays.sort(temp);
		for (int i = TEST_SIZE - 1; i > -1; i--) {
			Assert.assertEquals((int) temp[i], (int) heap.maxHeapExtract());
		}
	}
	/**
	 * Test on resizing after reaching max elements.
	 */
	@Test
	public final void testResize() {
		try {
			for (int i = 0; i <= TEST_SIZE; i++) {
				heap.maxHeapInsert(i);
			}
		} catch (Throwable e) {
			Assert.fail();
		}
	}
}
