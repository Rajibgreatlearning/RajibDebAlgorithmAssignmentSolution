package com.gl.digiStockers.beans;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Base {
	public static Scanner sc = new Scanner(System.in);
	// public static Console console=System.console();
	public static int i, j, k;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Base() {

	}

	public static void traverse2DArray(String[][] array, int size) { // Just for testing purpose

		for (j = 0; j < size; j++) {

			System.out.println("The stock value & this year price compare to prev year is true/false " + array[0][j]
					+ " " + array[1][j]);

		}

	} // traverse2DArray

	public static void traverse1DArray(double[] arr) { // Traverse
		for (i = 0; i < arr.length; i++) {
			System.out.print("  " + arr[i]);
		}
		System.out.println();
	}// traverse1DArray

	public static void traverseRev1DArray(double[] arr) { // Reverse Traverse
		for (i = arr.length - 1; i >= 0; i--) {
			System.out.print("  " + arr[i]);
		}
		System.out.println();
	}// traverseRev1DArray

	public void mergeSort(double[] arrSort, int lb, int ub) { // MergeSort (Recursion)

		int mid;
		if (lb < ub) {
			mid = (lb + ub) / 2;
			mergeSort(arrSort, lb, mid);
			mergeSort(arrSort, mid + 1, ub);
			merger(arrSort, lb, mid, ub);
		}

	}// mergeSort

	public void merger(double[] array, int lb, int mid, int ub) { // merger
		double[] sortedArray = new double[ub + 1];
		i = lb;
		j = mid + 1;
		k = lb;

		while (i <= mid && j <= ub) {
			if (array[i] <= array[j]) {
				sortedArray[k] = array[i];
				i++;
			} // if
			else {
				sortedArray[k] = array[j];
				j++;
			} // else
			k++;
		} // while

		if (i > mid) {
			while (j <= ub) {
				sortedArray[k] = array[j];
				j++;
				k++;
			} // while
		} // if
		else {
			while (i <= mid) {
				sortedArray[k] = array[i];
				i++;
				k++;
			}
		} // else

		for (i = lb; i <= ub; i++) {
			array[i] = sortedArray[i];
		}

	}// merger
}
