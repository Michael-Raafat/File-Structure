package file.structure.perfectHashing.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import file.structure.perfectHashing.IKeyReader;
/**
 * Implementation of key reader.
 * @author Amr
 *
 */
public class KeyReader implements IKeyReader {

	/**
	 * Constructor.
	 */
	public KeyReader() {
	}

	@Override
	public final List<Integer> readFile(final File file) {
		List<Integer> keys = new ArrayList<Integer>();
		try {
			Scanner scan = new Scanner(file);
			if (!scan.hasNextLine()) {
				scan.close();
				throw new RuntimeException("Not a valid text");
			}
			String[] line = scan.nextLine().split("\\s*,\\s*");
			for (int i = 0; i < line.length; i++) {
				keys.add(Integer.parseInt(line[i]));
			}
			HashSet<Integer> set = new HashSet<Integer>(keys);
			keys = new ArrayList<Integer>(set);
			scan.close();
			return keys;
		} catch (Exception e) {
			throw new RuntimeException("Not a valid text");
		}
	}
}
