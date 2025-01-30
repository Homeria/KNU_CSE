package week2;

import java.util.*;

public class Bigram {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		
		while(input.hasNextLine()) {
			
			List<String> list = new ArrayList<String>();
			Set<String> set = new HashSet<String>();
			
			String s = input.nextLine();
			for(int i = 0; i < s.length() - 1; i++) {
				if ((s.charAt(i + 1) != ' ') && (s.charAt(i + 1) != ',') && (s.charAt(i) != ' ') && (s.charAt(i) != ',')) {
					String substring = s.substring(i, i + 2);
					list.add(substring);
					set.add(substring);
				}
			}
			
			int[] count = new int[set.size()];
			String[] sArr = new String[set.size()];
			Iterator<String> iter = set.iterator();
			for(int i = 0; i < sArr.length; i++) {
				sArr[i] = iter.next();
			}
			for(int i = 0; i < sArr.length; i++) {
				count[i] = count(list, sArr[i]);
			}
			
			int max = findMax(count);
			if (max < 2) {
				System.out.println("persistent problem");
			} else {
				List<String> maxList = new ArrayList<String>();
				for(int i = 0; i < count.length; i++) {
					if (count[i] == max) {
						maxList.add(sArr[i]);
					}
				}
				Collections.sort(maxList);
				
				for(int i = 0; i < maxList.size(); i++) {
					System.out.print(maxList.get(i));
					if (i != maxList.size() - 1) {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			
		}
	}
	
	private static int count(List<String> list, String s) {
		int count = 0;
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String next = iter.next().toString();
			if (next.equals(s)) {
				count++;
			}
		}
		return count;
	}
	
	private static int findMax(int[] arr) {
		int n = 0;
		for(int i = 0; i < arr.length; i++) {
			if (n < arr[i]) {
				n = arr[i];
			}
		}
		return n;
	}

}
