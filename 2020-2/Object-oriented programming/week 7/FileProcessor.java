package w7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FileProcessor {

	
	/**
	 * 파일로부터 단어들을 읽어 이들을 ArrayList에 넣은 후 ArrayList를 반환한다.
	 * @param fileName 파일 이름
	 * @return 단어들이 들어 있는 리스트
	 * @throws FileNotFoundException
	 */
	public List<String> readFile(String fileName) throws FileNotFoundException {
		List<String> file = new ArrayList<>();
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			file.add(input.next());
		}
		input.close();
		return file;
	}
	
	
	/**
	 * 주어진 리스트에 들어 있는 단어들의 순서를 바꿔 새 ArrayList에 넣어 반환한다.
	 * @param list 단어들이 들어 있는 리스트
	 * @return 순서가 바뀐 단어들이 들어 있는 새  ArrayList
	 */
	public List<String> backwards(List<String> list) {
		List<String> backwardsFile = new ArrayList<>();
		ListIterator<String> iter = list.listIterator(list.size()) ;
		while(iter.hasPrevious()) {
			backwardsFile.add((String) iter.previous());
		}
		return backwardsFile;
	}
	
	
	/**
	 * 리스트에 들어 있는 단어들 중 주어진 문자열로 끝나는 단어들을 삭제해준다.
	 * @param list 단어들이 들어 있는 리스트
	 * @param s 문자열
	 */
	public void discardWords1(List<String> list, String s) {
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			if(iter.next().endsWith(s)) {
				iter.remove();
			}
		}
	}
	
	
	/**
	 * 리스트에 들어 있는 단어들 중 주어진 문자열로 끝나는 단어들을 삭제해준다.
	 * @param list 단어들이 들어 있는 리스트
	 * @param s 문자열
	 */
	public void discardWords2(List<String> list, String s) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).endsWith(s)) {
				list.remove(i);
				i--;
			}
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FileProcessor fileProcessor = new FileProcessor();
		
		List<String> list = fileProcessor.readFile("words.txt");
		System.out.println(list);
		
		List<String> backwardsList = fileProcessor.backwards(list);
		System.out.println(backwardsList);
		
		fileProcessor.discardWords1(list, "치");
		System.out.println(list);
		
		fileProcessor.discardWords2(backwardsList, "치");
		System.out.println(backwardsList);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
