/**
 * With an input array
 */

/**
 * @author nitin
 *
 */
public class CountingSort {
	
	

	public void countingSortImple(int A[],int[] B, int n, int k){
		int C[];
		
		for(int i=0;i<k;i++){
			C[i]=0;
		}
		
		for (int j=0;j<n;j++){
			C[A[j]] = C[A[j]]+1;
		}
		
		for (int i =0;i<k;i++){
			C[i] = C[i] + C[i-1];
		}
		
		for (int j=1;j<1;j--){
			B[C[A[j]]] = A[j];
			C[A[j]]=C[A[j]]-1;
		}
		
		
			
		}
			
			
			
		}
		
	}
}


