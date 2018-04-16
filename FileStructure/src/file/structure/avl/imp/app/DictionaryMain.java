package file.structure.avl.imp.app;

import java.io.File;
import java.util.Scanner;

import file.structure.avl.interfaces.IDictionary;

/**
 * The main application of the dictionary.
 * @author Amr
 *
 */
public final class DictionaryMain {
	/**
	 * The private contructor for the utility class.
	 */
	private DictionaryMain() {
	}
	/**
	 * The string of the commands.
	 */
	private static final String SEARCH_COMMAND = "search",
			INSERT_COMMAND = "insert",
			DELETE_COMMAND = "delete",
			HEIGHT_COMMAND = "height",
			SIZE_COMMAND = "size";
	/**
	 * The main function for the program.
	 * @param args
	 * The arguments of the cmd.
	 */
	public static void main(final String[] args) {
		IDictionary dictionary = new DictionaryImp();
		dictionary.load(new File(".\\dictionary.txt"));
		Scanner scan = new Scanner(System.in);
		String input;
		do {
			System.out.println("Enter the command you want to use :");
			System.out.println("1 - " + SEARCH_COMMAND);
			System.out.println("2 - " + INSERT_COMMAND);
			System.out.println("3 - " + DELETE_COMMAND);
			System.out.println("4 - " + HEIGHT_COMMAND);
			System.out.println("5 - " + SIZE_COMMAND);
			input = scan.nextLine().trim().toLowerCase();
			if (input.compareTo(SEARCH_COMMAND) == 0) {
				System.out.println("Enter the word to search for :");
				input = scan.nextLine().trim().toLowerCase();
				if (dictionary.exists(input)) {
					System.out.println("This word exists !");
				} else {
					System.out.println("This word doesn't exist");
				}
			} else if (input.compareTo(INSERT_COMMAND) == 0) {
				System.out.println("Enter the word to insert :");
				input = scan.nextLine().trim().toLowerCase();
				if (dictionary.insert(input)) {
					System.out.println("Word inserted successfully");
				} else {
					System.out.println("This word exists already");
				}
			} else if (input.compareTo(DELETE_COMMAND) == 0) {
				System.out.println("Enter the word to delete :");
				input = scan.nextLine().trim().toLowerCase();
				if (dictionary.delete(input)) {
					System.out.println("Word deleted successfully");
				} else {
					System.out.println("This word doesn't exist in the tree");
				}
			} else if (input.compareTo(HEIGHT_COMMAND) == 0) {
				System.out.println("The height of tree of the dictionary is "
						+ dictionary.height());
			} else if (input.compareTo(SIZE_COMMAND) == 0) {
				System.out.println("The size of the dictionary is "
						+ dictionary.size());
			}
		} while (input != "exit");
		scan.close();
	}

}
