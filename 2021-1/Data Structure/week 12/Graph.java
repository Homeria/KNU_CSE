package week12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Graph<E> {

	File file;
	Scanner input;
	
	int size;
	int[][] adjacencyMatrix;
	
	ArrayList<SingleLinkedList<Integer>> list;
	
	int[] duplication;       //�ߺ��� �Ÿ��� ���� �迭
	int duplicationIndex;    //duplication �迭�� ���Ҹ� �߰��ϱ� ���� �ε���
	
	int[] discoveryOrder;
	int discoverOrderIndex;
	int[] finishOrder;
	int finishOrderIndex;
	boolean[] visited;
	int visitedIndex;
	int[] parent;
	
	/**
	 * ������
	 * @throws FileNotFoundException 12���� data_sample.txt ������ �������� �ʴ� ���
	 */
	public Graph() throws FileNotFoundException {
		file = new File("./src/12���� data_sample.txt");
		input = new Scanner(file);
		list = new ArrayList<SingleLinkedList<Integer>>();
		parsing();
		
		duplication = makeArray(size);
		duplicationIndex = 0;
		
		discoveryOrder = makeArray(size);
		discoverOrderIndex = 0;
		finishOrder = makeArray(size);
		finishOrderIndex = 0;
		visited = new boolean[size];
		visitedIndex = 0;
		parent = makeArray(size);
	}
	
	
	/**
	 * ������
	 * @param file ����ϰ��� �ϴ� ����
	 * @throws FileNotFoundException ����ϰ��� �ϴ� ������ �������� �ʴ� ���
	 */
	public Graph(File file) throws FileNotFoundException {
		this.file = file;
		input = new Scanner(file);
		list = new ArrayList<SingleLinkedList<Integer>>();
		parsing();
		
		duplication = makeArray(size);
		duplicationIndex = 0;
		
		discoveryOrder = makeArray(size);
		discoverOrderIndex = 0;
		finishOrder = makeArray(size);
		finishOrderIndex = 0;
		visited = new boolean[size];
		visitedIndex = 0;
		
	}
	
	
	/**
	 * size��ŭ ��� ���Ҹ� -1�� ä�� �迭�� ��ȯ�ϴ� �޼ҵ�
	 * @param size �迭�� ������
	 * @return ��� ���Ҹ� -1�� ä�� size ũ���� �迭
	 */
	private int[] makeArray(int size) {
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = -1;
		}
		return arr;
		
	}
	
	
	/**
	 * Scanner�� ���� �����͸� �Ľ��Ͽ� adjacencyMatrix�� list�� ���·� �����ϴ� �޼ҵ�
	 */
	private void parsing() {
		
		String[] parsingArr;
		
		int[][] adjacencyMatrix;
		
		int start, end;
		
		size = Integer.parseInt(input.nextLine());
		
		adjacencyMatrix = new int[size][size];
		parsingArr = new String[size];
		
		try {
			for(int i = 0; i < size * size; i++) {
				String parsing = input.nextLine();
				
				if (!(parsing.equals(""))) {
					parsingArr = parsing.split("-");
					
					start = Integer.parseInt(parsingArr[0]);
					end = Integer.parseInt(parsingArr[1]);
					adjacencyMatrix[start][end] = 1;
					adjacencyMatrix[end][start] = 1;
				}
			}
		} catch (NoSuchElementException e) {
		} catch (ArrayIndexOutOfBoundsException e) {
		} catch (StringIndexOutOfBoundsException e) {
		}
		
		this.adjacencyMatrix = adjacencyMatrix;
		addElement();
	}
	
	
	/**
	 * �Ľ̵� adjacencyMatrix�� ���� �ϳ��� vertex���� ����������� ����Ʈ�� �����Ͽ� �ʵ忡 �ִ� list�� �߰��ϴ� �޼ҵ�
	 */
	private void addElement() {
		SingleLinkedList<Integer> list;
		int index = 0;
		
		for(int i = 0; i < size; i++) {
			list = new SingleLinkedList<Integer>();
			for(int j = 0; j < size; j++) {
				if (adjacencyMatrix[i][j] == 1) {
					list.add(index, j);
					index++;
				}
			}
			this.list.add(list);
			index = 0;
		}
	}
	
	
	/**
	 * ������ adjacencyMatrix�� ����ϴ� �޼ҵ�
	 */
	public void printAdjacencyMatrix() {
		for(int i = 0; i < adjacencyMatrix.length; i++) {
			System.out.print("       ");
			for(int j = 0; j < adjacencyMatrix.length; j++) {
				System.out.print(adjacencyMatrix[i][j]);
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * ����Ʈ�� ���Ҹ� �ܼ�����ϴ� �޼ҵ�
	 */
	public void printList() {
		for(int i = 0; i < this.list.size(); i++) {
			SingleLinkedList<Integer> list = this.list.get(i);
			System.out.println(i + " : " + list);
		}
		
	}
	
	
	/**
	 * Breadth-First Search �����ϴ� �޼ҵ�
	 * @param n ������ �Ǵ� ����
	 */
	public void breadthFirstSearch(int n) {
		
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		
		int index = 0;
		list.add(index, n);
		
		index++;
		
		for(int i = 0; i < size; i++) {
			printElement(list);
			list = getElement(list);
			
		}
		
		System.out.println("");
		
		
	}
	
	
	/**
	 * �Ķ���ͷ� ���� ����Ʈ�� ���Ҹ��� ���ȣ�� ���� ����ϴ� �޼ҵ�
	 * @param list ����ϰ��� �ϴ� ����Ʈ
	 */
	private void printElement(SingleLinkedList<Integer> list) {
		for(int i = 0; i < list.getSize(); i++) {
			if (!isExist(duplication, list.get(i))) {
				System.out.print("[" + list.get(i) + "] ");
				duplication[duplicationIndex] = list.get(i);
				duplicationIndex++;
			}
		}
	}
	
	
	/**
	 * �迭 �ȿ� �ش� ���Ұ� �����ϴ��� �˾ƺ��� �޼ҵ�
	 * @param n ã���� �ϴ� ����
	 * @return n�� �迭 �ȿ� �����ϸ� true, �ƴϸ� false;
	 */
	private boolean isExist(int[] array, int n) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * ������ �Ǵ� ����Ʈ�� ���Ҹ� ��� �ٽ� ��ȯ�ϴ� �޼ҵ�
	 * ���� �Ķ���ͷ� ���� ����Ʈ�� 1�� 2�� ����ִٸ�, 1�� 2�� �������ִ� ���Ҹ� ����Ʈ�� ��� ��� ��ȯ�Ѵ�.
	 * @param lList ������ �Ǵ� ���ҵ��� ��� ����Ʈ
	 * @return ����Ʈ�� ��� ���� ���ҵ鿡 ������ �ִ� ����Ʈ�� ��� ���� ����Ʈ
	 */
	private SingleLinkedList<Integer> getElement(SingleLinkedList<Integer> lList) {
		
		int index = 0;
		SingleLinkedList<Integer> newList = new SingleLinkedList<Integer>();
		
		for(int i = 0; i < lList.getSize(); i++) {
			SingleLinkedList<Integer> list = this.list.get(lList.get(i));
			for(int j = 0; j < list.getSize(); j++) {
				if (list.get(j) != null) {
					newList.add(index, list.get(j));
					index++;
				}
			}
		}
		
		return newList;
		
	}
	
	
	public void depthFirstSearch(int n) {
		
		System.out.print("[" + n + "] ");
		
		visited[n] = true;
		discoveryOrder[discoverOrderIndex++] = n;
		
		int neighbor = 0;
		
		SingleLinkedList<Integer> list = this.list.get(n);
		for(int i = 0; i < list.getSize(); i++) {
			neighbor = list.get(i);
			if (!visited[neighbor]) {
				parent[neighbor] = n;
				depthFirstSearch(neighbor);
			}
		}
		finishOrder[finishOrderIndex++] = n;
		
	}
	
	
}
