public class tester1 {

    static double epsilon = 0.001; // The computation tolerance (estimation error)
    static int iterationCounter = 0; // Monitors the efficiency of the calculation

    public static double endBalance(double loan, double rate, int n, double payment) {
        double loan1 = loan;
        double rate1 = (1 + rate / 100);
        for (int i = 0; i < n; i++) {
            loan1 = rate1 * (loan1 - payment);
        }
        return loan1;
    }

    public static void main(String args[]) {

        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        double payment = Double.parseDouble(args[3]);
        double result = bruteForceSolver(loan, rate, n, epsilon);

        System.out.println(result);
        System.out.println(loan);
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double loann = loan / n;
        if (endBalance(loan, rate, n, loann) <= 0)
            return iterationCounter;
        while (endBalance(loan, rate, n, loann) > n) {
            loann = loann + epsilon;
            iterationCounter++;
            endBalance(loan, rate, n, loann);

        }
        return loann;

    }
}