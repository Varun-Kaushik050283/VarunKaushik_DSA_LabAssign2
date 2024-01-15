/**
 * 
 */
package q1.pay_money;

import java.util.Scanner;

/**
 * PayMoney. processes thousands of transactions daily amounting to crores of
 * Rupees. They also have a daily target that they must achieve. Given a list of
 * transactions done by PayMoney and a daily target, your task is to determine
 * at which transaction PayMoney achieves the same. If the target is not
 * achievable, then display the target is not achieved.
 *
 */
public final class PMTargetAchievedDeterminator {

	private Integer[] transactions;
	private int numberOfTransactions;
	private int totalNumberOfTimesDailyTargetsRequiredToBeAchieved;
	private int achievableTarget;
	private Scanner scanner;
	private int accumulativeCount;
	private int numberOfTimesDailyTargetHasBeenAcheived;

	public PMTargetAchievedDeterminator() {
		scanner = new Scanner(System.in);
	}

	public void initializeTargetAchievedDeterminatorAttributes() {
		setTransactions(new Integer[getNumberOfTransactions()]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PMTargetAchievedDeterminator payMoneyDeterminator = null;
		try {
			System.out.println("--------------------- Start -----------------");
			payMoneyDeterminator = new PMTargetAchievedDeterminator();
			payMoneyDeterminator.execute();
			System.out.println("--------------------- Stop -----------------");
		} catch (Exception ex) {
			System.out.println("Exception occurred on execution.");
			return;
		} finally {
			try {
				if (null != payMoneyDeterminator.getScanner()) {
					payMoneyDeterminator.getScanner().close();
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

	private void printOutput() throws Exception {
		if (getNumberOfTimesDailyTargetHasBeenAcheived() > 0) {
			System.out
					.println("Target achieved after " + getNumberOfTimesDailyTargetHasBeenAcheived() + " transactions");
		} else {
			System.out.println("Given target is not achieved");
		}
	}

	private void determine() throws Exception {
		for (int transactionCount = 0; transactionCount < this.getNumberOfTransactions(); transactionCount++) {
			this.setAccumulativeCount(this.getAccumulativeCount() + this.getTransactions()[transactionCount]);
			if (targetHasBeenAchieved()) {
				setNumberOfTimesDailyTargetHasBeenAcheived(getNumberOfTimesDailyTargetHasBeenAcheived() + (++transactionCount));
				break;
			}
		}
	}

	private boolean targetHasBeenAchieved() throws Exception {
		return this.getAccumulativeCount() >= this.getAchievableTarget();
	}

	private void execute() throws Exception {
		askUserForNumberOfTransactions();
		askUserForTransactions();
		askForTotalNumberOfRequiredAcheivableTargets();
		for (int numberOfTargetCount = 0; numberOfTargetCount < this.getTotalNumberOfTimesDailyTargetsRequiredToBeAchieved(); numberOfTargetCount++) {
			reset();
			askUserForAchievableTarget();
			determine();
			printOutput();
		}
	}
	
	private void reset() {
		this.setAccumulativeCount(0);
		this.setAchievableTarget(0);
		this.setNumberOfTimesDailyTargetHasBeenAcheived(0);
	}

	private void askUserForNumberOfTransactions() throws Exception {
		System.out.print("enter the size of transaction array ");
		int noOfTransactions = this.getScanner().nextInt();
		this.setNumberOfTransactions(noOfTransactions);
		this.getScanner().nextLine();
		this.initializeTargetAchievedDeterminatorAttributes();
	}

	private void askUserForTransactions() throws Exception {
		System.out.println("enter the values of array ");
		for (int transactionCount = 0; transactionCount < this.getNumberOfTransactions(); transactionCount++) {
			this.getTransactions()[transactionCount] = this.getScanner().nextInt();
		}
	}

	private void askForTotalNumberOfRequiredAcheivableTargets() throws Exception {
		System.out.print("enter the total no of targets that needs to be achieved ");
		int totalNoOfDailyTargetsNeededToBeAchieved = this.getScanner().nextInt();
		this.setTotalNumberOfTimesDailyTargetsRequiredToBeAchieved(totalNoOfDailyTargetsNeededToBeAchieved);
		this.getScanner().nextLine();
	}

	private void askUserForAchievableTarget() throws Exception {
		System.out.print("enter the value of target ");
		int dailyTarget = this.getScanner().nextInt();
		this.setAchievableTarget(dailyTarget);
		this.getScanner().nextLine();
	}

	/**
	 * @return the transactions
	 */
	public Integer[] getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(Integer[] transactions) {
		this.transactions = transactions;
	}

	/**
	 * @return the numberOfTransactions
	 */
	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}

	/**
	 * @param numberOfTransactions the numberOfTransactions to set
	 */
	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	/**
	 * @return the totalNumberOfTimesDailyTargetsRequiredToBeAchieved
	 */
	public int getTotalNumberOfTimesDailyTargetsRequiredToBeAchieved() {
		return totalNumberOfTimesDailyTargetsRequiredToBeAchieved;
	}

	/**
	 * @param totalNumberOfTimesDailyTargetsRequiredToBeAchieved the
	 *                                                           totalNumberOfTimesDailyTargetsRequiredToBeAchieved
	 *                                                           to set
	 */
	public void setTotalNumberOfTimesDailyTargetsRequiredToBeAchieved(
			int totalNumberOfTimesDailyTargetsRequiredToBeAchieved) {
		this.totalNumberOfTimesDailyTargetsRequiredToBeAchieved = totalNumberOfTimesDailyTargetsRequiredToBeAchieved;
	}

	/**
	 * @return the achievableTarget
	 */
	public int getAchievableTarget() {
		return achievableTarget;
	}

	/**
	 * @param achievableTarget the achievableTarget to set
	 */
	public void setAchievableTarget(int achievableTarget) {
		this.achievableTarget = achievableTarget;
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
	 * @return the accumulativeCount
	 */
	public int getAccumulativeCount() {
		return accumulativeCount;
	}

	/**
	 * @param accumulativeCount the accumulativeCount to set
	 */
	public void setAccumulativeCount(int accumulativeCount) {
		this.accumulativeCount = accumulativeCount;
	}

	/**
	 * @return the numberOfTimesDailyTargetHasBeenAcheived
	 */
	public int getNumberOfTimesDailyTargetHasBeenAcheived() {
		return numberOfTimesDailyTargetHasBeenAcheived;
	}

	/**
	 * @param numberOfTimesDailyTargetHasBeenAcheived the
	 *                                                numberOfTimesDailyTargetHasBeenAcheived
	 *                                                to set
	 */
	public void setNumberOfTimesDailyTargetHasBeenAcheived(int numberOfTimesDailyTargetHasBeenAcheived) {
		this.numberOfTimesDailyTargetHasBeenAcheived = numberOfTimesDailyTargetHasBeenAcheived;
	}

}
