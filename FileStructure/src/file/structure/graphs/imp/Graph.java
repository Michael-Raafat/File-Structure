package file.structure.graphs.imp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import file.structure.graphs.IGraph;
import javafx.util.Pair;
/**
 * Graph implementation.
 * @author Michael.
 *
 */
public class Graph implements IGraph {
	/**
	 * The size of the graph.
	 */
	private List<Integer> vertices;
	/**
	 * Size of the edge line.
	 */
	private static final int EDGE_SIZE = 3; 
	/**
	 * edges list.
	 */
	private List<Integer[]>[] edges;
	/**
	 * process list for dijkstra process order.
	 */
	private List<Integer> processList;
	/**
	 * Constructor.
	 */
	public Graph() {
		vertices = new ArrayList<Integer>();
		processList = new ArrayList<Integer>();
	}
	@SuppressWarnings("unchecked")
	@Override
	public final void readGraph(final File file) {
		vertices.clear();
		try {
			Scanner scan = new Scanner(file);
			if (!scan.hasNextLine()) {
				scan.close();
				throw new RuntimeException("Not a valid graph file");
			}
			String[] line = scan.nextLine().split("\\s+");
			if (line.length != 2) {
				scan.close();
				throw new RuntimeException("Invalid first line!");
			}
			int vSize = Integer.parseInt(line[0]);
			int eSize = Integer.parseInt(line[1]);
			edges = (ArrayList<Integer[]>[]) new ArrayList[vSize];
			for (int i = 0; i < vSize; i++) {
				vertices.add(i);
				edges[i] = new ArrayList<Integer[]>();
			}
			for (int j = 0; j < eSize; j++) {
				line = scan.nextLine().split("\\s+");
				if (line.length != EDGE_SIZE) {
					scan.close();
					throw new RuntimeException("Invalid edge line!");
				}
				int src = Integer.parseInt(line[0]),
						dest = Integer.parseInt(line[1]),
						weight = Integer.parseInt(line[2]);
				if (src < 0 || src >= vSize || dest < 0 || dest >= vSize) {
					scan.close();
					throw new RuntimeException("Invalid vertic");
				}
				Integer[] temp = new Integer[2];
				temp[0] = dest;
				temp[1] = weight;
				edges[src].add(temp);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public final int size() {
		return vertices.size();
	}

	@Override
	public final ArrayList<Integer> getVertices() {
		return (ArrayList<Integer>) vertices;
	}

	@Override
	public final ArrayList<Integer> getNeighbors(final int v) {
		if (edges != null) {
			List<Integer> neighbors = new ArrayList<Integer>();
			List<Integer[]> vEdges = edges[v];
			for (int i = 0; i < vEdges.size(); i++) {
				if (!neighbors.contains(vEdges.get(i)[0])) {
					neighbors.add(vEdges.get(i)[0]);
				}
			}
			return (ArrayList<Integer>) neighbors;
		} else {
			return null;
		}
	}

	@Override
	public final void runDijkstra(final int src, final int[] distances) {
		processList.clear();
		PriorityQueue<Pair<Integer, Integer>> set
			= new PriorityQueue<Pair<Integer, Integer>>(
					new Comparator<Pair<Integer, Integer>>() {
						@Override
						public int compare(final Pair<Integer, Integer> o1,
								final Pair<Integer, Integer> o2) {
							return o1.getKey().compareTo(o2.getKey());
						}
			});
		Pair<Integer, Integer> pair;
		for (int i = 0; i < this.size(); i++) {
			if (i != src) {
				distances[i] = Integer.MAX_VALUE;
				pair = new Pair<Integer, Integer>(distances[i], i);
				set.add(pair);
			}
		}
		distances[src] = 0;
		set.add(new Pair<Integer, Integer>(distances[src], src));
		while (!set.isEmpty()) {
			int u = set.remove().getValue();
			processList.add(u);
			for (int i = 0; i < edges[u].size(); i++) {
				int v = edges[u].get(i)[0];
				int w = edges[u].get(i)[1];
				int alt = add(distances[u], w);
				if (alt < distances[v]) {
					pair = new Pair<Integer, Integer>(distances[v], v);
					distances[v] = alt;
					set.remove(pair);
					set.add(new Pair<Integer, Integer>(distances[v], v));
				}
			}
		}
	}

	@Override
	public final ArrayList<Integer> getDijkstraProcessedOrder() {
		return (ArrayList<Integer>) processList;
	}

	@Override
	public final boolean runBellmanFord(final int src, final int[] distances) {
		for (int i = 0; i < this.size(); i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[src] = 0;
		int v, w;
		for (int i = 0; i < this.size() - 1; i++) {
			for (int u = 0; u < edges.length; u++) {
				for (int k = 0; k < edges[u].size(); k++) {
					v = edges[u].get(k)[0];
					w = edges[u].get(k)[1];
					if (add(distances[u], w) < distances[v]) {
						distances[v] = distances[u] + w;
					}
				}
			}
		}
		for (int u = 0; u < edges.length; u++) {
			for (int k = 0; k < edges[u].size(); k++) {
				v = edges[u].get(k)[0];
				w = edges[u].get(k)[1];
				if (add(distances[u], w) < distances[v]) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Function to add numbers with respect to infinity.
	 * @param i
	 * First number.
	 * @param j
	 * Second number.
	 * @return
	 * The result of the addition.
	 */
	private int add(final int i, final int j) {
		if (i == Integer.MAX_VALUE || j == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else {
			return i + j;
		}
	}
}
