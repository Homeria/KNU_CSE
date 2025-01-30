package week6;

import java.util.*;

public class Crypt2 {

	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String crypted = "??i ????? h???? u?? ????? ??i? ??i ???? ??m";
		
		
		//System.out.println(map);
		
		//int wordCount = Integer.parseInt(input.nextLine());
		
		int wordCount = 5;
		
		String original = "abcdd hijk lmnop qrstuv wxyzz";
		
		String[] splitedOri = original.split(" ");
		
		String crypt = "tzwbb nofdx phqgg eayl jkrcvs";
		
		ArrayList<Map<Character, Character>> list = mapping(crypted);
		
		list = additionalMapping(list, splitedOri, crypt);
		
		System.out.println("list = " + list);
		
		Map<Character, Character> map = list.get(0);
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		System.out.println("========================");
		for(int i = 0; i < sample.length(); i++) {
			char c = sample.charAt(i);
			if (c != ' ') {
				System.out.print(map.get(c));
			} else {
				System.out.print(" ");
			}
		}
		
		
		input.close();
	}
	
	private static ArrayList<Map<Character, Character>> additionalMapping(ArrayList<Map<Character, Character>> list, String[] dic, String line) {
		
		
		Map<Character, Character> map = list.get(0);
		Map<Character, Character> map2 = list.get(1);
		
		String[] splitedLine = line.split(" ");
		
		
		for(int i = 0; i < dic.length; i++) {
			for(int j = 0; j < splitedLine.length; j++) {
				
				System.out.println("map = " + map);
				System.out.println("map2 = " + map2);
				
				String dicWord = dic[i];
				String lineWord = splitedLine[j];
				
				if ((dicWord.length() == lineWord.length()) && (findMaxCount(dicWord) == findMaxCount(lineWord))) {
					
					for(int p = 0; p < dicWord.length(); p++) {
						for(int q = 0; q < lineWord.length(); q++) {
							
							char dicChar = dicWord.charAt(p);
							char lineChar = lineWord.charAt(q);
							
							
							if(!map.containsKey(dicWord.charAt(p)) && !map.containsValue(lineWord.charAt(q))) {
								System.out.println("put " + dicChar + " and " + lineChar);
								map.put(dicChar, lineChar);
							}
						}
					}
				}
			}
		}
		
		Set<Character> set = map.keySet();
		Iterator<Character> iter = set.iterator();
		
		while(iter.hasNext()) {
			Character key = (Character) iter.next();
			Character value = map.get(key);
			map2.put(value, key);
		}
		
		list.add(map);
		list.add(map2);
		
		System.out.println("map = " + map);
		System.out.println("map2 = " + map2);
		
		return list;
	}

	private static int findMaxCount(String word) {
	
		int[] cnt = new int[26];
		int max = 0;
		
		for(int i = 0; i < word.length(); i++) {
			cnt[word.charAt(i) - 97]++;
		}
		
		for(int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
			}
		}
		return max;
	}
	
	
	private static ArrayList<Map<Character, Character>> mapping(String s) {
		
		
		System.out.println("s = " + s);
		Map<Character, Character> map = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			char sampleC = sample.charAt(i);
			
			if ((c != ' ') && (c != '?') && !map.containsKey(c)) {
				map.put(sampleC, c);
				map2.put(c, sampleC);
			}
		}
		
		ArrayList<Map<Character, Character>> list = new ArrayList<Map<Character, Character>>();
		list.add(map);
		list.add(map2);
		
		return list;
	}
	
//	private static Map<Character, Character> additionalMapping(Map<Character, Character> map, String original, String crypted) {
//		
//		StringBuilder decrypt = new StringBuilder();
//		
//		String[] splitedCrypt = crypted.split(" ");
//		
//		for(int i = 0; i < crypted.length(); i++) {
//			
//			char c = crypted.charAt(i);
//			System.out.println("c = " + c);
//			
//			if ((c != ' ') && map.containsKey(c)) {
//				decrypt.append(map.get(c));
//			} else if (c == ' '){
//				decrypt.append(' ');
//			} else {
//				decrypt.append(c);
//			}
//		}
//		
//		String decrypted = decrypt.toString();
//		System.out.println("crypted = \t" + crypted);
//		System.out.println();
//		System.out.println("original = \t" + original);
//		System.out.println("decrpyted = \t" + decrypted);
//		
//		
//		
//		
//		return map;
//	}

}
