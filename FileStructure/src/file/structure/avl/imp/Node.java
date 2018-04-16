package file.structure.avl.imp;

import file.structure.avl.interfaces.INode;
/**
 * The implementation of the node interface.
 * @author Amr
 *
 * @param <T>
 * The class of the value of the node.
 */
public class Node<T extends Comparable<T>> implements INode<T> {
	/**
	 * Left Child Node.
	 */
	private INode<T> left;
	/**
	 * Right Child Node.
	 */
	private INode<T> right;
	/**
	 * Value of the Node.
	 */
	private T value;
	/**
	 * height of the node in AvlTree. 
	 */
	private int height;
	/**
	 * constructor of Node giving onlt its Value.
	 * @param val value of the Node.
	 */
	public Node(final T val) {
		this(val, null, null);
	}
	/**
	 * constructor of Node.
	 * @param val value of Node.
	 * @param lef Node which has a value smaller than that of Node.
	 * @param rig Node which has a value larger than that of Node.
	 */
	public Node(final T val, final INode<T> lef, final INode<T> rig) {
		this.value = val;
		this.left = lef;
		this.right = rig;
		this.height = 1;
	}
	
	@Override
	public final INode<T> getLeftChild() {
		return left;
	}

	@Override
	public final INode<T> getRightChild() {
		return right;
	}

	@Override
	public final T getValue() {
		return value;
	}

	@Override
	public final void setValue(final T val) {
		this.value = val;
	}

	@Override
	public final int getHeight() {
		return height;
	}

	@Override
	public final void setLeftChild(final INode<T> node) {
		this.left = node;
	}

	@Override
	public final void setRightChild(final INode<T> node) {
		this.right = node;
	}

	@Override
	public final void setHeight(final int hei) {
		this.height = hei;
	}
}
