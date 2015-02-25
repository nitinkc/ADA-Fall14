import java.util.Scanner;

/**
 * @author nitin
 *
 */
public class GuessingGame {
	
	static int secret;
	static int n;

	public static void main(String[] args) {
		
		fillArray();
		guessRange(1,n);
	}

static int check(int p){//p=guess
	
	if (p == secret) return 0;
	else if  (p < secret) return -1;
	else return 1;
	}

static void fillArray(){
	System.out.println("Enter Range");
	Scanner kb = new Scanner(System.in);
	n = kb.nextInt();
	int A[] = new int[n];//Declaring the Size of the Array
	for(int i=0;i<n;i++){//++i because the index being at 0 but the
						//numbers are filed from 1
		A[i]=i+1;
		//System.out.print("i="+i+" and A[i] is " + A[i]);
	}
	System.out.println("Enter Secret number");
	secret = kb.nextInt();
	
	kb.close();
	
}

static void guessRange(int i, int a){
	int guess = a/2;
	if (check(guess)==0) System.out.println("Success");
	
	else if(check(guess)==-1) {
		//System.out.println("INSIDE check(guess)==-1)");
		guessRange(guess+1,a);
	}
	else{
		//System.out.println("INSIDE : guessRange(1,guess);");
		guessRange(1,guess);
		}
	}
}


	