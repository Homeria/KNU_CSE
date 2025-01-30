package week8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Heap heap = new Heap();
		Scanner input = new Scanner(System.in);
		int n;
		
		boolean done = false;
		boolean smallest;
		
		System.out.println("========================================");
		System.out.println("[Step 1] Enter number to store in the heap");
		while(!done) {
			System.out.print("Enter number : ");
			n = input.nextInt();
			System.out.println("------------------------------");
			
			if (n < 0) {
				System.out.println("Exit");
				done = true;
			} else {
				
				heap.add(n);
				System.out.println(n + " add in heap");
				heap.printArray();
				System.out.println("------------------------------");
			}
		}
		
		
		System.out.println("========================================");
		System.out.println("[Step 2] Enter number to compare with the number stored in the heap");
		System.out.print("Enter number : ");
		n = input.nextInt();
		
		System.out.println("========================================");
		System.out.println("[Step 3] I'll compare Entered number with minimum in the heap");
		smallest = heap.examineMin(n);
		if(smallest) {
			System.out.println("OK. " + n + " is minimum.");
		} else {
			System.out.println("No. " + n + " is not minimum.");
			System.out.println("Minimum in heap is " + heap.searchMin() + ".");
		}
		System.out.println("========================================");
		System.out.println("Exit program");
		input.close();
		
	}

}
