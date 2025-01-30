package week6;

import java.util.*;

public class Crypt12 {

	
	
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
		//String original = "gdy zalv spmx onwrkk ciuqet";
		
		//String cryptOriginal = input.nextLine();
		String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs";
		//String cryptOriginal = "abc dfgh jklm opqstt uvwxyz";
		
		
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
				System.out.print(map.get(c));
			} else if (c == ' '){
				System.out.print(' ');
			} else {
				System.out.print("*");
			}
		}
		
		
		input.close();
	}
	
	private static ArrayList<Map<Character, Character>> additionalMapping(ArrayList<Map<Character, Character>> list, String[] dic, String line) {
		
		Map<String, String> wordMap = new HashMap<String, String>();
		
		String[] splitedLine = line.split(" ");
		
		List<String> tmp = new ArrayList<String>();
		
		for(int i = 0; i < splitedLine.length; i++) {
			tmp.add(splitedLine[i]);
		}
		
		Map<Character, Character> map = list.get(0);
		Map<Character, Character> map2 = list.get(1);
		
		
		for(int i = 0; i < dic.length; i++) {
			String mostSimilary = getMostSimilar(dic[i], tmp);
			if (mostSimilary != null) {
				wordMap.put(dic[i], mostSimilary);
			}
			
		}
		
		System.out.println("wordMap = " + wordMap);
		System.out.println("tmp = " + tmp);
		
		Set<String> set = wordMap.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			
			String key = iter.next();
			String value = wordMap.get(key);
			
			if (value != null) {
				for(int i = 0; i < key.length(); i++) {
					
					char keyC = key.charAt(i);
					char valueC = value.charAt(i);
					
					if (!map.containsKey(keyC) && !map.containsValue(valueC)) {
						map.put(keyC, valueC);
					}
					
					if (!map2.containsKey(valueC) && !map.containsValue(keyC)) {
						map2.put(valueC, keyC);
					}
				}
			}
			
			
		}
		
		ArrayList<Map<Character, Character>> newList = new ArrayList<Map<Character, Character>>();
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
			} else {
				sb.append(" ");
			}
		}
		
		
		return sb.toString();
	}
	
	
	private static String getMostSimilar(String dict, List<String> list) {
		
		System.out.println();
		System.out.println("==================== getMostSimilar Method ====================");
		
		if(list.size() == 1) {
			return list.get(0);
		}
		
		int[] similarity = new int[list.size()];
		int[] length = new int[list.size()];
		int[] maxCount = new int[list.size()];
		
		int dictMaxCount = findMaxCount(dict);
		
		List<String> candidate = new ArrayList<String>();
		
		String target = null;
		
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			length[i] = s.length();
			similarity[i] = getSimilarity(dict, s);
			maxCount[i] = findMaxCount(s);
		}
		
		if (isOnly(dict, length)) {
			System.out.println("\"" + dict + "\"" + " is only!");
			int index = getIndex(dict.length(), length);
			target = list.get(index);
			removeTarget(target, list);
			return target;
		}
		
		
		if(allZero(similarity)) {
			
			for(int i = 0; i < list.size(); i++) {
				String s = list.get(i);
				if (maxCount[i] == dictMaxCount) {
					if (s.length() == length[i]) {
						target = s;
						removeTarget(target, list);
						return target;
					}
				}
			}
			 
			
		} else {
			int similarityMax = getMax(similarity);
			
			for(int i = 0; i < length.length; i++) {
				String s = list.get(i);
				
				if(s.length() == dict.length()) {
					if(maxCount[i] == dictMaxCount) {
						if(similarityMax == similarity[i]) {
							candidate.add(s);
						}
					}
				}
			}
		}
		
		
		System.out.println("candidate = " + candidate);
		
		if(candidate.size() == 0) {
			return null;
		}
		
		if(candidate.size() == 1) {
			target = candidate.get(0);
			removeTarget(target, list);
			
		} else {
			target = candidate.get(compareCandidate(candidate, dict));
			removeTarget(target, list);
		}
		
		System.out.println("===============================================================");
		System.out.println();
		
		return target;
	}
	
	private static int getCountMax(int[] similarity, String dict, List<String> list) {
		
		int max = -1;
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (dict.length() == s.length()) {
				if (similarity[i] > max) {
					max = similarity[i];
				}
			}
		}
		
		return max;
	}
	
	private static boolean allZero(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	private static int compareCandidate(List<String> list, String dict) {
		
		int index = 0;
		int min = 100;
		
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			for(int j = 0; j < s.length(); j++) {
				if(dict.charAt(j) == s.charAt(j)) {
					if (j < min) {
						min = j;
						index = i;
					}
				}
			}
		}
		
		return index;
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
	
	private static boolean isOnly(String s1, int[] length) {
		int count = 0;
		for(int i = 0; i < length.length; i++) {
			if (s1.length() == length[i]) {
				count++;
			}
		}
		return (count == 1);
	}
	
	private static void removeTarget(String s, List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			if(s.equals(list.get(i))) {
				list.remove(i);
				break;
			}
		}
	}
	
	private static int getMax(int[] arr) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	private static int getIndex(int n, int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if (n == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	private static boolean exist(int n, int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if (n == arr[i]) {
				return true;
			}
		}
		return false;
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
		
		System.out.println();
		System.out.println("==================== mapping Method ====================");
		
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		for(int i = 0; i < s.length(); i++) {
			System.out.println("i = " + i);
			char c = s.charAt(i);
			char sampleC = sample.charAt(i);
			
			System.out.println("c = " + c + ", sampleC = " + sampleC);
			
			if ((c != ' ') && (c != '?') && !map.containsKey(c)) {
				
				System.out.println("***** match " + c + " and " + sampleC + " ******");
				
				map.put(sampleC, c);
				map2.put(c, sampleC);
			}
		}
		
		ArrayList<Map<Character, Character>> list = new ArrayList<Map<Character, Character>>();
		list.add(map);
		list.add(map2);
		
		System.out.println("========================================================");
		System.out.println();
		
		return list;
	}

}
