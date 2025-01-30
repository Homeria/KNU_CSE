package week6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		BinarySearchTree<Character> tree = new BinarySearchTree<>();
		
		Scanner input = new Scanner(System.in);
		
		int num = 0;
		char ch = ' ';
		boolean done = false;
		
		while(!done) {
			System.out.print("Enter the number. (1) or (2) : ");
			num = input.nextInt();
			System.out.println("Entered number is " + num);
			System.out.println();
			if (num == 1) {
				done = true;
			} else if (num == 2) {
				System.out.print("Enter the character : ");
				ch = input.next().charAt(0);
				System.out.println("Entered character is " + ch);
				System.out.println();
				tree.add(ch);
				System.out.println(ch + " is added in tree");
			} else {
				System.out.println("[Error] Invalid value. Try again.");
			}
			System.out.println("==============================");
		}
		
		System.out.println("Maximum Depth : " + tree.maxDepth(tree));
		System.out.println("Minimum Depth : " + tree.minDepth(tree));
		
		input.close();
		
		
	}

}
