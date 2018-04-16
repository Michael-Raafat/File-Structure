package file.structure.graphs.imp;

import java.io.File;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import file.structure.graphs.IGraph;


/**
 * Graph test.
 * @author Amr
 *
 */
public class GraphTest {
	/**
	 * Graph to test.
	 */
	private IGraph graph;
	/**
	 * Set up function.
	 */
	@Before
	public final void setup() {
		graph = new Graph();
	}
	/**
	 * Test on the graph.
	 */
	@Test
	public final void test() {
		graph.readGraph(new File(".\\test.txt"));
		Assert.assertEquals(4, graph.size());
		Assert.assertEquals(2, graph.getNeighbors(0).size());
		Assert.assertEquals(1, graph.getNeighbors(1).size());
		int[] distances = new int[4];
		graph.runDijkstra(0, distances);
		for (int i = 0; i < distances.length; i++) {
			System.out.println(i + " distance : " + distances[i]);
		}
		System.out.println(graph.runBellmanFord(0, distances));
		for (int i = 0; i < distances.length; i++) {
			System.out.println(i + " distance : " + distances[i]);
		}
	}

}
