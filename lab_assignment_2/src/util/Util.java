/**
 * 
 */
package util;

import java.util.Scanner;

/**
 * 
 */
public class Util {

	public static final void displayItems(Integer[] arr, int iterationCount) {
		if (iterationCount > 0) {
			System.out.println("Iteration No." + iterationCount);
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static final Integer[] createArray(Scanner scanner) {
		try {
			System.out.print("Please enter length of an array:");
			int arrayLength = scanner.nextInt();
			Integer[] array = new Integer[arrayLength];
			for (int i = 0; i < arrayLength; i++) {
				System.out.print("Please enter [" + i + "] item of array between 1-99: ");
				int item = scanner.nextInt();
				if (item > 0 && item < 100) {
					array[i] = item;
				} else {
					throw new Exception("Invalid input entered, program terminating...");
				}
			}
			return array;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public static final int acceptingNumberBetween1And99(Scanner scanner) {
		try {
			System.out.print("Please enter a number to be searched between 1-99:");
			int item = scanner.nextInt();
			if (item > 0 && item < 100) {
				return item;
			} else {
				throw new Exception("Invalid input entered, program terminating...");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return -1;
		}
	}
}
