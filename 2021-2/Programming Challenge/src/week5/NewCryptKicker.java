package week5;

import java.util.*;

public class NewCryptKicker {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String perfS = null;
		
		System.out.print("Input Test Case Count : ");
		int caseN = input.nextInt();
		
		for(int i = 0; i < caseN; i++) {
			
			List<String> list = new ArrayList<String>();
			
//			while(input.hasNextLine()) {
//				
//				String s = input.nextLine();
//				
//				if(!s.equals("done")) {
//					list.add(s);
//				} else {
//					break;
//				}
//				System.out.println("while done");
//			}
//			System.out.println(list);
			
			list.add("vtz ud xnm xugm itr pyy jttk gmv xt otgm xt xnm puk ti xnm fprxq");
			list.add("xnm ceuob lrtzv ita hegfd tsmr xnm ypwq ktj");
			list.add("frtjrpgguvj otvxmdxd prm iev prmvx xnmq");
			
			System.out.println(list);
			
			for(int j = 0; j < list.size(); j++) {
				if (isPerfect(list.get(j))) {
					perfS = list.get(j);
				}
			}
			
			System.out.println("perfS = " + perfS);
			
			if (perfS != null) {
				Map<Character, Character> map = mapping(perfS);
				System.out.println(map);
				
				System.out.println("======================");
				
				decryptAndPrint(map, list);
			} else {
				System.out.println("No solution.");
			}
			
			
			
			
		}
		
		input.close();
	}
	
	
	private static boolean isPerfect(String s) {
		
		String[] target = s.split(" ");
		
		int[] statementCnt = {3, 5, 5, 3, 5, 4, 3, 4, 3};
		
		int[] cnt = new int[target.length];
		
		if (target.length != statementCnt.length) {
			return false;
		}
		
		for(int i = 0; i < target.length; i++) {
			cnt[i] = target[i].length();
		}
		
		for(int i = 0; i < cnt.length; i++) {
			if (cnt[i] != statementCnt[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	
	private static Map<Character, Character> mapping(String target) {
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		
		String s = "the quick brown fox jumps over the lazy dog";
		
		for(int i = 0; i < target.length(); i++) {
			
			char targetChar = target.charAt(i);
			char sChar = s.charAt(i);
			
			if (s.charAt(i) != ' ') {
				if (!map.containsKey(targetChar) && !map.containsValue(sChar)) {
					map.put(targetChar, sChar);
				}
			}
		}
		
		return map;
	}
	
	private static void decryptAndPrint(Map<Character, Character> map, List<String> list) {
		
		for(int i = 0; i < list.size(); i++) {
			String line = list.get(i);
			for (int j = 0; j < line.length(); j++) {
				char target = line.charAt(j);
				if (target == ' ') {
					System.out.print(" ");
				} else {
					System.out.print(map.get(target));
				}
			}
			System.out.println("");
		}
	}
	

}
