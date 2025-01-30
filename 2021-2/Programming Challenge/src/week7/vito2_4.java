package week7;

import java.util.*;

public class vito2_4 {

	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		int caseN = Integer.parseInt(input.nextLine());
		
		List<Integer> list;
		
		for(int i = 0; i < caseN; i++) {
			
			list = new ArrayList<Integer>();
			
			String[] lines = input.nextLine().split(" ");
			
			int relationN = Integer.parseInt(lines[0]);
			
			for(int j = 1; j < lines.length; j++) {
				String s = lines[j];
				list.add(Integer.parseInt(s));
			}
			
			System.out.println("list = " + list);
			
			Collections.sort(list);
			
			System.out.println("list = " + list);
			
			System.out.println(list.get(list.size() / 2));
			
			
			
			
		}
		
		
		
	}
	
}
