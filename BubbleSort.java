import java.text.Format;

/**
 * @author nitin
 *
 */
public class BubbleSort {

static final int N = 5; //defining the soze of the array
static final int MAX = 100;//Random numbers less than MAX
	
	public static int A[] = new int[N]; //Array will have N elements, indexed from 0 to N-1

	public static void main(String[] args) {

		System.out.println("Values before Sorting:");
		printArray(randomArray()); //Initialize the Array with some Random Values
									//and Print the Array

		//Sort the Array (Insertion sort)
		bubbleSort(A,N);
		
		System.out.println("array after Sorting");
		printArray(A);
	}
	
	//Begin insertion sort (Sorts in place)
	public static void bubbleSort (int []A, int n){
		
		for(int i=0;i<A.length;i++){
			for(int j=0;j<i;j++){
				if(A[j]<=A[i]){
				swap();
				}
			}
		}
		
	
		
	}// END BUBBLE SORT
	
	//Print the Array.
	public static void printArray(int B[]){
		for (int i=0;i<B.length;i++)//for each loop
			System.out.print(B[i] + ", ");//off by one bug (Extra Comma)
		System.out.println();
	}
	 
	//Generate Array
	public static int[] randomArray(){
		for (int i=0;i<A.length;i++){
			A[i] = (int)(Math.random()*MAX);//Random numbers below 100
			//Math.random() returns number between 0 and 1
		}
		return A;
	}
}
