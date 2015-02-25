/*
 * |----------------------------------------|
 * |	left child |  data	| right child	|
 * |----------------------------------------|
 * */
public class BSTNode {
	
	 BSTNode left, right, parent;
     public int data;
 
     /* Constructor */
     public BSTNode(int data)
     {
    	 this.data = data; 
    	 right = left = parent = null;
     }
     
     public String toString(){
    	 return ("The node has value" + data);
     }
     
  
}
