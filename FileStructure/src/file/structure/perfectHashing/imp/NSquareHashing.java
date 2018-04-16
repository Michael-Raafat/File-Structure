package file.structure.perfectHashing.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import file.structure.perfectHashing.IKeyReader;
import file.structure.perfectHashing.IPerfectHash;
import file.structure.perfectHashing.IUniversalHashing;
/**
 * 
 * @author Michael.
 *
 */
public class NSquareHashing implements IPerfectHash {
	/**
	 * Flags array for the hashing.
	 */
	private boolean[] flags;
	/**
	 * hash table.
	 */
	private int[] hashTable;
	/**
	 * list of keys to be hashed.
	 */
	private List<Integer> keys;
	/**
	 * universal hashing.
	 */
	private IUniversalHashing univHash;
	/**
	 * number of tries to get suitable hash function.
	 */
	private int numberOfTries;
	/**
	 * Key Reader.
	 */
	private IKeyReader reader;
	/**
	 * constructor of NsquareHashing.
	 */
	public NSquareHashing() {
		keys = new ArrayList<Integer>();
		univHash = new UniversalHashingImp();
		reader = new KeyReader();
	}
	
	@Override
	public final int buildPerfectHashTable(final File file) {
		return this.buildPerfectHashTable(
				reader.readFile(file));
	}

	@Override
	public final boolean search(final int element) {
		int index = univHash.hash(element);
		if (flags[index]) {
			return hashTable[index] == element;
		}
		return false;
	}

	@Override
	public final int buildPerfectHashTable(final List<Integer> inKeys) {
		this.keys = inKeys;
		numberOfTries = -1;
		int m = keys.size() * keys.size();
		boolean flag = true;
		while (flag) {
			hashTable = new int[m];
			flags = new boolean[m];
			univHash.randomizeHashingFunction(m);
			flag = false;
			for (int i = 0; i < keys.size(); i++) {
				int temp = univHash.hash(keys.get(i));
				if (!flags[temp]) {
					hashTable[temp] = keys.get(i);
					flags[temp] = true;
				} else if (hashTable[temp] != keys.get(i)) {
					flag = true;
					break;
				}
			}
			numberOfTries++;
		}
		return numberOfTries;
	}

	@Override
	public final int size() {
		return hashTable.length;
	}

}
