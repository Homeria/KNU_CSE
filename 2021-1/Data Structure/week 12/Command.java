package week12;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Command {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		int answer = 0;
		Graph<Integer> graph = new Graph<Integer>();
		
		System.out.println(" [ adjaceny matrix ]");
		graph.printAdjacencyMatrix();
		
		System.out.println("Input start node >> ");
		
		answer = input.nextInt();
		
		System.out.println("DFS result : ");
		graph.depthFirstSearch(answer);
		System.out.println("");
		System.out.println("BFS result : ");
		graph.breadthFirstSearch(answer);
		
		
		input.close();
		
	}

}
