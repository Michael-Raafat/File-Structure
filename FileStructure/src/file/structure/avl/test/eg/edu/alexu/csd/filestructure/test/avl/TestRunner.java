package file.structure.avl.test.eg.edu.alexu.csd.filestructure.test.avl;

import java.util.Dictionary;

import file.structure.avl.imp.AVLTree;
import file.structure.avl.imp.app.DictionaryImp;
import file.structure.avl.interfaces.IAVLTree;
import file.structure.avl.interfaces.IDictionary;

public class TestRunner {

	public static IAVLTree getImplementationInstance() {
		return new AVLTree();
	}

	public static IDictionary getDicImplementationInstance() {
		return new DictionaryImp();
	}

}
