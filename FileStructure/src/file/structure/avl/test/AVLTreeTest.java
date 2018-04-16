package file.structure.avl.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * The unit test on tree implementation.
 * @author Amr
 *
 */

import file.structure.avl.imp.AVLTree;
import file.structure.avl.interfaces.IAVLTree;
import file.structure.avl.interfaces.INode;
/**
 * The unit test on the avl tree.
 * @author Amr
 *
 */
public class AVLTreeTest {
	/**
	 * Tree interface to test.
	 */
	private IAVLTree<Integer> tree;
	/**
	 * The test size.
	 */
	private static final int TEST_SIZE = 4;
	/**
	 * Length of the test tree.
	 */
	private static final int TEST_LENGTH = 2;
	/**
	 * The function to set up the tree.
	 */
	@Before
	public final void setUp() {
		tree = new AVLTree<Integer>();
	}
	/**
	 * Test the insert of the tree.
	 */
	@Test
	public final void testInsertion() {
		for (int i = 0; i < TEST_SIZE; i++) {
			tree.insert(i);
		}
		Assert.assertEquals(TEST_LENGTH, tree.height());
		INode<Integer> node = tree.getTree();
		Assert.assertEquals(1, (int) node.getValue());
		Assert.assertEquals(0, (int) node.getLeftChild().getValue());
		Assert.assertEquals(2, (int) node.getRightChild().getValue());
		for (int i = 0; i < TEST_SIZE; i++) {
			tree.delete(i);
		}
		for (int i = TEST_SIZE - 1; i > 0; i--) {
			tree.insert(i);
		}
		Assert.assertEquals(1, tree.height());
		node = tree.getTree();
		Assert.assertEquals(2, (int) node.getValue());
		Assert.assertEquals(1, (int) node.getLeftChild().getValue());
		Assert.assertEquals(3, (int) node.getRightChild().getValue());
		tree = new AVLTree<Integer>();
		tree.insert(3);
		tree.insert(0);
		tree.insert(1);
		Assert.assertEquals(1, tree.height());
		node = tree.getTree();
		Assert.assertEquals(1, (int) node.getValue());
		Assert.assertEquals(0, (int) node.getLeftChild().getValue());
		Assert.assertEquals(3, (int) node.getRightChild().getValue());
		tree = new AVLTree<Integer>();
		tree.insert(0);
		tree.insert(3);
		tree.insert(1);
		Assert.assertEquals(1, tree.height());
		node = tree.getTree();
		Assert.assertEquals(1, (int) node.getValue());
		Assert.assertEquals(0, (int) node.getLeftChild().getValue());
		Assert.assertEquals(3, (int) node.getRightChild().getValue());
	}
	/**
	 * Test the height of the tree.
	 */
	@Test
	public final void testHeight() {
		Assert.assertEquals(-1, tree.height());
		tree.insert(0);
		Assert.assertEquals(0, tree.height());
		tree.insert(1);
		Assert.assertEquals(1, tree.height());
		for (int i = 2; i < TEST_SIZE; i++) {
			tree.insert(i);
		}
		Assert.assertEquals(TEST_LENGTH, tree.height());
		tree.insert(TEST_SIZE);
		Assert.assertEquals(TEST_LENGTH, tree.height());
		tree.insert(TEST_SIZE + 1);
		Assert.assertEquals(TEST_LENGTH, tree.height());
		tree.insert(TEST_SIZE + 2);
		Assert.assertEquals(TEST_LENGTH, tree.height());
		tree.insert(TEST_SIZE + 3);
		Assert.assertEquals(TEST_LENGTH + 1, tree.height());
	}
	/**
	 * Test on the searching in the tree.
	 */
	@Test
	public final void testSearch() {
		for (int i = 0; i < TEST_SIZE; i++) {
			tree.insert(i);
			Assert.assertFalse(tree.search(i + 1));
		}
		for (int i = 0; i < TEST_SIZE; i++) {
			Assert.assertTrue(tree.search(i));
		}
	}
	/**
	 * Test on the getTree function in the tree.
	 */
	@Test
	public final void testGetRoot() {
		tree.insert(0);
		Assert.assertEquals(0, (int) tree.getTree().getValue());
		tree.insert(1);
		Assert.assertEquals(0, (int) tree.getTree().getValue());
		tree.insert(2);
		Assert.assertEquals(1, (int) tree.getTree().getValue());
	}
	/**
	 * Test the delete of the tree.
	 */
	@Test
	public final void testDeletion() {
		for (int i = 0; i < TEST_SIZE; i++) {
			tree.insert(i);
		}
		Assert.assertTrue(!tree.delete(-1));
		Assert.assertEquals(TEST_LENGTH, tree.height());
		for (int i = 0; i < TEST_SIZE; i++) {
			Assert.assertTrue(tree.delete(i));
			Assert.assertTrue(!tree.delete(i));
		}
		Assert.assertEquals(-1, tree.height());
		tree.insert(2);
		tree.insert(3);
		tree.insert(1);
		tree.insert(0);
		tree.delete(3);
		INode<Integer> node = tree.getTree();
		Assert.assertEquals(1, tree.height());
		Assert.assertEquals(1, (int) node.getValue());
		Assert.assertEquals(0, (int) node.getLeftChild().getValue());
		Assert.assertEquals(2, (int) node.getRightChild().getValue());
		tree = new AVLTree<Integer>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(0);
		tree.delete(0);
		node = tree.getTree();
		Assert.assertEquals(1, tree.height());
		Assert.assertEquals(2, (int) node.getValue());
		Assert.assertEquals(1, (int) node.getLeftChild().getValue());
		Assert.assertEquals(3, (int) node.getRightChild().getValue());
		tree = new AVLTree<Integer>();
		tree.insert(2);
		tree.insert(3);
		tree.insert(0);
		tree.insert(1);
		tree.delete(3);
		node = tree.getTree();
		Assert.assertEquals(1, tree.height());
		Assert.assertEquals(1, (int) node.getValue());
		Assert.assertEquals(0, (int) node.getLeftChild().getValue());
		Assert.assertEquals(2, (int) node.getRightChild().getValue());
		tree = new AVLTree<Integer>();
		tree = new AVLTree<Integer>();
		tree.insert(1);
		tree.insert(0);
		tree.insert(3);
		tree.insert(2);
		tree.delete(0);
		node = tree.getTree();
		Assert.assertEquals(1, tree.height());
		Assert.assertEquals(2, (int) node.getValue());
		Assert.assertEquals(1, (int) node.getLeftChild().getValue());
		Assert.assertEquals(3, (int) node.getRightChild().getValue());
	}
	/**
	 * Test the insert and delete of the tree.
	 */
	@Test
	public final void testInsertionAndDeletion() {
		tree.insert(15);
		tree.insert(6);
		tree.insert(30);
		tree.insert(4);
		tree.insert(10);
		tree.insert(23);
		tree.insert(50);
		tree.insert(8);
		tree.insert(20);
		tree.insert(28);
		tree.insert(71);
		tree.insert(25);
		tree.insert(1);
		tree.insert(2);
		tree.insert(7);
		tree.insert(100);
		tree.insert(27);
		tree.insert(60);
		tree.insert(70);
		tree.insert(32);
		Assert.assertEquals(4, tree.height());
		Assert.assertEquals(15, (int) tree.getTree().getValue());
		tree.insert(49);
		tree.insert(55);
		Assert.assertEquals(4, tree.height());
		Assert.assertEquals(30, (int) tree.getTree().getValue());
		tree.delete(55);
		tree.delete(49);
		tree.delete(32);
		tree.delete(70);
		tree.delete(60);
		tree.delete(27);
		tree.delete(100);
		Assert.assertEquals(15, (int) tree.getTree().getValue());
		tree.delete(7);
		tree.delete(2);
		tree.delete(1);
		Assert.assertEquals(4, tree.height());
		tree.delete(4);
		Assert.assertEquals(23, (int) tree.getTree().getValue());
		Assert.assertEquals(3, tree.height());
		tree.delete(71);
		tree.delete(50);
		tree.delete(23);
		Assert.assertEquals(3, tree.height());
	}

}
