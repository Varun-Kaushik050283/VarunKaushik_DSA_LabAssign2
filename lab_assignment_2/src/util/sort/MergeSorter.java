/**
 * 
 */
package util.sort;

import util.sort.generic.Sorter;

/**
 * STABLE Algorithm 
 * Merge Sorting algorithm Time complexity : 
 *     Best case : O(nlogn) 
 *     Average case : O(nlogn) 
 *     Worst case : O(nlogn) 
 * Space complexity : O(n)
 * 
 * For implementing MergeSort algorithm 
 * by overriding sort method of Sortable interface.  
 * 
 * The sort method will be called from DenominationsCalculator Class.
 * 
 * Improvement
 * (We should be using QuickSort since we are using arrays instead of linked-list)
 * 
 * @Author Varun Kaushik
 */
public class MergeSorter extends Sorter {

	private void merge(Integer[] unsortedArray, int lowIndex,int midValue,int highIndex) {
		
		//Determine the length of LSA and RSA
		int lengthLSA = midValue - lowIndex + 1;
		int lengthRSA = highIndex - midValue;
		
		// Construct LSA and RSA
		int[] LSA = new int[lengthLSA];
		int[] RSA = new int[lengthRSA];
		
		// Fill LSA
		for(int i = 0; i < lengthLSA; i++) {
			LSA[i] = unsortedArray[lowIndex + i];
		}
		// Fill RSA
		for(int j = 0; j < lengthRSA; j++) {
			RSA[j] = unsortedArray[ ( midValue + 1 ) + j ];
		}
		
		// initialize pointers of LSA and RSA and sortedArray pointer 
		int pointerLSA = 0;
		int pointerRSA = 0;
		int pointerSortedArray = lowIndex;
		
		setSortedArray(unsortedArray);
		
		//compare LSA and RSA elements at their respected pointers 
		//and copy the smaller element in sorted array at respected pointer 
		while(pointerLSA < lengthLSA && pointerRSA < lengthRSA) {
			
			
			switch(getSortingOrder()) {
			
					case ASCENDING :
						if(LSA[pointerLSA] <= RSA[pointerRSA]) {
							getSortedArray()[pointerSortedArray] = LSA[pointerLSA];
							pointerLSA++;
						}else {  // RSA[pointerRSA] <= LSA[pointerLSA]
							getSortedArray()[pointerSortedArray] = RSA[pointerRSA];
							pointerRSA++;
						}
						break;
					
					case DESCENDING:
						if(LSA[pointerLSA] >= RSA[pointerRSA]) {
							getSortedArray()[pointerSortedArray] = LSA[pointerLSA];
							pointerLSA++;
						}else {  // RSA[pointerRSA] >= LSA[pointerLSA]
							getSortedArray()[pointerSortedArray] = RSA[pointerRSA];
							pointerRSA++;
						}
						break;
			}
			pointerSortedArray++;
		}
		
		// if LSA still has remaining elements then copy to sorted array
		while(pointerLSA < lengthLSA) {
			getSortedArray()[pointerSortedArray] = LSA[pointerLSA];
			pointerLSA++;
			pointerSortedArray++;
		}
		
		// if RSA still has remaining elements then copy to sorted array
		while(pointerRSA < lengthRSA) {
		   getSortedArray()[pointerSortedArray] = RSA[pointerRSA];
		   pointerRSA++;
		   pointerSortedArray++;
		}
		
	}
	
	private void mergeSort(Integer[] unsortedArray, int lowIndex, int highIndex) {
		
		if(lowIndex < highIndex) {
			int midValue = (highIndex + lowIndex)/2;
			mergeSort(unsortedArray, lowIndex, midValue);
			mergeSort(unsortedArray, midValue+1, highIndex);
		    merge(unsortedArray, lowIndex, midValue, highIndex);
		}
	} 
	
	@Override
	public Integer[] sort(Integer[] array, String sortingOrder) {
		int lowIndex = 0;
		int highIndex = array.length-1; /// n-1
		setSortingOrder(sortingOrder);
		mergeSort(array, lowIndex,highIndex);	
		return getSortedArray();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sorter sorter = new MergeSorter();
		sorter.provideUI();
	}

}
