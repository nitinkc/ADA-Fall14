import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Implementing the Binary search tree
 */

/**
 * @author nitin
 * Wednesday Oct 29
 *
 */
public class BinarySearchDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		BST bst = new BST();
		File file = new File("data.txt");
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			//System.out.println("Where is the File??");
			e.printStackTrace();
		}
		
		while (inputFile.hasNext()){
			int val = inputFile.nextInt();
			//System.out.println(val);
			bst.insert(new BSTNode(val));			
		}		
		//Close the File
		inputFile.close();
		
		System.out.println("InOrder Traversal");
		bst.inorder(bst.root);

		System.out.println("\nPre-Order Traversal");
		bst.preorder(bst.root);
		
		System.out.println("\nPost-Order Traversal");
		bst.postorder(bst.root);
	}

}
