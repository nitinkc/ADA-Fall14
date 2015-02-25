/**
 * @author Nitin K Chaurasia
 * Fall 2014, Bowling Green State University
 * Submitted as a part of Project 1 Experimental Analysis of Sorting Algorithms
 * Implements Heap Sort.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertionSortDriver {
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
		
//		System.out.println("Array before Insertion Sort");
//		printArray(a);
		
		//Sort the Array (Insertion sort)
		insertionSort(a,n);
		
//		System.out.println("Array After Insertion Print");
//		printArray(a);
		
		showResults(n,compareCount, executionTime);
	}
		
	/**
	 * Begin insertion sort (Sorts in place).
	 *
	 * @param A[] the Array to be used for sorting.
	 * @param n the size of the array
	 */	
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

	/**
	 * Method to count the total number of comparison.
	 *
	 * @param a the number for comparison
	 * @param b the number to be compared with
	 * @return boolean true if a > b
	 */
	public static boolean compare(int a, int b){
				compareCount++;//To keep track of the number of method calls
				if (a > b)
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
	    outputFile.append("Data from Insertion Sort with Data File named as " + 
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