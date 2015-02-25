
public class Stack {
	int top = -1;
	int arr[] = new int[100];
	
	
	public boolean stackEmpty(Stack S){
		if (S.top == 0) return true;
		return false;
	}
	
	public void push(Stack S, int data){
		S.top = S.top + 1;
		S.arr[top] = data;
	}
	
	public int pop(Stack S){
		if (stackEmpty(S)) 
			System.out.println("Empty Stack");
		else{
			S.top = S.top -1;
		}
		
		return S.arr[S.top + 1];//returning 
	}
	
	public void peekReverse(Stack S){
		int iterator = S.top;
		System.out.println("PEEK REV: Top = " + S.top);
		
		for (int i = iterator; i <= 0 ; i--){
			System.out.println("PEEK REV : Array value at Index " + iterator + "   " + S.arr[iterator]);
		}
			/* Buggy because the arr[0] never prints. Use Do While loop instead of 
			 * while as a substitute of "for"
			 */
			/*
			while(iterator != 0){
				System.out.println("Array value at Index " + iterator + "   " + S.arr[iterator]);
				iterator = iterator - 1;	
			}*/
	}
		
	public void peek(Stack S){//Small bug. Prints first element twice
		System.out.println("PEEK Top now " + S.top);
			for (int i = 0; i <= S.top; i++){
				System.out.println("PEEK : Array value at Index " + i + "   " + S.arr[i]);
		}	
	}
}


