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

public class QuickSortDriver {

	/**
	 * @param args
	 */
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
		
		//System.out.println("Array before Insertion Sort");
		//printArray(a);
		
		//Sort the Array (quick sort)
		lStartTime = System.nanoTime();
		quickSort(a, 0, a.length-1);
		lEndTime = System.nanoTime();
		executionTime = lEndTime - lStartTime;
		//System.out.println("Array After Insertion Print");
		//printArray(a);
		
		showResults(n,compareCount, executionTime);
	}
		
	/**
	 * Begin quick sort (Sorts in place).
	 *
	 * @param A[] the Array to be used for sorting.
	 * @param n the size of the array
	 */	
	public static void quickSort(int a[],int p,int r){
		int q;
		if (p<r){
			q = partition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);	
		}
	}
	
	public static int partition(int a[],int p,int r){
		int x = a[r];//The last element becomes the pivot
		int i = p-1;//iterate through the first
		int exchange;
		for(int j=p; j <= r-1; j++){
			if (compare(a[j], x)){
				i = i+1;
				exchange = a[i];
                a[i] = a[j];
                a[j] = exchange;			}
		}
		exchange = a[i+1];
        a[i+1] = a[r];
        a[r] = exchange;
        
        return i+1;
	}

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
	    outputFile.append("Data from Quick Sort with Data File named as " + 
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