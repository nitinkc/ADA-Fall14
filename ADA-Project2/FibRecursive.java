/**
 * Nitin Kumar Chaurasia
 * Project 2
 * 1.1 Implements the Recursive version of the Fibonacci numbers.
 * Takes command line arguments as: 
 * args[0] = n, Number of times the method is called
 * args[1], args[2],....,args[n] are the integer numbers for which  
 */

public class FibRecursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long lStartTime, lEndTime, executionTime;//Timer Variables

		//Checking of correct arguments are passed
		if (args.length == 0 || args.length > 1) {
			System.err.println("Please Pass one Parameter");
			System.exit(-1);
		}

		System.out.println("****** Recursive version of Fibonacci terms ******");
		//Call the method. Considering the range would fit in Long.
		int n = Integer.parseInt(args[0]);

		//Checking for values in the range 1 and 100. Bigger value 
		//would be very long run times
		if (n < 0 && n  > 100) {
			System.err.println("Accepted values are between 0 and 100");
			System.exit(-1);
		}

		lStartTime = System.nanoTime();
		long val = fib(n);
		lEndTime = System.nanoTime();
		executionTime = lEndTime - lStartTime;

		System.out.println("fib(" + n +")" + "= " + val+ "\t");
		System.out.println(executionTime/1000 + " micro secs");
	}

	public static long fib(int n){
		if (n == 0 || n == 1){ 
			return n;
		}
		long next = fib(n-1) + fib(n-2);
		return next;
	}

}
