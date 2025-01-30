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
	
	int[] duplication;       //중복을 거르기 위한 배열
	int duplicationIndex;    //duplication 배열에 원소를 추가하기 위한 인덱스
	
	int[] discoveryOrder;
	int discoverOrderIndex;
	int[] finishOrder;
	int finishOrderIndex;
	boolean[] visited;
	int visitedIndex;
	int[] parent;
	
	/**
	 * 생성자
	 * @throws FileNotFoundException 12주차 data_sample.txt 파일이 존재하지 않는 경우
	 */
	public Graph() throws FileNotFoundException {
		file = new File("./src/12주차 data_sample.txt");
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
	 * 생성자
	 * @param file 사용하고자 하는 파일
	 * @throws FileNotFoundException 사용하고자 하는 파일이 존재하지 않는 경우
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
	 * size만큼 모든 원소를 -1로 채운 배열을 반환하는 메소드
	 * @param size 배열의 사이즈
	 * @return 모든 원소를 -1로 채운 size 크기의 배열
	 */
	private int[] makeArray(int size) {
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = -1;
		}
		return arr;
		
	}
	
	
	/**
	 * Scanner를 통해 데이터를 파싱하여 adjacencyMatrix와 list의 형태로 저장하는 메소드
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
	 * 파싱된 adjacencyMatrix를 통해 하나의 vertex와의 근접관계들을 리스트로 정리하여 필드에 있는 list에 추가하는 메소드
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
	 * 구해진 adjacencyMatrix를 출력하는 메소드
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
	 * 리스트의 원소를 단순출력하는 메소드
	 */
	public void printList() {
		for(int i = 0; i < this.list.size(); i++) {
			SingleLinkedList<Integer> list = this.list.get(i);
			System.out.println(i + " : " + list);
		}
		
	}
	
	
	/**
	 * Breadth-First Search 진행하는 메소드
	 * @param n 기준이 되는 숫자
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
	 * 파라미터로 받은 리스트를 원소마다 대괄호를 씌워 출력하는 메소드
	 * @param list 출력하고자 하는 리스트
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
	 * 배열 안에 해당 원소가 존재하는지 알아보는 메소드
	 * @param n 찾고자 하는 원소
	 * @return n이 배열 안에 존재하면 true, 아니면 false;
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
	 * 기준이 되는 리스트의 원소를 모아 다시 반환하는 메소드
	 * 만약 파라미터로 받은 리스트에 1과 2가 들어있다면, 1과 2에 인접해있는 원소를 리스트에 모두 담아 반환한다.
	 * @param lList 기준이 되는 원소들이 담긴 리스트
	 * @return 리스트에 담긴 기준 원소들에 인접해 있는 리스트를 모두 담은 리스트
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
