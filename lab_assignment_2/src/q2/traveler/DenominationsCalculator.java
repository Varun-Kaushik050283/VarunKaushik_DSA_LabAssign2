/**
 * 
 */
package q2.traveler;

import java.util.ArrayList;
import java.util.List;

import util.sort.MergeSorter;
import util.sort.generic.Sortable;

public class DenominationsCalculator {

	private Integer[] denominations;
	private int paymentAmount;
	private List<String> denominationsCountBreakUps;

	// constructor for denominations list and payment amount
	public DenominationsCalculator(Integer[] denominations, int paymentAmount) {
		this.denominations = denominations;
		this.paymentAmount = paymentAmount;
	}

	// instance initializer
	{
		setDenominationsCountBreakUps(new ArrayList<>());
	}

	// mergeSort
	private void performSort() throws Exception {
		MergeSorter sorter = new MergeSorter();
		setDenominations(sorter.sort(getDenominations(), Sortable.DESCENDING));
	}

	// core method
	public void calculate() throws Exception {

		performSort();

		int denominationsIndex = 0;
		int workingPaymentAmount = getPaymentAmount();

		while (denominationsIndex < getDenominations().length) {
			int denomination = getDenominations()[denominationsIndex];
			int noOfDenominations = workingPaymentAmount / denomination;

			// balance amount
			int balanceAmount = workingPaymentAmount % denomination;

			// if denomination can be used or not
			if (noOfDenominations != 0) {

				// collect denomination value and its count in denominationsCountBreakUps
				getDenominationsCountBreakUps().add(denomination + ":" + noOfDenominations);

			}

			// set the remaining balance amount for next iteration
			workingPaymentAmount = balanceAmount;

			// when no more balance remaining, break from loop
			if (workingPaymentAmount == 0) {
				break;
			}

			denominationsIndex++;
		}

		if (!getDenominationsCountBreakUps().isEmpty()) {
			System.out.println("Your payment approach in order to give min no of notes will be");
			for (String denominationCountBreakUp : getDenominationsCountBreakUps()) {
				System.out.println(denominationCountBreakUp);
			}
		}

		// If still amount remaining
		if (workingPaymentAmount != 0) {
			System.out.println("Unable to provide exact denominations");
			System.out.println("Remaining amount : " + workingPaymentAmount);
		}
	}

	/**
	 * @return the denominations
	 */
	public Integer[] getDenominations() {
		return denominations;
	}

	/**
	 * @param denominations the denominations to set
	 */
	public void setDenominations(Integer[] denominations) {
		this.denominations = denominations;
	}

	/**
	 * @return the paymentAmount
	 */
	public int getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the denominationsCountBreakUps
	 */
	public List<String> getDenominationsCountBreakUps() {
		return denominationsCountBreakUps;
	}

	/**
	 * @param denominationsCountBreakUps the denominationsCountBreakUps to set
	 */
	public void setDenominationsCountBreakUps(List<String> denominationsCountBreakUps) {
		this.denominationsCountBreakUps = denominationsCountBreakUps;
	}

}
