/**
 * 
 */
package util.sort.generic;

import java.util.Scanner;

import util.Util;

/**
 * Generic super class implementing generic Sortable interface and defining
 * method to provide UI for sorting along with an array to hold sorted elements.
 */
public abstract class Sorter implements Sortable {

	protected Integer[] sortedArray;
	protected String sortingOrder;

	/**
	 * Below method is NOT USED in this project
	 * Created for study of sorting algorithms
	 */
	public void provideUI() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("------------------- Sort ---------------------");
			Integer[] unsortedArray = Util.createArray(scanner);
			if (null != unsortedArray) {
				System.out.println("User porvided unsorted array:-");
				Util.displayItems(unsortedArray, 0);
				System.out.println();
				Integer[] sortedArray = sort(unsortedArray,ASCENDING);
				System.out.println("Sorted array obtained after sort:-");
				Util.displayItems(sortedArray, 0);
			} else {
				System.out.println("Invalid input entered, program terminating...");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (null != scanner) {
					scanner.close();
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * @return the sortedArray
	 */
	public Integer[] getSortedArray() {
		return sortedArray;
	}

	/**
	 * @param sortedArray the sortedArray to set
	 */
	public void setSortedArray(Integer[] sortedArray) {
		this.sortedArray = sortedArray;
	}

	/**
	 * @return the sortingOrder
	 */
	public String getSortingOrder() {
		return sortingOrder;
	}

	/**
	 * @param sortingOrder the sortingOrder to set
	 */
	public void setSortingOrder(String sortingOrder) {
		this.sortingOrder = sortingOrder;
	}

}
