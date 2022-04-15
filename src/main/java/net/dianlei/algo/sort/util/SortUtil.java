package net.dianlei.algo.sort.util;

import net.dianlei.algo.tree.Node;

import java.util.Arrays;


public class SortUtil {
	public boolean validate(int[] a) {
		return a != null && a.length > 0;
	}
	
	
	public static void printArray(int a[], String comments) {
		System.out.println("==============" + comments + "============");
		for(int i=0; i< a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
		System.out.println("||||||||||||||||||||||||||||||||||||||||||");
	}
	
	public static int[] createRandomArray(int length, int range) {
		int arrayLength = (int) (length * Math.random());
		int a[] = new int[arrayLength];
		for (int j = 0; j < arrayLength; j++) {
			a[j]= (int) (range * Math.random());
		}
		return a;
	}
	
	public static int[] copyArray(int[] a) {
		int b[] = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		return b;
	}
	
	public static boolean isEqual(int[] a, int[] b) {
		return Arrays.equals(a, b);
	}
}