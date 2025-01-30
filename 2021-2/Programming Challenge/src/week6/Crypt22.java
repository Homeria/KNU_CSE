package week6;

import java.util.*;

public class Crypt22 {

	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		//String cryptedSample = input.nextLine();
		String cryptedSample = "??i ????? h???? u?? ????? ??i? ??i ???? ??m";
		//String cryptedSample = "?e? ????? r???? n?? i???? ???? ?e? ???? ???";
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		//System.out.println(map);
		
		//int wordCount = Integer.parseInt(input.nextLine());
		
		
		//String original = input.nextLine();
		String original = "abcdd hijk lmnop qrstuv wxyzz";
		//String original = "abc dd hi jk lmnop qrst uv wx yzz";
		//String original = "abcddhijklmnopqrstuvwxyzz";
		//String original = "gdy zalv spmx onwrkk ciuqet";
		//String original = "abcdd hijk lmnop qrstuv wxyzz zzz zzzzz zzzzz zzzz zzz";
		//String original = "abcdd hijk lmnop qrstuv wxyzz abcdd hijk lmnop qrstuv wxyzz";
		
		//String cryptOriginal = input.nextLine();
		String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs";
		//String cryptOriginal = "phq gg ea yl nofdx jkrc vs tz wbb";
		//String cryptOriginal = "phqggeaylnofdxjkrcvstzwbb";
		//String cryptOriginal = "jkrcvs phqgg tzwbb eayl nofdx";
		//String cryptOriginal = "abc dfgh jklm opqstt uvwxyz";
		//String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs bbwzt xdfon ggqhp lyae svcrkj";
		//String cryptOriginal = "tzwbb bbbbb nofdx bbbb phqgg bbb eayl bbb jkrcvs bbbbb";
		//String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs tzwbb nofdx phqgg eayl jkrcvs";
		
		
		String[] splitedOriginal = original.split(" ");
		
		ArrayList<Map<Character, Character>> list = mapping(cryptedSample);
		
		System.out.println("half : " + list.get(0));
		
		String halfCrypt = halfDecrypt(list.get(0), original);
		
		System.out.println("halfCrypt = " + halfCrypt);
		
		String[] splitedHalfCrypt = halfCrypt.split(" ");
		
		list = additionalMapping(list, splitedHalfCrypt, cryptOriginal);
		
		Map<Character, Character> map = list.get(0);
		Map<Character, Character> map2 = list.get(1);
		
		System.out.println("map = " + map);
		System.out.println("map2 = " + map2);
		
		for(int i = 0; i < sample.length(); i++) {
			char c = sample.charAt(i);
			
			if (c != ' ') {
				char value = map.get(c);
				System.out.print(value);
			} else if (c == ' '){
				System.out.print(' ');
			}
		}
		
		
		input.close();
	}
	
private static ArrayList<Map<Character, Character>> additionalMapping(ArrayList<Map<Character, Character>> list, String[] dic, String line) {
		
		Map<Character, Character> map = list.get(0);
		Map<Character, Character> map2 = list.get(1);
		Map<String, String> wordMap = new HashMap<String, String>();
		ArrayList<Map<Character, Character>> newList = new ArrayList<Map<Character, Character>>();
		
		String[] splitedLine = line.split(" ");
		
		
		
//		if((dic.length == 1) && (splitedLine.length == 1)) {
//			String s1 = dic[0];
//			String s2 = splitedLine[0];
//			for(int i = 0; i < s1.length(); i++) {
//				char c1 = s1.charAt(i);
//				char c2 = s2.charAt(i);
//				System.out.println("c1 = " + c1 + ", c2 = " + c2);
//				if(!map.containsKey(c1) && !map.containsValue(c2)) {
//					System.out.println("put " + c1 + " and " + c2);
//					map.put(c1, c2);
//					map2.put(c2, c1);
//				} else {
//					System.out.println("Duplicate!");
//				}
//				System.out.println("map = " + map);
//			}
//			newList.add(map);
//			newList.add(map2);
//			return newList;
//		}
//		
//		
		List<String> tmp = new ArrayList<String>();
		
//		for(int i = 0; i < splitedLine.length; i++) {
//			tmp.add(splitedLine[i]);
//		}
//		
//		
//		
//		
//		for(int i = 0; i < dic.length; i++) {
//			String mostSimilary = getMostSimilar(dic[i], tmp);
//			if (mostSimilary != null) {
//				wordMap.put(dic[i], mostSimilary);
//			} else {
//				throw new NullPointerException();
//			}
//			
//		}
//		
//		System.out.println();
//		System.out.println("wordMap = " + wordMap);
//		System.out.println("tmp = " + tmp);
//		
		
		
		
		tmp = new ArrayList<String>();
		
		wordMap = new HashMap<String, String>();
		
		List<String> candidate = new ArrayList<String>();
		
		for(int i = 0; i < splitedLine.length; i++) {
			tmp.add(splitedLine[i]);
		}
		
		
		for(int i = 0; i < dic.length; i++) {
			
			candidate = new ArrayList<String>();
			
			String dicWord = dic[i];
			
			for(int j = 0; j < tmp.size(); j++) {
				
				
				String lineWord = tmp.get(j);
				
				if ((dicWord.length() == lineWord.length()) && (findMaxCount(dicWord) == findMaxCount(lineWord))) {
					candidate.add(lineWord);
				}
				
			}
			
			for(int p = 0; p < candidate.size(); p++) {
				
				String lineWord = candidate.get(p);
				
				for(int q = 0; q < dicWord.length(); q++) {
					
					char dicChar = dicWord.charAt(q);
					char lineChar = lineWord.charAt(q);
					
					if (dicChar == lineChar) {
						String target = lineWord;
						removeTarget(target, tmp);
						wordMap.put(dicWord, target);
						break;
					}
					
					if(q == dicWord.length() - 1) {
						wordMap.put(dicWord, candidate.get(0));
					}
					
				}
				
			}
			
		}
		
		Set<String> set = wordMap.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			
			String key = iter.next();
			String value = wordMap.get(key);
			
			if (value != null) {
				for(int i = 0; i < key.length(); i++) {
					
					char keyC = key.charAt(i);
					char valueC = value.charAt(i);
					
					if (!map.containsKey(keyC) || !map.containsValue(valueC)) {
						map.put(keyC, valueC);
					}
					
					if (!map2.containsKey(valueC) || !map.containsValue(keyC)) {
						map2.put(valueC, keyC);
					}
				}
			}
		}
		
		
		newList.add(map);
		newList.add(map2);
		return newList;
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
		
		if (list.size() == 1) {
			String target = list.get(0);
			removeTarget(target, list);
			return target;
		}
		
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
		
		if(!intersection4.isEmpty()) {
			
			if(intersection4.size() == 1) {
				target = intersection4.get(0);
			} else {
				target = findFirst(intersection4, dict);
			}
			removeTarget(target, list);
			return target;
			
		} else if (!intersection1.isEmpty()) {
			
			if(intersection1.size() == 1) {
				target = intersection1.get(0);
			} else {
				target = findFirst(intersection1, dict);
			}
			removeTarget(target, list);
			return target;
			
		} else if (!intersection2.isEmpty()) {
			
			if(intersection2.size() == 1) {
				target = intersection2.get(0);
			} else {
				target = findFirst(intersection2, dict);
			}
			removeTarget(target, list);
			return target;
			
		} else if (!intersection3.isEmpty()) {
			
			if(intersection3.size() == 1) {
				target = intersection3.get(0);
			} else {
				target = findFirst(intersection3, dict);
			}
			removeTarget(target, list);
			return target;
			
		} else {
			for(int i = 0; i < list.size(); i++) {
				String s = list.get(i);
				if (dict.length() == s.length()) {
					target = s;
					removeTarget(target, list);
					return target;
				}
			}
			//throw new NullPointerException();
			return null;
		}
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
	
	
	private static ArrayList<Map<Character, Character>> mapping(String s) {
		
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

}
