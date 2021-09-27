package com.gl.digiStockers.main;

import java.util.Scanner;

import com.gl.digiStockers.services.CmpyDataBase;

public class Driver {

	public static Scanner sc = new Scanner(System.in);
	public static CmpyDataBase cd = new CmpyDataBase();

	public static void main(String[] args) {
		try {
		System.out.println("Enter the no of companies:");

		int cmpyNo = sc.nextInt();

		String[][] cmpyArr = new String[2][cmpyNo];
		cmpyArr = cd.stockData(cmpyNo);

		int flag = 0;
		// cd.traverse2DArray(cmpyArr,cmpyNo ); //Display the 2D table
		do {
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			int operationNo = sc.nextInt();
			switch (operationNo) {
			case 1:
				cd.mergeSort_Acen(cmpyArr, 0, cmpyArr[0].length - 1);
				break;
			case 2:
				cd.mergeSort_Dece(cmpyArr, 0, cmpyArr[0].length - 1);
				break;
			case 3:
				int totalTrue = cd.totalTrue(cmpyArr, cmpyNo);
				System.out.println("Total no of companies whose stock price rose today : " + totalTrue);
				break;
			case 4:
				int totalFalse = cd.totalFalse(cmpyArr, cmpyNo);
				System.out.println("Total no of companies whose stock price declined today : " + totalFalse);
				break;
			case 5:
				System.out.println("Enter the key value");
				String keyValue = sc.next();
				cd.searchKeyValue(cmpyArr, keyValue, cmpyNo);
				break;
			default:
				flag = 1;
				System.out.println("Exited successfull");
				break;
			}
		} while (flag == 0);
		}catch(Exception e) {
			System.out.println("Please check your inputs, as our system throwing some error->"+e.toString());
		}
	}

}
