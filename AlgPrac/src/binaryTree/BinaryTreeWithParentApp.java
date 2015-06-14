package binaryTree;

import java.util.Scanner;

/**
 * 							6
 * 						4		8
 * 					1	  5   7   9
 * 					   3	
 * 					 2	
 * 
 */
public class BinaryTreeWithParentApp {
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Binary Tree (with Parent reference) Test ***");
		
//		int[] arr = {1, 2};
		int[] arr = {6, 4, 8, 1, 7, 3, 9, 2, 5};
		BinaryTreeWithParent tree = new BinaryTreeWithParent();
		for (int i = 0; i < arr.length; i++) {
			tree.insertNoRec(tree.root, arr[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of a node: ");
		int val1 = sc.nextInt();
		System.out.print("Enter the value of a node: ");
		int val2 = sc.nextInt();
		
		NodeWithParent node1 = tree.searchNoRec(val1);
		NodeWithParent node2 = tree.searchNoRec(val2);
		System.out.print("The lowest common ancestor of Node " + node1.val 
			+ " and Node " + node2.val + " is: ");
		System.out.print(tree.lowestCommonAncestor(node1, node2).val);
		
	}
	
}
