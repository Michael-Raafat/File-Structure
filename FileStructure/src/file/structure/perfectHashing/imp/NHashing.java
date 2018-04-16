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
public class NHashing implements IPerfectHash {
	/**
	 * hash table.
	 */
	private int[] hashTable;
	/**
	 * Constant of storage size.
	 */
	private static final int LINEAR_CONSTANT = 4;
	/**
	 * list of keys to be hashed.
	 */
	private List<Integer> keys;
	/**
	 * universal hashing.
	 */
	private IUniversalHashing univHash;
	/**
	 * universal hashing.
	 */
	private List<NSquareHashing> nSquareHashs;
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
	public NHashing() {
		keys = new ArrayList<Integer>();
		univHash = new UniversalHashingImp();
		nSquareHashs = new ArrayList<NSquareHashing>();
		reader = new KeyReader();
	}
	@Override
	public final int buildPerfectHashTable(final File file) {
		return this.buildPerfectHashTable(
				reader.readFile(file));
	}

	@Override
	public final boolean search(final int element) {
		int temp = univHash.hash(element);
		if (hashTable[temp] == 0) {
			return false;
		}
		return nSquareHashs.get(hashTable[temp] - 1).search(element);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public final int buildPerfectHashTable(final List<Integer> inKeys) {
		this.keys = inKeys;
		numberOfTries = 0;
		nSquareHashs.clear();
		int n = 2 * keys.size();
		List<Integer>[] arr = new List[n];
		hashTable = new int[n];
		boolean[] flags = new boolean[n];
		univHash.randomizeHashingFunction(n);
		for (int i = 0; i < keys.size(); i++) {
			int temp = univHash.hash(keys.get(i));
			if (!flags[temp]) {
				arr[temp] = new ArrayList<Integer>();
				arr[temp].add(keys.get(i));
			} else if (!arr[temp].contains(keys.get(i)))  {
				arr[temp].add(keys.get(i));

			}
			flags[temp] = true;
		}
		int j = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].size() > 0) {
					IPerfectHash pHash = new NSquareHashing();
					numberOfTries += pHash.buildPerfectHashTable(arr[i]);
					nSquareHashs.add((NSquareHashing) pHash);
					hashTable[i] = j;
					j++;
			}
		}
		if (this.size() > LINEAR_CONSTANT * inKeys.size()) {
//			return 1 + this.buildPerfectHashTable(inKeys);
			return numberOfTries + this.buildPerfectHashTable(inKeys);
		} else {
//			return 0;
			return numberOfTries;
		}
	}

	@Override
	public final int size() {
		int size = 0;
		for (int i = 0; i < nSquareHashs.size(); i++) {
			size += nSquareHashs.get(i).size();
		}
		return size;
	}
}
