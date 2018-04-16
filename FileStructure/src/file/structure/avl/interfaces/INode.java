package file.structure.avl.interfaces;
/**
 * Interface of the tree node.
 * @author Amr
 *
 * @param <T>
 * Class of the value stored in the node.
 */
public interface INode<T extends Comparable<T>> {
	/**
	* Returns the left child of the current element/node in the heap tree.
	* @return INode wrapper to the left child of the current element/node
	*/
	INode<T> getLeftChild();
	/**
	 * Setter for the left child of the current node.
	 * @param node
	 * The node to be the current node's left child.
	 */
	void setLeftChild(INode<T> node);
	/**
	* Returns the right child of the current element/node in the heap tree.
	* @return INode wrapper to the right child of the current element/node
	*/
	INode<T> getRightChild();
	/**
	 * Setter for the right child of the current node.
	 * @param node
	 * The node to be the current node's right child.
	 */
	void setRightChild(INode<T> node);
	/**
	* Get the value of the current node.
	* @return Value of the current node
	*/
	T getValue();
	/**
	 * Set the value of the current node.
	 * @param value of the current node.
	 */
	void setValue(T value);
	/**
	* Get the Height of the current node.
	* @return height.
	*/
	int getHeight();
	/**
	* Set the Height of the current node.
	* @param hei
	* The new height of the node.
	*/
	void setHeight(int hei);
}
