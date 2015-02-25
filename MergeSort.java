/**
 * MergerSort(A,p,r)
 * 	if(p<r)
 * 		q=Floor(p+r)/2
 * MergeSort(A,p,q)
 * MergeSort(A,q+1,r)
 * Merge(A,p,q,r)
 */
		

package aDA.AfterNO.WillPower;

public class MergeSort {

	static final int N = 5; //defining the soze of the array
	static final int MAX = 100;
	
	public static int A[] = new int[N]; //Array will have N elements, indexed from 0 to N-1
	
	
	public static void main(String[] args) {

		System.out.println("Values before Sorting:");
		printArray(randomArray()); //Initialize the Array with some Random Values
									//and Print the Array

		//Sort the Array (Using Divide and Conquer Merge sort (Recusrion))
		long lStartTime = System.nanoTime();
		mergeSort(A,0,A.length-1);//two indices to keep track of array size
		long lEndTime = System.nanoTime();

		long difference = lEndTime - lStartTime;
			 
		System.out.println("Elapsed milliseconds: " + difference/1000000);

		System.out.println("array after Sorting");
		printArray(A);
	}
	
	//Begin Merge Sort (Sorts in place)
	public static void mergeSort(int []A,int low,int high){//low and high are the 
								//start and ending of the array
		
		if(low<high){//further subdivide the problem
			int mid = (low+high)/2;
			mergeSort(A,low,mid);//Divide the first half
			mergeSort(A,mid+1,high);//Divide the second half
			merge(A,low,mid,high);
		}
		
		}// END MERGE SORT
	
	//Merge the arrays (most crucial part)
	
	static void merge(int []array,int low,int mid,int high){
		int temp[] = new int[high-low+1];//temporary array to hold the sorted values
		int left = low;
		int right = mid+1;
		int k = 0; //The index of temp
		
		while(left<=mid && right<=high){
			if(array[left]<array[right]){
				temp[k] = array[left];
				left = left + 1;
				k = k+1;
			}else{
				temp[k]=array[right];
				right = right + 1;
				k = k+1;
			}//end if
		}//End While
		
		if(left <=mid){
			while(left<=mid){
				temp[k] = array[left];
				left = left+1;
				k=k+1;
			}
		}else if(right <= high){
			while (right <= high){
				temp[k] = array[right];
				right = right +1;
				k = k+1;
			}
		}
			for(int m=0;m<temp.length;m++){
				array[low + m] = temp[m];
			}	
		}//End Merge Sort
	
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