/**
 * @author Nitin K Chaurasia
 * Fall 2014, Bowling Green State University
 * Submitted as a part of Project 1 Experimental Analysis of Sorting Algorithms
 * Implements 3 way merge Sort.
 */

import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Date;
	import java.util.Scanner;
public class ThreeWayMergeSortDriver {

		/* Global Variables*/
		static int a[]; //Array will have N elements, indexed from 0 to N-1
		static String fileName;//holds the name of the file
		final static String RESULTS = "Results.log";
		static int n;//Size of the array
		static long compareCount = 0;//To count the number of comparisons
		static long lStartTime, lEndTime, executionTime;//Timer Variables
		//static String str = String.format("Current Date/Time : %tc", new Date() );//Current time

		public static void main(String[] args) throws IOException{
			
			/* Checking the proper number of Arguments*/
			if (args.length == 0 || args.length ==1 || args.length > 2) {
				System.err.println("Usage: java InsertionSort <fileName> <TotalCount>");
				System.exit(-1);
			}
			
			fileName = args[0];
			n = Integer.parseInt(args[1]);
			a = new int[n]; //Array will have N elements, indexed from 0 to N-1
			readFileData(fileName, a);
			
//			System.out.println("Array before Sort");
//			printArray(a);
			
			//Sort the Array (3 way merge sort)
			mergesort3Way(a);
			
//			System.out.println("Array After Insertion Print");
//			printArray(a);
			
			showResults(n,compareCount, executionTime);
		}
			
	    static void mergesort3Way(int[] A){
	    	
			lStartTime = System.nanoTime();			
			mergeSort(a, 0, a.length - 1);
	        lEndTime = System.nanoTime();
	        
			executionTime = lEndTime - lStartTime;
	    }
	   
	    static void mergeSort (int [] A, int p, int s){
	    	//variable for partition index
	    	int q, r;		
			//instead of high, low and mid, its begin1 end1 etc series.
			int beg1, end1, beg2, end2, beg3, end3;

			if (p < s){
				
				// divide the array into 3
				q = (s - p) / 3;
				r = 2 * q;//divided i(1/3) and i(2/3)

				//Piece 1 indices
				beg1 = p;           	
				end1 = p + q;       	
				//Piece 2 indices
				beg2 = end1 + 1;      	
				end2 = p + r;         	
				//Piece 3 indices
				beg3 = end2 + 1;      	
				end3 = s;           	

				// Sort the individual pieces
				mergeSort(A, beg1, end1);
				mergeSort(A, beg2, end2);
				mergeSort(A, beg3, end3);

				// and merge them together
				merge(A, beg1, end1, end2, end3);
			}
			//return A;
		}

		static int[] merge (int [] A, int p, int q, int r, int s){
			int h, i, j, k;

			int sublen1 = q - p + 1; // the size of the first sub-array
			int sublen2 = r - q;     // the size of the second sub-array
			int sublen3 = s - r;     // the size of the third sub-array

			/* Copying data into */
			int[] subArray = new int[sublen1];
			for (int n = 0; n < subArray.length; ++n){
				subArray[n] = A[p + n];
			}
			int[] subArray2 = new int[sublen2];
			for (int n = 0; n < subArray2.length; ++n){
				subArray2[n] = A[q + n + 1];
			}
			int[] subArray3 = new int[sublen3];
			for (int n = 0; n < subArray3.length; ++n){
				subArray3[n] = A[r + n + 1];
			}

			/* Merge the three sub-arrays */
			h = 0; i = 0; j = 0; // indices for subArray1, 2, 3
			k = p; // index for A
			
			// Gets the smallest element of the three sub-arrays
			while (h < sublen1 && i < sublen2 && j < sublen3){
				if (compare(subArray[h],subArray2[i]) && compare (subArray[h] , subArray3[j])){
					A[k++] = subArray[h++];
				}
				else if (compare (subArray2[i], subArray[h]) && compare (subArray2[i] , subArray3[j])){
					A[k++] = subArray2[i++];
				}
				else if (compare (subArray3[j], subArray[h]) && compare (subArray3[j] , subArray2[i])){
					A[k++] = subArray3[j++];
				}
			}

			/* For remaining two sub arrays */
			while (h < sublen1 && i < sublen2){
				if (compare (subArray[h], subArray2[i])){
					A[k++] = subArray[h++];
				}
				else{
					A[k++] = subArray2[i++];
				}
			}

			while (h < sublen1 && j < sublen3){
				if (compare (subArray[h] , subArray3[j])){
					A[k++] = subArray[h++];
				}
				else{
					A[k++] = subArray3[j++];
				}
			}

			while (i < sublen2 && j < sublen3){
				if (compare (subArray2[i], subArray3[j])){
					A[k++] = subArray2[i++];
				}

				else{
					A[k++] = subArray3[j++];
				}
			}

			// Completes the merged array with the left over elements
			while (h < sublen1){
				A[k++] = subArray[h++];
			}

			while (i < sublen2){
				A[k++] = subArray2[i++];
			}
			while (j < sublen3){

				A[k++] = subArray3[j++];
			}
			return A;
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
			//System.out.println(str);
			
			//Append the Results in the log file.
			File file = new File(RESULTS);
		    FileWriter outputFile = new FileWriter(file, true);
			//outputFile.append("*****Done On**********" + str +"\n");
			outputFile.append("*************************************************\n");
		    outputFile.append("Data from 3 way mergesort with Data File named as " + 
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
		 * @param B[] the Array that needs to be printed on the Console.
		 */
		public static void printArray(int B[]){
			for (int i=0;i<B.length;i++)//for each loop
				System.out.print(B[i] + ", ");//off by one bug (Extra Comma)
			System.out.println();
		}
		
		
	}