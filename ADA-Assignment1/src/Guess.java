/**
 * @author nitin
 * Sept 09, 2014
 */
public class Guess {
	static int secret = 78;//Our secret code
	
	public static void main(String[] args) {
		
		GUESSRANGE(1,100);//if n=100
	}

	static int GUESSRANGE(int min, int max)
	{
	      // calculate midpoint to cut the set in half
	      int guess = (min+max)/2;
	 
	      // three-way comparison
	      if (CHECK(guess) == 1){
	        // guess is in lower subset (left side)
	    	  System.out.println("Inside Left Array:" + guess);//test the guesses
	        return GUESSRANGE(min, guess-1);
	      }
	
	      else if (CHECK(guess) == -1){
	        // guess is in upper subset (Right Side)
	    	  System.out.println("Inside Right Array:" + guess);//test the guesses
	        return GUESSRANGE(guess+1, max);
	      }
	      else{
	    	  // guess has been found
	    	  System.out.println("SUCCESS:          " + guess);
		        return guess;  
	      }  
	}

	static int CHECK(int p){
		if (p == secret) return 0;
		else if (p < secret) return -1;
		//else if (p > secret) return 1;
		else return 1;
	}
}


