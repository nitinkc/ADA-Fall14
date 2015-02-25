/**
 * Implementing the BST according to CLRS.
 * Date Nov 2, 3:30 afternoon. DST ended last night
 * @author nitin
 *
 */
public class BST {
	
	BSTNode root = null;

    /* Function to check if tree is empty */
//    public boolean isEmpty()
//    {
//    	//Learned from CodingBat
//    	//return (root == null);
//    }
    
    /* Functions to insert data 
     * Check if the data belongs to the left child or the right and then 
     * proceed accordingly*/
    public void insert(BSTNode node)
    {
    	BSTNode x,y;
    	x = y = root; //two pointing nodes. 
    	//Y is trailing pointer, following x, because x goes till the end
    	
    	/* Traverse to the Last Node in the tree in the correct Direction */
    	while (x != null){
    		if(node.data <= x.data){//self-decided equality. 
    			//Equal values goes to the left
        		y = x;//y is the trailing pointer 
    			x  = x.left;
    		}
    		else{
        		y = x;//y is the trailing pointer 
    			x = x.right;
    		}
    	}//End While (Navigated to the last node)
    	//x is at the leaf node,and y at the parent
    	
    	/* Attach the node */
    	if (y == null){//Tree not yet initialized
    		root = node;
    		return;
    	}
    	
    	//else add the data at an appropriate place
    	if(node.data <= y.data){
	    	y.left = node;//set the node as the left child
    	}
    	
    	else{
    		y.right = node;
    	}
    	node.parent = y;
    }
    
    /* Functions to delete data */

    /* Function for inorder traversal */
    public void inorder(BSTNode r)
    {
    	if(r != null){
    	inorder(r.left);
    	System.out.print(r.data + " ");
    	inorder(r.right);
    	}
    }
    
    /* Function for pre-order traversal */
    public void preorder(BSTNode r)
    {
       if(r != null){
    	   System.out.print(r.data + " ");
    	   preorder(r.left);
    	   preorder(r.right);
       }
    }
    
    /* Function for postorder traversal */
    public void postorder(BSTNode r)
    {
    	 if(r != null){
      	   preorder(r.left);
      	   preorder(r.right);
      	   System.out.print(r.data + " ");
    	 }     
    }

    
    
    private void delete(BSTNode node){
    // Case 1: node does not have a child, just delete it
    	if (node.left == null && node.right == null){//Conforming the node is the last one
    		//Test which child is the current node (of parent).
    		if(node.parent != null && node.parent.left == node)
    			node.parent.left = null;
    		
    	}

    	
    // Case 2: node has only one child, splice the child with its parent

    // Case 3: node has both children, set the successor of the node to its parent
      
    }
    
    /* Replaces subtree rooted at node u with the subtree rooted at node v */
    public void transplant(BSTNode u, BSTNode v){
    	if(u.parent == null)//if u is the root
    		root = v;//make v as root
    	else if (u == u.parent.left) //if u is the left child of the parent
    		u.parent.left = v;//make v as the left child
    	else
    		u.parent.right = v; //else as v as the right child
    	
    	if (v != null)
    		v.parent = u.parent;
    	
    	/* v.left and v.right is updated from the method where transplant is called*/
    		
    }
   
    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r)
    {
        
    }
    /* Functions to search for an element */
    public boolean search(int val)
    {
    }
    /* Function to search for an element recursively */
    private boolean search(BSTNode r, int val)
    {
       
    }
}
