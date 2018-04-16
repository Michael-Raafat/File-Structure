package file.structure.perfectHashing.imp;

import java.util.Random;

import file.structure.perfectHashing.IUniversalHashing;

/**
 * 
 * @author Michael.
 *
 */
public class UniversalHashingImp implements IUniversalHashing {
	/**
	 * Random generator.
	 */
	private Random rand;
	/**
	 * b,a,p.
	 */
	private int a, b, p;
	/**
	 * number of keys.
	 */
	private int nums;
	/**
	 * Constructor.
	 */
	public UniversalHashingImp() {
		rand = new Random();
	}
	@Override
	public final void randomizeHashingFunction(final int m) {
		a = rand.nextInt(m);
		if (a == 0) {
			a = 1;
		}
		b = rand.nextInt(m);
		int temp = rand.nextInt(m) + m;
		while (!isPrime(temp)) {
			temp++;
		}
		p = temp;
		nums = m;
	}
	/**
	 * Checks if a number is prime.
	 * @param n
	 * The number to check.
	 * @return
	 * True if it is prime.
	 */
	private boolean isPrime(int n) {
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i+= 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	@Override
	public final int hash(final int value) {
		return Math.floorMod(Math.floorMod(a * value + b, p), nums);
	}

}
//package file.structure.perfectHashing.imp;
//
//import java.util.Random;
//
//import file.structure.perfectHashing.IUniversalHashing;
///**
// * 
// * @author Michael.
// *
// */
//public class UniversalHashingImp implements IUniversalHashing {
//	/**
//	 * Random generator.
//	 */
//	private Random rand;
//	/**
//	 * b,a,p.
//	 */
//
//	private int m, n;
//	/**
//	 * Hash function matrix.
//	 */
//	private int[][] hashFunction;
//	/**
//	 * Constructor.
//	 */
//	public UniversalHashingImp() {
//		rand = new Random();
//	}
//	@Override
//	public final void randomizeHashingFunction(final int m) {
//		this.n = m;
//		this.m = (int) (Math.log(m)/Math.log(2));		
//		hashFunction = new int[this.m][32];
//		for (int i = 0; i < this.m; i++) {
//			for (int j = 0; j < 32; j++) {
//				hashFunction[i][j] = rand.nextInt(2);
//			}
//		}
//	}
//	@Override
//	public final int hash(final int value) {
//		StringBuilder build = new StringBuilder();
//		char[] repres = Integer.toString(value, 2).toCharArray();
//		for (int i = repres.length - 1; i >= 0; i--) {
//			build.append(repres[i]);
//		}
//		while (build.length() < 32) {
//			build.append('0');
//		}
//		repres = build.toString().toCharArray();
//		int[] hx = new int[m];
//		for (int j = 0; j < m; j++) {
//			int count = 0;
//			for (int k = 0; k < repres.length; k++) {
//				count += Integer.valueOf(repres[k]) * hashFunction[j][k];  
//			}
//			count = Math.floorMod(count, 2);
//			hx[j] = count;
//		}
//		int sum  = 0;
//		for (int z = hx.length - 1; z >=  0; z--) {
//			sum += Math.pow(2, z) * hx[z];
//		}
//		int s = Math.floorMod(sum, n);
//		return s;
//	}
//
//}