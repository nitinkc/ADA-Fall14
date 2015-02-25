The project has 5 independent Programs names as
1. InsertionSortDriver.java
2. QuickSortDriver.java
3. MergeSortDriver.java
4. HeapSortDriver.java
5. ThreeWayMergeSortDriver.java

All the programs are independent and needs two arguments to run. 
1. Argument 1 is file name (which has input data) 
2. Argument 2 input size 

All the input files are kept in the input folder inside src. The input folder had a shell script "generate.sh" which generates the input (16 files) using the generator program provided with the assignment.

Inside the src folder, all the programs are kept together with a "run.sh" script to execute the programs.

All the Results are "Appended" in Results.log file. For testing, please delete the Results.log and run the program as "sh run.sh"

For testing purposes, there is a test file called test.txt with 10 input data. Use this file to see (on the console, if the output is sorted properly or not). Please uncomment these lines in the main method of all the programs

//		System.out.println("Array before Insertion Sort");
//		printArray(a);
		
		//EXAMPLE
		//Sort the Array (Insertion sort)
		insertionSort(a,n);
		
//		System.out.println("Array After Insertion Print");
//		printArray(a);

and run the program as 
javac InsertionSortDriver.java
java InsertionSortDriver test.txt 10

