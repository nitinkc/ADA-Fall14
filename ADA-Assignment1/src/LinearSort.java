/**
 * @author nitin
 * At Student union
 * 5:30 PM on Sep 11'14 
 */
public class LinearSort {
	
	static int input[] = {9,1,4,7,2};//size = n	
	static int temp[] = new int[10];//Range is kn (k=2, n=5)
	
	public static void main(String[] args) {
	//Place the value in its respective index e.g. place 6 n index 6
	for (int i=0;i<5;i++){
		temp[input[i]-1] = input[i];//- 1 to match the java style indexing which begins from zero
	}//end for
	
	//For verification. Not involved in the Time calculation
	for (int i=0;i<10;i++){
		System.out.print(temp[i]);
		}//For ends
	
	int num = 0;//to control the index of input array
	for (int i=0;i<10;i++){
		if (temp[i]!=0){
			input[num]=temp[i];
			num++;
		}
	}//For ends
	
	//For verification. Not involved in the Time calculation
	System.out.println();
	for (int i=0;i<5;i++){
		System.out.print(input[i]);
		}//For ends
	}//main ends
}//class ends
