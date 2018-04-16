package file.structure.avl.imp;

import file.structure.avl.interfaces.IAVLTree;
import file.structure.avl.interfaces.INode;

/**
 * 
 * @author Michael.
 * 
 * @param <T> Type of class.
 */
public class AVLTree<T extends Comparable<T>> implements IAVLTree<T> {
	/**
	 * root of the AVLTree.
	 */
	private INode<T> root;
	/**
	 * constructor of AVLTree.
	 */
	public AVLTree() {
		root = null;
	}

	@Override
	public final void insert(final T key) {
		root = this.insert(key, root);
	}
	/**
	 * Updates the height of the node.
	 * @param node
	 * Node that updates the height.
	 */
	private void updateHeight(final INode<T> node) {
		node.setHeight(Math.max(
				getLength(node.getLeftChild()),
				getLength(node.getRightChild())) + 1);
	}
	/**
	 * insert new Node.
	 * @param key value of Node.
	 * @param root2 to be inserted.
	 * @return node.
	 */
	private INode<T> insert(final T key, INode<T> root2) {
		if (root2 == null) {
			return new Node<T>(key, null, null);
		}
		int compare = key.compareTo(root2.getValue());
		if (compare > 0) {
			root2.setRightChild(insert(key, root2.getRightChild()));
		} else if (compare < 0) {
			root2.setLeftChild(insert(key, root2.getLeftChild()));
		} else {
			updateHeight(root2);
			return root2;
		}
		updateHeight(root2);
		root2 = rotationCheck(root2);
		updateHeight(root2);
		return root2;
	}

	@Override
	public final boolean delete(final T key) {
		if (!search(key)) {
			return false;
		} else {
			root = delete(key, root);
			return true;
		}
	}
	/**
	 * Recursive function to delete.
	 * @param key
	 * The key to delete.
	 * @param node
	 * The node to delete.
	 * @return
	 * The root.
	 */
	private INode<T> delete(final T key, INode<T> node) {
		if (node == null) {
			return null;
		}
		int diff = node.getValue().compareTo(key);
		if (diff > 0) {
			node.setLeftChild(delete(key, node.getLeftChild()));
			
		} else if (diff < 0) {
			node.setRightChild(delete(key, node.getRightChild()));
		} else {
			if (node.getLeftChild() != null && node.getRightChild() != null) {
				node.setValue(getMax(node.getLeftChild()).getValue());
				node.setLeftChild(delete(node.getValue(), node.getLeftChild()));
				updateHeight(node);
				return node;
			} else {
				if (node.getLeftChild() != null) {
					return node.getLeftChild();
				} else {
					return node.getRightChild();
				}
			}
		}
		updateHeight(node);
		node = rotationCheck(node);
		updateHeight(node);
		return node;
	}
	/**
	 * Get length of a node.
	 * @param node
	 * Node to get its height.
	 * @return
	 * 0 if it is null, otherwise its height.
	 */
	private int getLength(final INode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return node.getHeight();
		}
	}
	/**
	 * Gets the largest item in the subtree where the root is the
	 * given node.
	 * @param node
	 * The root of the subtree
	 * @return
	 * The largest element.
	 */
	private INode<T> getMax(final INode<T> node) {
		if (node.getRightChild() != null) {
			return getMax(node.getRightChild());
		} else {
			return node;
		}
	}
	@Override
	public final boolean search(final T key) {
		return this.search(key, root);
	}
	/**
	 * search for a key in AVLTree.
	 * @param key value we are searching for.
	 * @param node in tree to get the value from.
	 * @return true if Tree has the key
	 * or false if Tree doesn't have the key. 
	 */
	private boolean search(final T key, final INode<T> node) {
		if (node == null) {
			return false;
		}
		int comp = key.compareTo(node.getValue());
		if (comp > 0) {
			return search(key, node.getRightChild());
		} else if (comp < 0) {
			return search(key, node.getLeftChild());
		} else {
			return true;
		}
	}


	@Override
	public final int height() {
		if (root == null) {
			return -1;
		} else {
			return root.getHeight() - 1;
		}
	}

	@Override
	public final INode<T> getTree() {
		return root;
	}
	/**
	 * rotation method.
	 * @param node that needs rotation.
	 * @return new node.
	 */
	private INode<T> rotateLeftLeft(final INode<T> node) {
		INode<T> temp = node.getLeftChild();
		node.setLeftChild(temp.getRightChild());
		temp.setRightChild(node);
		updateHeight(node);
		updateHeight(temp);
		return temp;
	}
	/**
	 * rotation method.
	 * @param node that needs rotation.
	 * @return new node.
	 */
	private INode<T> rotateRightRight(final INode<T> node) {
		INode<T> temp = node.getRightChild();
		node.setRightChild(temp.getLeftChild());
		temp.setLeftChild(node);
		updateHeight(node);
		updateHeight(temp);
		return temp;
	}
	/**
	 * rotation method.
	 * @param node that needs rotation.
	 * @return new node.
	 */
	private INode<T> doubleLeftRotation(final INode<T> node) {
		node.setLeftChild(rotateRightRight(node.getLeftChild()));
		updateHeight(node);
		return rotateLeftLeft(node);
	}
	/**
	 * rotation method.
	 * @param node that needs rotation.
	 * @return new node.
	 */
	private INode<T> doubleRightRotation(final INode<T> node) {
		node.setRightChild(rotateLeftLeft(node.getRightChild()));
		updateHeight(node);
		return rotateRightRight(node);
	}
	/**
	 * Checks if a node needs rotation and rotates it.
	 * @param root2
	 * Node in need of rotation.
	 * @return
	 * The current top node.
	 */
	private INode<T> rotationCheck(INode<T> root2) {
		int balanceFactor = getLength(root2.getRightChild())
				- getLength(root2.getLeftChild());
		INode<T> temp;
		if (balanceFactor > 1) {
			temp = root2.getRightChild();
			balanceFactor = getLength(temp.getRightChild())
					- getLength(temp.getLeftChild());
			if (balanceFactor > 0) {
				root2 = rotateRightRight(root2);
			} else {
				root2 = doubleRightRotation(root2);
			}
			
		} else if (balanceFactor < -1) {
			temp = root2.getLeftChild();
			balanceFactor = getLength(temp.getRightChild())
					- getLength(temp.getLeftChild());
			if (balanceFactor > 0) {
				root2 = doubleLeftRotation(root2);
			} else {
				root2 = rotateLeftLeft(root2);
			}
		}
		return root2;
	}
}
