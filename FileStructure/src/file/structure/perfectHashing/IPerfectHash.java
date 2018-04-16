package file.structure.perfectHashing;

import java.io.File;
import java.util.List;

/**
 * The hash table interface for perfect hashing.
 * @author Amr
 * Will be implemented twice, once for every solution.
 */
public interface IPerfectHash {
	/**
	 * read all keys 32-bits from the text
	 * to be able to construct your hash table. 
	 * @param file of keys
	 * @return
	 * Return the number of tries to build the perfect hash table.
	 */
	int buildPerfectHashTable(File file);
	/**
	 * Construct your hash table using the list of keys. 
	 * @param keys a list of keys
	 * @return
	 * Return the number of tries to build the perfect hash table.
	 */
	int buildPerfectHashTable(List<Integer> keys);
	/**
	 * searches if the element is available in the hash table.
	 * @param element
	 * The value to be searched for.
	 * @return
	 * True if the table contains it.
	 */
	boolean search(int element); 
	/**
	 * @return
	 * Returns the size of the hash table in memory.
	 */
	int size();
}
