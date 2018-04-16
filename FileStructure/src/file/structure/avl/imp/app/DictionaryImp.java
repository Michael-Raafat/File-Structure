package file.structure.avl.imp.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import file.structure.avl.imp.AVLTree;
import file.structure.avl.interfaces.IAVLTree;
import file.structure.avl.interfaces.IDictionary;
/**
 * Implementation of the dicitonary interface.
 * @author Amr
 *
 */
public class DictionaryImp implements IDictionary {
	/**
	 * The size of the dictionary.
	 */
	private int size;
	/**
	 * The tree containing the words of the dictionary.
	 */
	private IAVLTree<String> tree;
	/**
	 * Constructor.
	 */
	public DictionaryImp() {
		size = 0;
		tree = new AVLTree<String>();
	}
	@Override
	public final void load(final File file) {
		try {
			Scanner scan = new Scanner(file);
			tree = new AVLTree<String>();
			size = 0;
			while (scan.hasNextLine()) {
				insert(scan.nextLine().trim().toLowerCase());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public final boolean insert(final String word) {
		if (tree.search(word.toLowerCase())) {
			return false;
		} else {
			size++;
			tree.insert(word.toLowerCase());
			return true;
		}
	}

	@Override
	public final boolean exists(final String word) {
		return tree.search(word.toLowerCase());
	}

	@Override
	public final boolean delete(final String word) {
		if (tree.search(word.toLowerCase())) {
			size--;
			tree.delete(word);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public final int size() {
		return size;
	}

	@Override
	public final int height() {
		return tree.height();
	}

}
