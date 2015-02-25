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
import java.util.Date;
import java.util.Scanner;


public class HeapSortDriver {
	/* Global Variables*/
	static int a[]; //Array will have N elements, indexed from 0 to N-1
	static String fileName;//holds the name of the file
	final static String RESULTS = "Results.log";
	static int n;//Size of the array
	static long compareCount = 0;//To count the number of comparisons
	static long lStartTime, lEndTime, executionTime;//Timer Variables
	//static String str = String.format("Current Date/Time : %tc", new Date() );//Current time

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
		
		//Sort the Array (Heap sort)
		heapsort(a);
		
//		System.out.println("Array After Insertion Print");
//		printArray(a);
		
		showResults(n,compareCount, executionTime);
	}
		
	/**
	 * Begin heap sort (Sorts in place).
	 *
	 * @param A[] the Array to be used for sorting.
	 * @param n the size of the array
	 */
	static void max_heapify(int[] A, int heap_size, int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if( l < heap_size && compare(A[l], A[i]))
                largest = l;
        else 
                largest = i;
        
        if(r < heap_size && compare(A[r], A[largest]))
                largest = r;
        
        if (largest != i){
                int exchange = A[i];
                A[i] = A[largest];
                A[largest] = exchange;
                
                max_heapify(A, heap_size, largest);
        }
    }
    
    
    static void build_max_heap(int[] A){
        for(int i = (A.length / 2); i >= 0; i--){
                max_heapify(A,  A.length, i);
        }
    }
    
    static void heapsort(int[] A){
    	
		lStartTime = System.nanoTime();
        build_max_heap(A);
        
        int heap_size = A.length;
        int exchange;
        
        for(int i = A.length-1; i >= 1; i--){
                exchange = A[i];
                A[i] = A[0];
                A[0] = exchange;
                heap_size --;
                max_heapify(A, heap_size, 0);
        }
        lEndTime = System.nanoTime();
		executionTime = lEndTime - lStartTime;
    }
    
    static int parent(int i){
            return i/2;
    }
    
    static int left(int i){
            return 2*i ;
    }
    
    static int right(int i){
            return 2*i + 1;
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
		//System.out.println(str);
		
		//Append the Results in the log file.
		File file = new File(RESULTS);
	    FileWriter outputFile = new FileWriter(file, true);
		//outputFile.append("*****Done On**********" + str +"\n");
		outputFile.append("*************************************************\n");
	    outputFile.append("Data from Heap Sort with Data File named as " + 
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
