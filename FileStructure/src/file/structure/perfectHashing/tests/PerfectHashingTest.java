package file.structure.perfectHashing.tests;

import java.io.File;
import java.util.List;

import file.structure.perfectHashing.IKeyReader;
import file.structure.perfectHashing.IPerfectHash;
import file.structure.perfectHashing.imp.KeyReader;
import file.structure.perfectHashing.imp.NHashing;
import file.structure.perfectHashing.imp.NSquareHashing;
/**
 * The class for testing.
 * @author Michael.
 *
 */
public final class PerfectHashingTest {
	/**
	 * Private constructor for utility class.
	 */
	private PerfectHashingTest() {
	}
	/**
	 * Main methods.
	 * @param args
	 * CMD arguments.
	 */
	public static void main(final String[] args) {
		IPerfectHash nSol = new NHashing();
		IPerfectHash nSquareSol = new NSquareHashing();
		File folder = new File(".//TestCases");
		File[] listOfFiles = folder.listFiles();
		IKeyReader reader = new KeyReader();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  List<Integer> temp
		    	  	= reader.readFile(listOfFiles[i]);
		    	  System.out.println("Size of elements : "
		    			  + temp.size());
		    	  System.out.println(
		    			  "N solution tries : "
		    			  + nSol.buildPerfectHashTable(
		    					  listOfFiles[i]));
		    	  System.out.println("N solution size : "
		    			  + nSol.size());
		    	  boolean flag = false;
		    	  for (int j = 0; j < 1000; j++) {
		    		  if (temp.contains(j) && !nSol.search(j)) {
		    			  flag = true;
		    		  } else if (!temp.contains(j) && nSol.search(j)) {
		    			  flag = true;
		    		  }
		    	  }
		    	  if (flag) {
		    		  System.out.println("Wrong search");
		    	  }
		    	  if (temp.size() < 1000000) {
			    	  System.out.println(
			    			  "N * N solution tries : "
			    			  + nSquareSol.buildPerfectHashTable(
			    					  listOfFiles[i]));
			    	  System.out.println("N * N solution size : "
			    			  + nSquareSol.size());
			    	  flag = false;
			    	  for (int j = 0; j < 1000; j++) {
			    		  if (temp.contains(j) && !nSquareSol.search(j)) {
			    			  flag = true;
			    		  } else if (!temp.contains(j)
			    				  && nSquareSol.search(j)) {
			    			  flag = true;
			    		  }
			    	  }
			    	  if (flag) {
			    		  System.out.println("WRONG SEARCH");
			    	  }
		    	  }
		      }
		    }

	}

}
