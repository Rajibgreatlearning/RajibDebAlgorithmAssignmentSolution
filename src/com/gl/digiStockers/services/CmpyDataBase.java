package com.gl.digiStockers.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gl.digiStockers.beans.Base;

public class CmpyDataBase extends Base {
	public static double price;
	public static String stockePrice, reply;
	public static boolean replyB;

	public String[][] stockData(int size) { // Inserting the stock price and the compare value in 2D array
		
			String[][] cmpyArr = new String[2][size];
			for (j = 0; j < size; j++) {
				for (i = 0; i < 2; i++) {
					if (i == 0) {
						int num = j + 1;
						stockePrice = null;
						System.out.println("Enter current stock price of the company " + num);
						/*
						 * price = sc.nextDouble(); stockePrice = String.valueOf(price);
						 */
						try {
							stockePrice = br.readLine();
							// price=Double.parseDouble(stockePrice);

						} catch (Exception e) {

							System.out.println("Format is not correct" + e.toString());
						}
						cmpyArr[0][j] = stockePrice; // insert in row 0
					} else {
						int num = j + 1;
						reply = null;
						System.out.println(
								"Whether company's stock price rose today compare to yesterday? true/false only" + num);

						try {
							reply = br.readLine();
						} catch (Exception e) {

							System.out.println("Format is not correct" + e.toString());
						}
						/*
						 * replyB=sc.hasNextBoolean(); reply=String.valueOf(replyB);
						 */
						cmpyArr[1][j] = reply; // insert in row 1
					}
				}
			}
			
		
		return cmpyArr;
		
		

	}// stockData

	public int totalTrue(String[][] array, int size) { // Calculate total number of true
		int totalTrue = 0;
		for (j = 0; j < size; j++) {
			if (array[1][j].equalsIgnoreCase("true")) {
				totalTrue = totalTrue + 1;
			}
		}

		return totalTrue;

	}// totalTrue

	public int totalFalse(String[][] array, int size) { // Calculate total number of false
		int totalFalse = 0;
		for (j = 0; j < size; j++) {
			if (array[1][j].equalsIgnoreCase("false")) {
				totalFalse = totalFalse + 1;
			}
		}
		return totalFalse;

	}// totalFalse

	public void searchKeyValue(String[][] array, String key, int size) { // Search function (Linear search)
		int flag = 0;
		// String strKey = String.valueOf(key);
		for (j = 0; j < size; j++) {
			if (array[0][j].equalsIgnoreCase(key)) {
				System.out.println("Stock of value " + key + " is present");
				flag = 1;
			} // if

		} // for
		if (flag == 0) {
			System.out.println("The value is not present");
		}

	}// searchKeyValue

	public void mergeSort_Dece(String[][] arr, int lb, int ub) { // Just reversing the mergeSort_Acen for decending
																	// order merge sort
		int size = ub + 1;
		double[] arrSort = new double[size]; // new array for sorting
		for (i = 0; i < size; i++) {
			arrSort[i] = Double.parseDouble(arr[0][i]);
		}
		mergeSort(arrSort, lb, ub);
		traverseRev1DArray(arrSort);
	}// mergeSort_Dece

	public void mergeSort_Acen(String[][] arr, int lb, int ub) { // Ascending order merge sort calling, here from 2D
																	// array taking the one layer value in a new array
																	// and apply mergeSort methodology on that array
		int size = ub + 1;
		// int[] arrSort = new int[size]; // new array for sorting
		double[] arrSort = new double[size];
		for (i = 0; i < size; i++) {
			// arrSort[i] = Integer.parseInt(arr[0][i]);
			arrSort[i] = Double.parseDouble(arr[0][i]); // Convert the string to double
		}
		mergeSort(arrSort, lb, ub);
		traverse1DArray(arrSort);

	}// mergeSort_Acen

}
