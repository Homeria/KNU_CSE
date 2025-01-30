package week6;

import java.util.*;

public class Crypt24 {

public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		// Input crypted sample
		//String cryptedSample = input.nextLine();
		//String cryptedSample = "??i ????? h???? u?? ????? ??i? ??i ???? ??m";
		String cryptedSample = "??? b???? ????? ??j i??x? ???? ??? ??l? ???";
		//String cryptedSample = "?e? ????? r???? n?? i???? ???? ?e? ???? ???";
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		//Sttring output = "wsm baduo qretf cej iahxg epmr wsm knly vez"
		
		//int wordCount = Integer.parseInt(input.nextLine());
		
		
		// Input not crypted statement
		//String original = input.nextLine();
		//String original = "abcdd hijk lmnop qrstuv wxyzz";
		String original = "with because would about that good from make even they";
		//String original = "abcddhijklmnopqrstuvwxyzz";
		//String original = "gdy zalv spmx onwrkk ciuqet";
		//String original = "abcdd hijk lmnop qrstuv wxyzz abcdd hijk lmnop qrstuv wxyzz";
		
		
		// split original
		String[] splitedOriginal = original.split(" ");
		
		
		// Input crypted statement
		//String cryptOriginal = input.nextLine();
		//String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs";
		String cryptOriginal = "creh wsnw tdws wsmy teakv nqeaw zeev qmunagm mpmf hnom";
		//String cryptOriginal = "phqggeaylnofdxjkrcvstzwbb";
		//String cryptOriginal = "abc dfgh jklm opqstt uvwxyz";
		//String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs tzwbb nofdx phqgg eayl jkrcvs";
		
		String[] splitedCryptOriginal = cryptOriginal.split(" ");
		
		
		// Mapping not crypted statement
		Map<Character, Character> map = mapping(cryptedSample);
		
		System.out.println("map = " + map);
		
		// Half decrypt crypted statement
		String halfDecrypted = halfDecrypt(map, original);
		
		
		System.out.println("original = " + original);
		System.out.println("HalfDecrpyt = " + halfDecrypted);
		
		
		// split half
		String[] splitedHalfDecrypt = halfDecrypted.split(" ");
		
		
		// Additional mapping
		map = additionalMapping(map, splitedHalfDecrypt, cryptOriginal);
		
		System.out.println("additonal Mapping = " + map);
		
		for(int i = 0; i < sample.length(); i++) {
			char c = sample.charAt(i);
			if (c != ' ') {
				System.out.print(map.get(c));
			} else if (c == ' ') {
				System.out.print(' ');
			} else {
				System.out.print(c);
				//throw new NullPointerException();
			}
		}
		
		
		input.close();
	}
	
	private static Map<Character, Character> additionalMapping(Map<Character, Character> map, String[] dic, String line) {
		
		Map<String, String> wordMap = new HashMap<String, String>();
		
		String[] splitedLine = line.split(" ");

		List<String> tmp = new ArrayList<String>();

		
		if((dic.length == 1) && (splitedLine.length == 1)) {
			String s1 = dic[0];
			String s2 = splitedLine[0];
			for(int i = 0; i < s1.length(); i++) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(i);
				if(!map.containsKey(c1) && !map.containsValue(c2)) {
					map.put(c1, c2);
				} else {
				}
			}
			return map;
		}
		
		
		
		for(int i = 0; i < splitedLine.length; i++) {
			tmp.add(splitedLine[i]);
		}
		
		for(int i = 0; i < dic.length; i++) {
			String mostSimilary = getMostSimilar(dic[i], tmp);
			System.out.println("mostSimilary = " + mostSimilary);
			if (mostSimilary != null) {
				wordMap.put(dic[i], mostSimilary);
			} else {
				throw new NullPointerException();
			}
		}
		
		System.out.println("wordMap = " + wordMap);
		
		for(int i = 0; i < dic.length; i++) {
			String key = dic[i];
			String value = wordMap.get(key);
			
			if (value != null) {
				for(int j = 0; j < key.length(); j++) {
					
					char keyC = key.charAt(j);
					char valueC = value.charAt(j);
					
					System.out.println("keyC = " + keyC + ", valueC = " + valueC);
					
					if (!map.containsKey(keyC) && !map.containsValue(valueC)) {
						System.out.println("mapping " + keyC + " = " + valueC);
						map.put(keyC, valueC);
					}
				}
			}
			System.out.println("map = " + map);
		}
		
		return map;
	}
	
	private static String halfDecrypt(Map<Character, Character> map, String s) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c != ' ') && map.containsKey(c)) {
				sb.append(map.get(c));
			} else if (c != ' '){
				sb.append(c);
			} else if (c == ' ') {
				sb.append(" ");
			} else {
				//throw new NullPointerException();
			}
		}
		
		return sb.toString();
	}
	
	
	private static String getMostSimilar(String dict, List<String> list) {
		
		List<String> tmp1 = new ArrayList<String>();
		List<String> tmp2 = new ArrayList<String>();
		List<String> tmp3 = new ArrayList<String>();
		
		//tmp1 and tmp2
		List<String> intersection1 = new ArrayList<String>();
		
		//tmp2 and tmp3
		List<String> intersection2 = new ArrayList<String>();
		
		//tmp1 and tmp3
		List<String> intersection3 = new ArrayList<String>();
		
		//tmp1 and tmp2 and tmp3
		List<String> intersection4 = new ArrayList<String>();
		
		
		String target = null;
		
		// same length
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (dict.length() == s.length()) {
				tmp1.add(s);
			}
		}
		
		// same DuplicateCount
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if(findMaxCount(dict) == findMaxCount(s)) {
				tmp2.add(s);
			}
		}
		
		
		// similarity
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if(getSimilarity(dict, s) != 0) {
				tmp3.add(s);
			}
		}
		
		
		// length and duplicate
		intersection1 = intersection(tmp1, tmp2);
		
		// duplicate and similarity
		intersection2 = intersection(tmp2, tmp3);
		
		// length and similarity
		intersection3 = intersection(tmp1, tmp3);
		
		// length and duplicate and similarity
		intersection4 = intersection(tmp1, tmp2, tmp3);
		
		System.out.println("===================");
		System.out.println("dict = " + dict);
		System.out.println("tmp1 = " + tmp1);
		System.out.println("tmp2 = " + tmp2);
		System.out.println("tmp3 = " + tmp3);
		System.out.println("intersection1 = " + intersection1);
		System.out.println("intersection2 = " + intersection2);
		System.out.println("intersection3 = " + intersection3);
		System.out.println("intersection4 = " + intersection4);
		
		
		if(!intersection4.isEmpty()) {
			
			if(intersection4.size() == 1) {
				target = intersection4.get(0);
			} else {
				target = findFirst(intersection4, dict);
			}
			
		} else if (!intersection3.isEmpty()) {
			
			if(intersection3.size() == 1) {
				target = intersection3.get(0);
			} else {
				target = findFirst(intersection3, dict);
			}
		} else if (!intersection2.isEmpty()) {
			
			if(intersection2.size() == 1) {
				target = intersection2.get(0);
			} else {
				target = findFirst(intersection2, dict);
			}
			
		} else if (!intersection1.isEmpty()) {
			
			if(intersection1.size() == 1) {
				target = intersection1.get(0);
			} else {
				target = findFirst(intersection1, dict);
			}
			
		} else {
			target = tmp1.get(0);
		}
		removeTarget(target, list);
		return target;
	}
	
	private static String findFirst(List<String> list, String dict) {
		
		int[] cnt = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			for(int j = 0; j < s.length(); j++) {
				char dictC = dict.charAt(j);
				char sC = s.charAt(j);
				if(dictC == sC) {
					cnt[i] = j;
					break;
				}
			}
		}
		
		int min = 100;
		int index = 0;
		for(int i = 0; i < cnt.length; i++) {
			if (cnt[i] < min) {
				min = cnt[i];
				index = i;
			}
		}
		
		String s = list.get(index);
		
		return s;
	}
	
	private static void printArray(int[] arr) {
		System.out.print("[");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println("]");
	}
	
	private static List<String> intersection(List<String> list1, List<String> list2) {
		
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < list1.size(); i++) {
			String s = list1.get(i);
			if (list2.contains(s) && !list.contains(s)) {
				list.add(s);
			}
		}
		
		return list;
	}
	
	private static List<String> intersection(List<String> list1, List<String> list2, List<String> list3) {
		
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < list1.size(); i++) {
			String s = list1.get(i);
			if (list2.contains(s) && list3.contains(s) && !list.contains(s)) {
				list.add(s);
			}
		}
		
		for(int i = 0; i < list2.size(); i++) {
			String s = list2.get(i);
			if (list1.contains(s) && list3.contains(s) && !list.contains(s)) {
				list.add(s);
			}
		}
		
		for(int i = 0; i < list3.size(); i++) {
			String s = list3.get(i);
			if (list1.contains(s) && list2.contains(s) && !list.contains(s)) {
				list.add(s);
			}
		}
		
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
	
	private static void removeTarget(String s, List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			if(s.equals(list.get(i))) {
				list.remove(i);
				break;
			}
		}
	}
	
	private static int getSimilarity(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return 0;
		}
		
		int count = 0;
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	
	private static HashMap<Character, Character> mapping(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char sampleC = sample.charAt(i);
			
			if ((c != ' ') && (c != '?') && !map.containsKey(c)) {
				
				map.put(sampleC, c);
			}
		}
		return map;
	}
	
}
