package file.structure.perfectHashing;

import java.io.File;
import java.util.List;

/**
 * Interface of key reader.
 * @author Amr
 *
 */
public interface IKeyReader {
	/**
	 * Reads a list of integers from a file.
	 * Each integer is in a line.
	 * @param file
	 * file to read from.
	 * @return
	 * List of integers read.
	 */
	List<Integer> readFile(File file);
}
