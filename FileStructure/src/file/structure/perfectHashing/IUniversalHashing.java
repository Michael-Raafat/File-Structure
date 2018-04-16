package file.structure.perfectHashing;
/**
 * Universal hashing interface.
 * @author Amr
 *
 */
public interface IUniversalHashing {
	/**
	 * Generates a new hashing function.
	 * @param m
	 * The size of the hash table.
	 * @return
	 */
	void randomizeHashingFunction(int m);
	/**
	 * Hashes a value into an index.
	 * @param value
	 * The value to hash.
	 * @return
	 * The index.
	 */
	int hash(int value);
}
