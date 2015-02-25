
public class StackDriver {
	
	public static void main(String[] args) {
		
		Stack S = new Stack();
		
		for (int i = 0; i < 5; i++)
		S.push(S, i*2);
		
		S.push(S,1000);
		S.push(S, 2000);
		
		S.peekReverse(S);
		
		System.out.println("Item Popped " + S.pop(S));

		//S.peekReverse(S);
		
		System.out.println("TESTING PEEK");
		S.peek(S);
	}

}
