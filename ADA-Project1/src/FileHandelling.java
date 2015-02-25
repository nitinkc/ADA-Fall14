/*
 * File name: FileOutput.java
 * 
 * Programmer: Pranay Rawat
 * ULID: prawat
 * Date: Apr 8, 2014
 *
 * Class:IT 177
 * Lecture Section:001
 * Lecture Instructor:Carthy Holbrook
 * Lab Section:002
 * Lab Instructor:Nasiba Alrawi
 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author it1770213
 *
 */
public class FileHandelling
{
	private PrintWriter outputFile;
	final static String RESULTS = "Results.log";

	
	public void showResults (int size, long compareCount, long executionTime)
	{
		System.out.println("Input Size = " +  size
				+ " Number of Comparisions = " + compareCount
				+ " Execution time(Micro Seconds) = " + executionTime/1000);
		
		PrintWriter outputFile = null;
		
			 try
			{
				outputFile = new PrintWriter (RESULTS);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		
			//Write to File and Console
			 
			outputFile.println(size + " " + compareCount  + " " + executionTime/1000);

			//Close the File
			outputFile.close();
	}
	
	public void readFileData(String inputFileName, int array[], int size) {
		File input = new File(inputFileName);
		int i = 0;
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		while (inputFile.hasNext()) {
			array[i] = inputFile.nextInt();
			i++;
		}
		inputFile.close();
	}
}
