package week5;

import java.util.*;

public class CryptKicker3 {

	
	
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
//		System.out.print("Input Word count : ");
//		int cnt = Integer.parseInt(input.nextLine());
//		String[] dic = new String[cnt];
		
		String[] dic = {"and", "dick", "jane", "puff", "spot", "yertle"};
		
//		for(int i = 0; i < cnt; i++) {
//			System.out.print("Input #" + (i + 1) + " Word : ");
//			dic[i] = input.nextLine();
//		}
		
		Map<Character, Character> map;
		String line = "bjvg xsb hxsn xsb qymm xsb rqat xsb pnetfn";
		map = mapping(dic, line);
		System.out.println("");
		decryptAndPrint(map, line);
		
//		while(input.hasNextLine()) {
//			
//			;
//			
//			//String line = input.nextLine();
//			
//			
//			
//		}
		
		
		input.close();
		
		
	}
	
	
	private static Map<Character, Character> mapping(String[] dic, String line) {
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();
		
		String[] splitedLine = line.split(" ");
		
		for(int i = 0; i < dic.length; i++) {
			
		}
		
		
		for(int i = 0; i < dic.length; i++) {
			for(int j = 0; j < splitedLine.length; j++) {
				
				String dicWord = dic[i];
				String lineWord = splitedLine[j];
				
				System.out.println("==== dicWord = " + dicWord + ", lineWord = " + lineWord + " ====");
				
				if (dicWord.length() == lineWord.length()) {
					
					for(int p = 0; p < dicWord.length(); p++) {
						for(int q = 0; q < lineWord.length(); q++) {
							
							char dicChar = dicWord.charAt(p);
							char lineChar = lineWord.charAt(q);
							
							System.out.println("---- dicChar = " + dicChar + ", lineChar = " + lineChar + " ----");
							
							if(!map.containsKey(dicWord.charAt(p)) && !map.containsValue(dicWord.charAt(q)) && !map.containsKey(lineWord.charAt(q)) && !map.containsValue(lineWord.charAt(q)) && (dicChar != lineChar)) {
								System.out.println("Mapping " + dicChar + " and " + lineChar);
								map.put(dicChar, lineChar);
								System.out.println("map = " + map);
							}
						}
					}
					break;
				}
			}
			System.out.println();
			System.out.println("==================");
			System.out.println();
		}
		
		Set<Character> set = map.keySet();
		Iterator<Character> iter = set.iterator();
		
		while(iter.hasNext()) {
			Character key = (Character) iter.next();
			Character value = map.get(key);
			System.out.println("key = " + key + ", value = " + value);
			map2.put(value, key);
		}
		
		System.out.print("map = " + map2);
		
		return map2;
	}
	
	private static void decryptAndPrint(Map<Character, Character> map, String line) {
		
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < line.length(); i++) {
			System.out.println("char(" + i + ") : " + line.charAt(i));
			if(line.charAt(i) == ' ') {
				System.out.println("This is blank! append blank!");
				sb.append(' ');
			} else {
				Character value = map.get(line.charAt(i));
				System.out.println("value = " + value);
				if(value != null) {
					sb.append(value);
				} else {
					sb.append("*");
				}
			}
		}
		
		String s = sb.toString();
		System.out.print(s);
		
		
		
		
	}
	
	
	private static boolean isContain(String[] dic, String word) {
		
		for(int i = 0; i < dic.length; i++) {
			if (dic[i].equals(word)) {
				return true;
			}
		}
		return false;
	}

}
