/**
 * 
 */

/**
 * @author nitin
 *
 */
public class Sort {
	long compareCount = 0;
	long lStartTime, lEndTime, executionTime;

	//Begin insertion sort (Sorts in place)
	public void insertionSort (int []A, int n){
	
		//i moves to the left, j moves to the right
		int key=0,i=0; //CLRS talks j=2 for the second element, which is A[1]
		//key is an extra space
		compareCount = 0;
		// BEGIN TIMER
		lStartTime = System.nanoTime();
		for (int j=1;j<n;j++){//Loop to Traverse the Array. Assumption 
								//is that the first element is sorted
			key = A[j];//First key is the second element of the array
			i=j-1; //The element before the key (First element for the
					//first iteration) i runs back to Zero, from j-1
			
			//Loop Back to the first element
			while ((i>-1) && compare(A[i],key)){//we don't want to miss checking 
											//0th element
				A[i+1] = A[i];//Swapping until the KEY reaches at the right location
				i=i-1; //i runs back to Zero, from j-1
			}//End While
		A[i+1]=key;
		}//End For	
		//END TIMER
		lEndTime = System.nanoTime();
		executionTime = lEndTime - lStartTime;
	}// END INSERTION SORT
	
	public boolean compare(int a, int b){
		compareCount++;
		if (a > b)
			return true;
		else 
			return false;
	}
}
