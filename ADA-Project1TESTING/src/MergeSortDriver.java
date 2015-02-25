/**
 * @author Nitin K Chaurasia
 * Fall 2014, Bowling Green State University
 * Submitted as a part of Project 1 Experimental Analysis of Sorting Algorithms
 * Implements Merge Sort.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSortDriver {
	
	/* Global Variables*/
	static int a[]; //Array will have N elements, indexed from 0 to N-1
	static String fileName;//holds the name of the file
	final static String RESULTS = "Results.log";
	static int n;//Size of the array
	static long compareCount = 0;//To count the number of comparisons
	static long lStartTime, lEndTime, executionTime;//Timer Variables
	
	public static void main(String[] args) throws IOException {
		/* Checking the proper number of Arguments*/
		if (args.length == 0 || args.length ==1 || args.length > 2) {
			System.err.println("Usage: java InsertionSort <fileName> <TotalCount>");
			System.exit(-1);
		}
		
		fileName = args[0];
		n = Integer.parseInt(args[1]);
		a = new int[n]; //Array will have N elements, indexed from 0 to N-1
		readFileData(fileName, a);
		
//		System.out.println("Array before Merge Sort");
//		printArray(a);
		
		//Sort the Array (Using Divide and Conquer Merge sort (Recursion))
		mergeSort(a,0,a.length-1);
		
//		System.out.println("Array After Merge Sort");
//		printArray(a);
		
		showResults(n,compareCount, executionTime);
	}
	
	//Begin Merge Sort (Sorts in place)
	public static void mergeSort(int []A,int low,int high){//low and high are the 
								//start and ending of the array
		// BEGIN TIMER
		lStartTime = System.nanoTime();
		if(low<high){//further subdivide the problem
			int mid = (low+high)/2;
			mergeSort(A,low,mid);//Divide the first half
			mergeSort(A,mid+1,high);//Divide the second half
			merge(A,low,mid,high);
			}
		//END TIMER
		lEndTime = System.nanoTime();
		executionTime = lEndTime - lStartTime;
	}// END MERGE SORT
	
	//Merge the arrays (most crucial part)
	static void merge(int []array,int low,int mid,int high){
		int temp[] = new int[high-low+1];//temporary array to hold the sorted values
		int left = low;
		int right = mid+1;
		int k = 0; //The index of temp
		
		//while(left<=mid && right<=high){
		while(compare(left,mid) && compare(right,high)){
			//if(array[left]<array[right]){
			if(compare(array[left],array[right])){
				temp[k] = array[left];
				left = left + 1;
				k = k+1;
			}else{
				temp[k]=array[right];
				right = right + 1;
				k = k+1;
			}//end if
		}//End While
		
		//if(left <=mid){
		if(compare(left,mid)){
			//while(left<=mid){
			while(compare(left,mid)){
				temp[k] = array[left];
				left = left+1;
				k=k+1;
			}
		}
		//else if(right <= high){
		else if(compare(right, high)){
			//while (right <= high){
			while (compare(right,high)){
				temp[k] = array[right];
				right = right +1;
				k = k+1;
			}
		}
			for(int m=0;m<temp.length;m++){
				array[low + m] = temp[m];
			}	
		}//End Merge Sort
	
	/**
	 * Method to count the total number of comparison.
	 *
	 * @param a the number for comparison
	 * @param b the number to be compared with
	 * @return boolean true if a > b
	 */
	public static boolean compare(int a, int b){
				compareCount++;//To keep track of the number of method calls
				if (a <= b)
					return true;
				else 
					return false;
			}
	
	/**
	 * Reads the data from the file and puts it into an Array.
	 *
	 * @param inputFileName the name of the file containing the integers
	 * @param A[] the integer Array which carries the integer from the file.
	 */
	public static void readFileData(String inputFileName, int A[]) {
		File input = new File(inputFileName);
		int i = 0;
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		while (inputFile.hasNext()) {
			//Put the integer from the file into the array
			A[i] = inputFile.nextInt();
			i++;
		}
		inputFile.close();//Closing the file
	}
	
	//Method to return results on Console and print data on a log file.
	public static void showResults (int size, 
									long compareCount, 
									long executionTime) throws IOException{
		System.out.println("Input Size = " +  size
				+ " Number of Comparisions = " + compareCount
				+ " Execution time(Micro Seconds) = " + executionTime/1000);
		
		//Append the Results in the log file.
		File file = new File(RESULTS);
	    FileWriter outputFile = new FileWriter(file, true);
		outputFile.append("*************************************************\n");
	    outputFile.append("Data from Merge Sort with Data File named as " + 
							fileName+"\n");
		outputFile.append("Input Size\t# Comparisons\tTime in MicroSeconds\n");
		//Write to File and Console
		outputFile.append("\t"+size + "\t\t\t " + 
				compareCount  + "\t\t\t\t " +
				executionTime/1000 + "\n");

		//Close the File
		outputFile.close();
	}
	
	/**
	 * Prints the array on Console for the verification purpose.
	 *
	 * @param B[] the Array that needs to be printed on the Console.
	 */
	public static void printArray(int B[]){
		for (int i=0;i<B.length;i++)//for each loop
			System.out.print(B[i] + ", ");//off by one bug (Extra Comma)
		System.out.println();
	}
	

}
