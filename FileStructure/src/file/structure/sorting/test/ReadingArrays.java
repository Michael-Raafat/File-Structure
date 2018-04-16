package file.structure.sorting.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import file.structure.sorting.SortingAlgorithm;
import file.structure.sorting.imp.HeapSort;
/**
 * In case junit test doesn't convince.
 * @author Amr
 *
 */
public final class ReadingArrays {
	/**
	 * Private constructor for utility class.
	 */
	private ReadingArrays() {
	}
	/**
	 * The main method.
	 * @param args
	 * CMD arguments.
	 * @throws FileNotFoundException
	 * File not found.
	 */
	public static void main(final String[] args)
			throws FileNotFoundException {
		Scanner scan = new Scanner(
				new File("C:\\Users\\Amr\\Desktop\\test.txt"));
		List<Integer> list = new ArrayList<Integer>();
		while (scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		Integer[] testArray = new Integer[list.size()];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = list.get(i);
		}
        SortingAlgorithm<Integer> sort = new HeapSort<Integer>();
        sort.sortArray(testArray);
        try {
			FileWriter write = new FileWriter(
					new File("C:\\Users\\Amr\\Desktop\\Answer.txt"));
			for (int i = 0; i < testArray.length; i++) {
				write.append(testArray[i] + " ");
			}
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        for (int i = 0; i < testArray.length; i++) {
        	System.out.print(testArray[i] + " ");
        }
        scan.close();
	}

}
