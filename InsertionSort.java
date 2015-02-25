package ADA.afterNO;
public class InsertionSort {
	
	static final int N = 5; //defining the soze of the array
	
	public static int A[] = new int[N]; //Array will have N elements, indexed from 0 to N-1
	static long lStartTime;
	static long lEndTime;
	static long executionTime;
	static long compareCount = 0;

	
	public static void main(String[] args) {

		System.out.println("Values before Sorting:");
		printArray(randomArray()); //Initialize the Array with some Random Values
									//and Print the Array

		//Sort the Array (Insertion sort)
		insertionSort(A,N);
		
		System.out.println("array after Sorting");
		printArray(A);
		System.out.println("Time of execution is : " + executionTime/1000 + " microsecs");
		System.out.println("Total comparisions made : " + compareCount);

	}
	
	//Begin insertion sort (Sorts in place)
	public static void insertionSort (int []A, int n){
			
		//i moves to the left, j moves to the right
		
				int key=0,i=0; //CLRS talks j=2 for the second element, which is A[1]
				//key is an extra space
				
				// BEGIN TIMER
				lStartTime = System.nanoTime();
				for (int j=1;j<n;j++){//Loop to Traverse the Array. Assumption 
										//is that the first element is sorted
					key = A[j];//First key is the second element of the array
					i=j-1; //The element before the key (First element for the
							//first iteration) i runs back to Zero, from j-1
					
					//Loop Back to the first element
					while ((i>-1) && (A[i]>key)){//we dont want to miss checking 
													//0th element
						A[i+1] = A[i];//Swapping until the KEY reaches at the right location
						i=i-1; //i runs back to Zero, from j-1
						compareCount++;//total swaps
				}//End While
					A[i+1]=key;
				
				}//End For	
				//END TIMER
				lEndTime = System.nanoTime();
				executionTime = lEndTime - lStartTime;
	}// END INSERTION SORT
	
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