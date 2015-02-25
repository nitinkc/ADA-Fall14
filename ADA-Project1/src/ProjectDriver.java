import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Aggregates the data of the analysis and shows the output on the console and 
 * keeps the copy of the same data on the logs file 
 */

/**
 * @author nitin
 *
 */
public class ProjectDriver {
	public static final int SIZE1K = 1000;
	public static final int SIZE2K = 2000;
	public static final int SIZE4K = 4000;
	public static final int SIZE8K = 8000;
	
	final static String RANDOM8K = "input/random8K.txt";
	final static String RANDOM4K = "input/random4K.txt";
	final static String RANDOM2K = "input/random2K.txt";
	final static String RANDOM1K = "input/random1K.txt";
	final static String IDENTICAL8K = "input/identical8K.txt";
	final static String IDENTICAL4K = "input/identical4K.txt";
	final static String IDENTICAL2K = "input/identical2K.txt";
	final static String IDENTICAL1K = "input/identical1K.txt";
	final static String REVERSED8K = "input/reversed8K.txt";
	final static String REVERSED4K = "input/reversed4K.txt";
	final static String REVERSED2K = "input/reversed2K.txt";
	final static String REVERSED1K = "input/reversed1K.txt";
	final static String SORTED8K = "input/sorted8K.txt";
	final static String SORTED4K = "input/sorted4K.txt";
	final static String SORTED2K = "input/sorted2K.txt";
	final static String SORTED1K = "input/sorted1K.txt";
	
	
	static int array8K[] = new int[SIZE8K];
	static int array4K[] = new int[SIZE4K];
	static int array2K[] = new int[SIZE2K];
	static int array1K[] = new int[SIZE1K];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();	
	}
	
	public static void test(){
		Sort sort = new Sort();
		FileHandelling fh = new FileHandelling();
		
		fh.readFileData(RANDOM8K, array8K, SIZE8K);
		sort.insertionSort(array8K, SIZE8K);
		fh.showResults(SIZE8K, sort.compareCount, sort.executionTime );
		
		fh.readFileData(RANDOM4K, array4K, SIZE4K);
		sort.insertionSort(array4K, SIZE4K);
		fh.showResults(SIZE4K, sort.compareCount, sort.executionTime );
		
		fh.readFileData(RANDOM2K, array2K, SIZE2K);
		sort.insertionSort(array2K, SIZE2K);
		fh.showResults(SIZE2K, sort.compareCount, sort.executionTime );
		
		fh.readFileData(RANDOM1K, array1K, SIZE1K);
		sort.insertionSort(array1K, SIZE1K);
		fh.showResults(SIZE1K, sort.compareCount, sort.executionTime );
	}
	
}
