/**
 * 
 */

/**
 * @author nitin
 *
 */
public class QuickSortDriver {
	
	/* Global Variables*/
	static int A[] = new int[5]; //Array will have N elements, indexed from 0 to N-1
	static String fileName;//holds the name of the file
	final static String RESULTS = "Results.log";
	static int n;//Size of the array
	static long compareCount = 0;//To count the number of comparisons
	static long lStartTime, lEndTime, executionTime;//Timer Variables

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Values before Sorting:");
		printArray(randomArray()); //Initialize the Array with some Random Values
									//and Print the Array
		//Sort the Array (Quick sort)
		quickSort(A,0,A.length-1);
		
		System.out.println("array after Sorting");
		printArray(A);
		System.out.println("Time of execution is : " + executionTime/1000 + " microsecs");
		System.out.println("Total comparisions made : " + compareCount);
	}
	
	public static void quickSort(int A[],int p,int r){
		int q;
		if (p<r){
			q = partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);	
		}
	}
	
	public static int partition(int A[],int p,int r){
		int x = A[r];//The last element becomes the pivot
		int i = p-1;//iterate through the first
		int exchange;
		for(int j=p; j <= r-1; j++){
			if (A[j] <= x){
				i = i+1;
				exchange = A[i];
                A[i] = A[j];
                A[j] = exchange;			}
		}
		exchange = A[i+1];
        A[i+1] = A[r];
        A[r] = exchange;
        
        return i+1;
	}
	//Print the Array.
	public static void printArray(int B[]){
		for (int i=0;i<B.length;i++)//for each loop
			System.out.print(B[i] + ", ");//off by one bug (Extra Comma)
		System.out.println();
	}
		 
	//Generate Array
	public static int[] randomArray(){
		for (int i=0;i<A.length;i++){
			A[i] = (int)(Math.random()*100);//Random numbers below 100
			//Math.random() returns number between 0 and 1
		}
		return A;
	}
}