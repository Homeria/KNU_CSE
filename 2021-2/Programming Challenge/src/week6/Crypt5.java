package week6;

import java.util.*;

public class Crypt5 {

	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		String cryptedSample = "??i ????? h???? u?? ????? ??i? ??i ???? ??m";
		String sample = "the quick brown fox jumps over the lazy dog";
		
		System.out.println("cryptedSample = " + cryptedSample);
		
		
		//System.out.println(map);
		
		//int wordCount = Integer.parseInt(input.nextLine());
		
		
		int wordCount = 5;
		
		
		String original = "abcdd hijk lmnop qrstuv wxyzz";
		String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs";
		
		
		String[] splitedOriginal = original.split(" ");
		
		
		ArrayList<Map<Character, Character>> list = mapping(cryptedSample);
		
		System.out.println();
		System.out.println("====== list map check =====");
		System.out.println();
		System.out.println("map = " + list.get(0));
		System.out.println("map2 = " + list.get(1));
		System.out.println();
		System.out.println("===== list map check done =====");
		System.out.println();
		
		System.out.println();
		
		System.out.println("========== halfDecrypt Method ==========");
		
		String halfCrypt = halfDecrypt(list.get(0), original);
		System.out.println(halfCrypt);
		
		System.out.println("========== halfDecrypt Method done ==========");
		System.out.println();
		
		String[] splitedHalfCrypt = halfCrypt.split(" ");
		
		list = additionalMapping(list, splitedHalfCrypt, cryptOriginal);
		
		System.out.println("list = " + list);
		
		Map<Character, Character> map = list.get(0);
		
		
		
		
//		System.out.println("========================");
//		for(int i = 0; i < sample.length(); i++) {
//			char c = sample.charAt(i);
//			if (c != ' ') {
//				System.out.print(map.get(c));
//			} else {
//				System.out.print(" ");
//			}
//		}
		
		
		input.close();
	}
	
	private static ArrayList<Map<Character, Character>> additionalMapping(ArrayList<Map<Character, Character>> list, String[] dic, String line) {
		
		Map<String, String> test = new HashMap<String, String>();
		
		List<String> tmp = new ArrayList<String>();
		
		String[] splitedLine = line.split(" ");
		
		for(int i = 0; i < splitedLine.length; i++) {
			tmp.add(splitedLine[i]);
		}
		
		
		
		System.out.println("========== additionalMapping Method ==========");
		
		Map<Character, Character> map = list.get(0);
		Map<Character, Character> map2 = list.get(1);
		
		
		
		for(int i = 0; i < dic.length; i++) {
			String mostSimilary = getMostSimilar(dic[i], tmp);
			test.put(dic[i], mostSimilary);
			System.out.println("set : " + dic[i] + " and " + mostSimilary);
		}
		System.out.println("map = " + test);
		
		
//		for(int i = 0; i < dic.length; i++) {
//			for(int j = 0; j < splitedLine.length; j++) {
//				
//				System.out.println();
//				System.out.println("------------------------------");
//				System.out.println("i = " + i + ", j = " + j);
//				System.out.println("map = " + map);
//				System.out.println("map2 = " + map2);
//				
//				String dicWord = dic[i];
//				String lineWord = splitedLine[j];
//				
//				System.out.println("dicWord = " + dicWord + ", lineWord = " + lineWord);
//				
//				if ((dicWord.length() == lineWord.length()) && (findMaxCount(dicWord) == findMaxCount(lineWord))) {
//					
//					System.out.println("match " + dicWord + " and " + lineWord);
//					
//					System.out.println();
//					
//					for(int p = 0; p < dicWord.length(); p++) {
//						for(int q = 0; q < lineWord.length(); q++) {
//							System.out.println("");
//							System.out.println("p = " + p + ", q = " + q);
//							char dicChar = dicWord.charAt(p);
//							char lineChar = lineWord.charAt(q);
//							
//							System.out.println("dicChar = " + dicChar + ", lineChar = " + lineChar);
//							
//							if(!map.containsKey(dicWord.charAt(p)) && !map.containsValue(lineWord.charAt(q))) {
//								System.out.println("put " + dicChar + " and " + lineChar);
//								map.put(dicChar, lineChar);
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		Set<Character> set = map.keySet();
//		Iterator<Character> iter = set.iterator();
//		
//		while(iter.hasNext()) {
//			Character key = (Character) iter.next();
//			Character value = map.get(key);
//			map2.put(value, key);
//		}
//		
//		list.add(map);
//		list.add(map2);
//		
//		System.out.println("map = " + map);
//		System.out.println("map2 = " + map2);
		
		return list;
	}
	
	private static String halfDecrypt(Map<Character, Character> map, String s) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c != ' ') && map.containsKey(c)) {
				sb.append(map.get(c));
			} else if (c != ' '){
				sb.append(c);
			} else {
				sb.append(" ");
			}
		}
		
		
		return sb.toString();
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
	
	
	private static String getMostSimilar(String dict, List<String> list) {
		
		int[] similarity = new int[list.size()];
		int[] length = new int[list.size()];
		int[] candidateIndex = new int[list.size()];
		
		int similarityMax = 0;
		int dictLength = dict.length();
		
		for(int i = 0; i < candidateIndex.length; i++) {
			candidateIndex[i] = 11;
		}
		
		String target = null;
		
		
		for(int i = 0; i < list.size(); i++) {
			length[i] = list.get(i).length();
			similarity[i] = getSimilarity(dict, list.get(i));
		}
		
		for(int i = 0; i < similarity.length; i++) {
			if (similarity[i] > similarityMax) {
				similarityMax = similarity[i];
			}
		}
		
		System.out.println();
		System.out.print("similarity : [");
		for(int i = 0; i < similarity.length; i++) {
			System.out.print(similarity[i] + " ");
		}
		System.out.println("]");
		
		System.out.print("length : [");
		for(int i = 0; i < length.length; i++) {
			System.out.print(length[i] + " ");
		}
		System.out.println("]");
		System.out.println("dictLength = " + dictLength);
		
		if (isOnly(dict, length)) {
			for(int i = 0; i < length.length; i++) {
				if (dict.length() == length[i]) {
					target = list.get(i);
					list.remove(i);
					return target;
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			if (length[i] == dictLength) {
				if (similarity[i] == similarityMax) {
					System.out.println("candidate word = " + list.get(i));
					for(int j = 0; j < list.get(i).length(); j++) {
						if (dict.charAt(j) == list.get(i).charAt(j)) {
							candidateIndex[i] = j;
						}
					}
				}
			}
		}
		
		System.out.print("candidateIndex : [");
		for(int i = 0; i < candidateIndex.length; i++) {
			System.out.print(candidateIndex[i] + " ");
		}
		System.out.println("]");
		System.out.println();
		
		int candidateIndexMin = list.size();
		int candidateIndexMinIndex = -1;
		for(int i = 0; i < candidateIndex.length; i++) {
			if (candidateIndexMin > candidateIndex[i]) {
				candidateIndexMin = candidateIndex[i];
				candidateIndexMinIndex = i;
			}
		}
		
		System.out.println("candidateIndexMin = " + candidateIndexMin);
		target = list.get(candidateIndexMinIndex);
		list.remove(candidateIndexMinIndex);
		System.out.println("target = " + target);
		System.out.println();
		
		return target;
	}
	
	private static int getFirstCorrectIndex(String s1, String s2) {
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				return i;
			}
		}
		return -1;
	}
	
	private static boolean isOnly(String s1, int[] length) {
		int count = 0;
		for(int i = 0; i < length.length; i++) {
			if (s1.length() == length[i]) {
				count++;
			}
		}
		
		return (count == 1);
	}
	
	private static int getSimilarity(String s1, String s2) {
		System.out.println("getSimilarity : s1 = " + s1 + ", s2 = " + s2);
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
		
		System.out.println("========== Mapping Method ==========");
		System.out.println();
		System.out.println("s = " + s);
		Map<Character, Character> map = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		for(int i = 0; i < s.length(); i++) {
			System.out.println();
			char c = s.charAt(i);
			char sampleC = sample.charAt(i);
			
			System.out.println("i = " + i + ", c = " + c + ", sampleC = " + sampleC);
			
			if ((c != ' ') && (c != '?') && !map.containsKey(c)) {
				System.out.println("put " + sampleC + " and " + c + " : map");
				System.out.println("put " + c + " and " + sampleC + " : map2");
				map.put(sampleC, c);
				map2.put(c, sampleC);
			}
		}
		
		ArrayList<Map<Character, Character>> list = new ArrayList<Map<Character, Character>>();
		list.add(map);
		list.add(map2);
		
		System.out.println("========== Mapping Method done ==========");
		System.out.println();
		return list;
	}

}
