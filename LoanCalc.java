
/**
 * Computes the periodical payment necessary to re-pay a given loan.
 */
public class LoanCalc {

	static double epsilon = 0.001; // The computation tolerance (estimation error)
	static int iterationCounter = 0; // Monitors the efficiency of the calculation

	/*
	 * Gets the loan data and computes the periodical payment.
	 * Expects to get three command-line arguments: sum of the loan (double),
	 * interest rate (double, as a percentage), and number of payments (int).
	 */
	public static void main(String[] args) {
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		iterationCounter = 0; // reseting before going through the bisection

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

	}

	/**
	 * Uses a sequential search method ("brute force") to compute an approximation
	 * of the periodical payment that will bring the ending balance of a loan close
	 * to 0.
	 * Given: the sum of the loan, the periodical interest rate (as a percentage),
	 * the number of periods (n), and epsilon, a tolerance level.
	 */
	// Side effect: modifies the class variable iterationCounter.

	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double loann = loan / n;
		if (endBalance(loan, rate, n, loann) <= 0)
			return iterationCounter;
		while (endBalance(loan, rate, n, loann) > 0) {
			loann = loann + epsilon;
			iterationCounter++;

		}
		return loann;
	}

	/**
	 * Uses bisection search to compute an approximation of the periodical payment
	 * that will bring the ending balance of a loan close to 0.
	 * Given: the sum of theloan, the periodical interest rate (as a percentage),
	 * the number of periods (n), and epsilon, a tolerance level.
	 */
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double L = loan / n;
		double H = loan;
		double g = (L + H) / 2;
		while ((H - L) > epsilon) {
			iterationCounter++;
			if (endBalance(loan, rate, n, g) * endBalance(loan, rate, n, L) > 0) {
				L = g;
			} else {
				H = g;
			}
			g = (L + H) / 2;
		}
		return g;
	}

	/**
	 * Computes the ending balance of a loan, given the sum of the loan, the
	 * periodical
	 * interest rate (as a percentage), the number of periods (n), and the
	 * periodical payment.
	 */

	public static double endBalance(double loan, double rate, int n, double payment) {
		double loan1 = loan;
		double rate1 = (1 + rate / 100);
		for (int i = 0; i < n; i++) {
			loan1 = rate1 * (loan1 - payment);
		}
		return loan1;
	}

}

// Done
