package week5;

import java.util.Scanner;

public class BinaryTreeConstructor {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		BinaryTree<Character> binaryTree = new BinaryTree<Character>();
		
		
		char data1 = 0;
		char data2 = 0;
		int num = 0;
		boolean isDone = false;
		boolean isDone2 = false;
		boolean isDone3 = false;
		boolean first = true;
		
		while(num != 1) {
			isDone = false;
			isDone2 = false;
			isDone3 = false;
			
			System.out.print("[1] exit, [2] append mode | Enter number : ");
			num = input.nextInt();
			
			if (num == 2) {
				
				while(!isDone) {
					
					if(first) {
						System.out.print("[2] Enter character : ");
						data1 = input.next().charAt(0);
						binaryTree.add(2, new BTNode<Character>(data1), null);
						System.out.println("[2-Okay] Character(" + data1 + ") is added.");
						first = false;
						isDone = true;
						
					} else {
						
						System.out.print("[3] or [4] | Enter number : ");
						num = input.nextInt();
						
						if (num == 3) {
							
							while(!isDone2) {
								System.out.print("[3] Enter character that does not exist in the binary tree : ");
								data1 = input.next().charAt(0);
								
								
								if(binaryTree.isExist(binaryTree, data1)) {
									System.out.println("[3-Error] This data exist in binary tree. Try again.");
									
								} else {
									binaryTree.add(3, new BTNode<Character>(data1), null);
									System.out.println("[3-Okay] Character(" + data1 + ") is added.");
									isDone = true;
									isDone2 = true;
								}
							}
							
						} else if (num == 4) {
							
							while(!isDone2) {
								System.out.print("[4-1] Enter character that does exist in the binary tree : ");
								data1 = input.next().charAt(0);
								
								if(binaryTree.isExist(binaryTree, data1)) {
									System.out.println("[4-1-Okay] This data exist in binaryTree. One more enter character.");
									
									while(!isDone3) {
										System.out.print("[4-2] Enter character that does not exist in the binary tree : ");
										data2 = input.next().charAt(0);
										
										if (binaryTree.isExist(binaryTree, data2)) {
											System.out.println("[4-2-Error] This data exist in binaryTree. Try again.");
											
										} else {
											BTNode<Character> node = binaryTree.getNode(binaryTree.getRoot(), data1);
											BTNode<Character> node2 = new BTNode<Character>(data2);
											binaryTree.add(4, node, node2);
											System.out.println("[4-2-Okay] Character(" + data2 + ") is added.");
											isDone = true;
											isDone2 = true;
											isDone3 = true;
										}
									}
								} else {
									System.out.println("[4-1-Error] This data not exist in binaryTree. Try again.");
								}
							}
						} else {
							System.out.println("[Error] Invalid value entered. Try again.");
						}
					}
				}
			} else if (num == 1) {
				System.out.println("adding node is done.");
			} else {
				System.out.println("[Error] Invalid value entered. exit this program.");
			}
			System.out.println("");
		}
		
		System.out.print("inorder traversal : ");
		binaryTree.inorder();
		System.out.println();
		
		System.out.print("preorder traversal : ");
		binaryTree.preorder();
		System.out.println();
		
		System.out.print("postorder traversal : ");
		binaryTree.postorder();
		System.out.println();
		
		input.close();
	}
}
