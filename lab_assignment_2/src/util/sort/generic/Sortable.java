/**
 * 
 */
package util.sort.generic;

/**
 * Generic interface declaring method sort which has to be implemented by other
 * specialized sub classes for different sorting algorithm
 * 
 * @Author Varun Kaushik
 */
public interface Sortable {

	public  String ASCENDING   = "LESS_TO_MORE";
	public  String DESCENDING  = "MORE_TO_LESS";
	
	public Integer[] sort(Integer[] unsortedArray, String sortingOrder);
}
