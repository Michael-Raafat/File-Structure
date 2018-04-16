package file.structure.avl.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import file.structure.avl.imp.Node;
import file.structure.avl.interfaces.INode;
/**
 * Test on the node class.
 * @author Amr
 *
 */
public class NodeTest {
	/**
	 * Node to test.
	 */
	private INode<Integer> node;
	/**
	 * The value to test it.
	 */
	private static final int TEST_VALUE = 152;
	/**
	 * Sets up the variable before the test.
	 */
	@Before
	public final void setUp() {
		node = new Node<Integer>(null);
	}
	/**
	 * Test on the height of the node.
	 */
	@Test
	public final void testHeight() {
		node.setHeight(TEST_VALUE);
		Assert.assertEquals(node.getHeight(), TEST_VALUE);
	}
	/**
	 * Test on the left child of the node.
	 */
	@Test
	public final void testLeftChild() {
		node.setLeftChild(new Node<Integer>(TEST_VALUE));
		Assert.assertEquals(node.getValue(), null);
		Assert.assertEquals((int) node.getLeftChild().getValue(),
				TEST_VALUE);
	}
	/**
	 * Test on the height of the node.
	 */
	@Test
	public final void testValue() {
		Assert.assertEquals(node.getValue(), null);
		node.setValue(TEST_VALUE);
		Assert.assertEquals((int) node.getValue(), TEST_VALUE);
	}
	/**
	 * Test on the height of the node.
	 */
	@Test
	public final void testRightChild() {
		node.setRightChild(new Node<Integer>(TEST_VALUE));
		Assert.assertEquals(node.getValue(), null);
		Assert.assertEquals((int) node.getRightChild().getValue(),
				TEST_VALUE);
	}

}
