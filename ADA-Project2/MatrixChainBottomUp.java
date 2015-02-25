/**
 * Nitin Kumar Chaurasia
 * Project 2
 * 2.2 Implements the Bottom Up (Dynamic) version of the Optimal matrix chain
 * multiplication  numbers.
 * Takes command line arguments as: 
 * args[0] = n, number of p0 to pn values
 * args[1], args[2],....,args[n] are p0, p1 ... pn-1 
 */

public class MatrixChainBottomUp {

	static int[][] m;
	static int[][] s;

	public static void main(String[] args) {
		long lStartTime, lEndTime, executionTime;//Timer Variables

		//Checking of correct arguments are passed
		if (args.length == 0 ) {
			System.err.println("Paramater format : n 1 2 ... n");
			System.exit(-1);
		}
		int n = Integer.parseInt(args[0]);

		//Checking of correct number of arguments are passed
		if (args.length != n+1){
			System.err.println("Pass correct number Parameters");
			System.exit(-1);
		}

		int[] p = new int[n];
		for(int i = 0; i < p.length; i++){
			p[i] =  Integer.parseInt(args[i+1]);
		}
		System.out.println("****** Matrix Chain Multiplication (Bottom up) Dynamic ******");
		//Call the method. Considering the range would fit in Long.
		lStartTime = System.nanoTime();
		matrixChainOrder(p);
		lEndTime = System.nanoTime();
		executionTime = lEndTime - lStartTime;
		System.out.println(m[1][n-1]);
		printOptimalParens(s,1,n-1);//Values lie between 0 and n
		System.out.println();
		System.out.println(executionTime/1000 + " micro secs");
		
		/* Methods for Validation Purposes*/
		//printOptimalParens(s,1,n-1);//Values lie between 0 and n
		//printMatrices(n-1);

	}

	/* Standard Algorithm implementation given in the book*/
	public static void matrixChainOrder(int[] p){
		int n = p.length - 1;
		//let m[1..n,1..n] according to corman, index ZERO is not used, 
		//thus one extra space is created and index 0 is never used
		m = new int[n+1][n+1];
		s = new int[n+1][n+1];
		int i,j,k,l,q;
		for(int temp = 1; temp < n; temp++) m[temp][temp] = 0;

		for (l = 2; l <= n; l++){
			for (i = 1; i <= n -l + 1; i++){
				j = i + l -1;
				m[i][j] = Integer.MAX_VALUE;
				for(k = i; k <= j-1; k++){
					q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]; 
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}

			}//end for i
		}//end for l
	}//End void matrix method

	/* Method implementation for Validation Purposes*/
	public static void printOptimalParens(int[][] s,int i,int j){
		if (i == j) System.out.print("A"+i);
		
		else{
			System.out.print("(");
			printOptimalParens(s, i, s[i][j]);
			printOptimalParens(s, s[i][j]+1, j);
			System.out.print(")");
		}
		
	}//END printOptimalParens
	
	/* Method implementation for Validation Purposes*/
	public static void printMatrices(int n){
		
		System.out.println("The m Matrix");
		for(int i = 0; i < n+1; i++){
			for (int j = 0; j < n + 1; j++ ){
				System.out.print(m[i][j] + " ");
				//System.out.print("m["+i+"][" + j +"] = "+ m[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("The s Matrix");
		for(int i = 0; i < n+1; i++){
			for (int j = 0; j < n + 1; j++ ){
				System.out.print(s[i][j] + " ");
				//System.out.print("s["+i+"][" + j +"] = "+ s[i][j] + " ");
				
			}
			System.out.println();
		}
	}// END PrintMatrices
}