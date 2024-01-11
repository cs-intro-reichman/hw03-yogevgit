/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter = 0;    // Monitors the efficiency of the calculation
	
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



		iterationCounter = 0; //reseting before going through the bisection

		




		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);


	}


	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) { 
    	
    	double increament =  0.001;
    	double allegedPeriodicalPayment = loan/n;
    	double endPayment = endBalance(loan,rate,n,allegedPeriodicalPayment);

    	while(  endPayment >= epsilon ){
    		allegedPeriodicalPayment += increament;
    		endPayment = endBalance(loan,rate,n,allegedPeriodicalPayment);

    		iterationCounter++;


    	}
    	return allegedPeriodicalPayment;
    	
   }
    
    
	 /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    		
    		double H = loan;
    		double L = loan/n;
    		double middle  = (H + L)/2;
    		double endBalancePayment = endBalance(loan, rate, n, middle);

    		while( H-L >= epsilon){    //Math.abs(endBalancePayment) >= epsilon

    				
    				iterationCounter++;
    				if (endBalancePayment > 0) {

    					L = middle;
    				}
    				else{

    					H = middle;
  	  				}
    				middle = (H+L)/2;
    				endBalancePayment = endBalance(loan, rate, n, middle);

    			}
    			return middle;
   			

    }


    	

    
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	

	private static double endBalance(double loan, double rate, int n, double payment) {
		
		double endResult = 0.0;
		double temp = 0.0;
		double currentCalc = 0.0;

		temp = (loan-payment) * (1+rate/100);

		for (int i = 1; i < n ; i++) {
			currentCalc = (temp-payment) *(1+rate/100);
			temp = currentCalc;

		}
		
		if (n ==1) {
			return temp;
			
		}
		else{
			return currentCalc;
		}

	}


}

//Done
