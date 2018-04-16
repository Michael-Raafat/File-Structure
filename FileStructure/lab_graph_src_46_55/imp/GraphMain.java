package file.structure.graphs.imp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import file.structure.graphs.IGraph;

/**
 * Main class for graph tests delivery.
 * @author Amr
 *
 */
public final class GraphMain {
	/**
	 * Private constructor for utility class.
	 */
	private GraphMain() {
	}
	/**
	 * The main function.
	 * @param args
	 * Command line arguments.
	 */
	public static void main(final String[] args) {
		File testFile = new File(".\\lab_graph_test_46_55");
		IGraph graph = new Graph();
		File[] files = testFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			String[] fileName = files[i].getName().split("_|\\.");
			if (!fileName[fileName.length - 2].equalsIgnoreCase("output")) {
				graph.readGraph(files[i]);
				int[] distances = new int[graph.getVertices().size()];
				String firstLine, secondLine, path;
				path = testFile.getAbsolutePath() + "\\";
				if (fileName[0].equalsIgnoreCase("belman")) {
					firstLine = String.valueOf(
							!graph.runBellmanFord(0, distances));
					secondLine = transformArrayToString(distances);
					path += "belman_ford_" + fileName[2] + "_output.txt";
				} else {
					graph.runDijkstra(0, distances);
					firstLine = transformArrayToString(distances);
					secondLine = transformListToString(
							graph.getDijkstraProcessedOrder());
					path += "dijkstra_" + fileName[1] + "_output.txt";
				}
				File outFile = new File(
						path);
				writeFile(
					firstLine,
					secondLine,
					outFile);
			}
		}
	}
	/**
	 * Returns a string containing the numbers.
	 * @param array
	 * The array of numbers.
	 * @return
	 * String.
	 */
	private static String transformArrayToString(final int[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length - 1; i++) {
			sb.append(array[i]);
			sb.append(" ");
		}
		sb.append(array[array.length - 1]);
		return sb.toString();
	}
	/**
	 * Returns a string containing the numbers.
	 * @param list
	 * The list of numbers.
	 * @return
	 * String.
	 */
	private static String transformListToString(final List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size() - 1; i++) {
			sb.append(list.get(i));
			sb.append(" ");
		}
		sb.append(list.get(list.size() -  1));
		return sb.toString();
	}
	/**
	 * Writes lines in a file.
	 * @param firstLine
	 * The first line to write.
	 * @param secondLine
	 * The second line to write.
	 * @param file
	 * The output file.
	 */
	private static void writeFile(final String firstLine,
			final String secondLine, final File file) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(firstLine);
			writer.newLine();
			writer.write(secondLine);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
