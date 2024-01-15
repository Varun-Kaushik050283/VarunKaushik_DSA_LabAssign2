/**
 * 
 */
package q2.traveler;

import java.util.Scanner;

/**
 * You are a traveler and traveling to a country where the currency
 * denominations are unknown and as you travel you get to know about the
 * denomination in random order. You want to make a payment of amount x, in such
 * a way that the higher denomination is used to make exact payment.
 * 
 */
public class DenominationsCalculatorUser {

	private Scanner scanner;
	private Integer[] denominations;
	private int paymentAmount;
	private int sizeOfCurrencyDenominations;

	public DenominationsCalculatorUser() {
		scanner = new Scanner(System.in);
	}

	public void initializeDenominationsCalculatorAttributes() {
		setDenominations(new Integer[getSizeOfCurrencyDenominations()]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DenominationsCalculatorUser denominationsCalculatorUser = null;
		try {
			System.out.println("--------------------- Start -----------------");
			denominationsCalculatorUser = new DenominationsCalculatorUser();
			denominationsCalculatorUser.execute();
			System.out.println("--------------------- Stop -----------------");
		} catch (Exception ex) {
			System.out.println("Exception occurred on execution.");
			ex.printStackTrace();
			return;
		} finally {
			try {
				if (null != denominationsCalculatorUser.getScanner()) {
					denominationsCalculatorUser.getScanner().close();
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	void execute() throws Exception {
		askUserForSizeOfCurrencyDenominations();
		askUserForDenominations();
		askUserForPaymentAmount();
		determine();
	}

	private void askUserForSizeOfCurrencyDenominations() throws Exception {
		System.out.println("enter the size of currency denominations ");
		int sizeOfCurrencyDenominations = this.getScanner().nextInt();
		this.setSizeOfCurrencyDenominations(sizeOfCurrencyDenominations);
		this.getScanner().nextLine();
		this.initializeDenominationsCalculatorAttributes();
	}

	private void askUserForDenominations() throws Exception {
		System.out.println("enter the currency denominations value ");
		for (int denominationCount = 0; denominationCount < this
				.getSizeOfCurrencyDenominations(); denominationCount++) {
			this.getDenominations()[denominationCount] = this.getScanner().nextInt();
		}
	}

	private void askUserForPaymentAmount() throws Exception {
		System.out.println("enter the amount you want to pay ");
		int paymentAmount = this.getScanner().nextInt();
		this.setPaymentAmount(paymentAmount);
		this.getScanner().nextLine();
	}

	private void determine() throws Exception {
		DenominationsCalculator denominationsCalculator = new DenominationsCalculator(getDenominations(),
				getPaymentAmount());
		denominationsCalculator.calculate();
	}

	/**
	 * @return the scanner
	 */
	public Scanner getScanner() {
		return scanner;
	}

	/**
	 * @param scanner the scanner to set
	 */
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
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
	 * @return the sizeOfCurrencyDenominations
	 */
	public int getSizeOfCurrencyDenominations() {
		return sizeOfCurrencyDenominations;
	}

	/**
	 * @param sizeOfCurrencyDenominations the sizeOfCurrencyDenominations to set
	 */
	public void setSizeOfCurrencyDenominations(int sizeOfCurrencyDenominations) {
		this.sizeOfCurrencyDenominations = sizeOfCurrencyDenominations;
	}

}
