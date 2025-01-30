package week6;

import java.util.*;

public class Crypt25 {

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
		
		
		// Input crypted statement
		//String cryptOriginal = input.nextLine();
		//String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs";
		String cryptOriginal = "creh wsnw tdws wsmy teakv nqeaw zeev qmunagm mpmf hnom";
		//String cryptOriginal = "phqggeaylnofdxjkrcvstzwbb";
		//String cryptOriginal = "abc dfgh jklm opqstt uvwxyz";
		//String cryptOriginal = "tzwbb nofdx phqgg eayl jkrcvs tzwbb nofdx phqgg eayl jkrcvs";
		
		
		// Mapping not crypted statement
		List<HashMap<Character, Character>> list = mapping(cryptedSample);
		
		Map<Character, Character> map = list.get(0);
		
		
		System.out.println("map = " + map);
		
		
		// Additional mapping
		additionalMapping(list, original, cryptOriginal);
		
		System.out.println("additonal Mapping = " + list);
		
//		for(int i = 0; i < sample.length(); i++) {
//			char c = sample.charAt(i);
//			if (c != ' ') {
//				System.out.print(map.get(c));
//			} else if (c == ' ') {
//				System.out.print(' ');
//			} else {
//				System.out.print(c);
//				//throw new NullPointerException();
//			}
//		}
		
		
		input.close();
	}
	
	private static void additionalMapping(List<HashMap<Character, Character>> list, String original, String line) {
		
		List<HashMap<Character, Character>> newList = new ArrayList<HashMap<Character, Character>>();
		HashMap<Character, Character> map = list.get(0);
		HashMap<Character, Character> map2 = list.get(1);
		
		String sample = original;
		String[] sampleArr = sample.split(" ");
		String crypted = line;
		String[] cryptedArr = crypted.split(" ");
		
		Map<String, String> wordMap = new HashMap<String, String>();
		
		List<String> dictTmp = new ArrayList<String>();
		List<String> dictList = new ArrayList<String>();
		List<String> lineList = new ArrayList<String>();
		
		for(int i = 0; i < cryptedArr.length; i++) {
			dictList.add(sampleArr[i]);
			dictTmp.add(sampleArr[i]);
			lineList.add(cryptedArr[i]);
		}
		
		int count = 0;
		
		while(count != 8) {
			
			System.out.println("===================================================");
			System.out.println("count = " + (count + 1));
			
			map = list.get(0);
			map2 = list.get(1);
			
			dictList = encrypt(map, dictList);
			System.out.println("dictList = " + dictList);
			System.out.println("lineList = " + lineList);
			//System.out.println("dictList = " + dictList);
			
			for(int i = 0; i < dictList.size(); i++) {
				System.out.println();
				String dictS = dictList.get(i);
				
				List<String> sameLength = getSameLengthE(lineList, dictS);
				
				System.out.println("dictS = " + dictS + ", sameLength = " + sameLength);
				System.out.println("map = " + map);
				System.out.println("map2 = " + map2);
				
				
				if (sameLength.size() == 1) {
					wordMap.put(dictS, sameLength.get(0));
					removeTarget(dictS, dictList);
					removeTarget(sameLength.get(0), lineList);
					additionalMapping2(list, dictS, sameLength.get(0));
				} else {
					
					List<String> okay = new ArrayList<String>();
					
					for(int j = 0; j < sameLength.size(); j++) {
						String lengthS = sameLength.get(j);
						System.out.println("lengthS = " + lengthS);
						if (isOkay(dictS, lengthS) 
								&& (getDuplicate(dictS) == getDuplicate(lengthS))
								&& (getFirstIndex(dictS, getDuplicateChar(dictS)) == (getFirstIndex(lengthS, getDuplicateChar(lengthS))))
								&& (getLastIndex(dictS, getDuplicateChar(dictS)) == (getLastIndex(lengthS, getDuplicateChar(lengthS))))
								) {
							okay.add(lengthS);
						}
					}
					
					System.out.println("okay = " + okay);
					
					if (okay.size() == 1) {
						wordMap.put(dictS, okay.get(0));
						removeTarget(dictS, dictList);
						removeTarget(okay.get(0), lineList);
						additionalMapping2(list, dictS, okay.get(0));
						
					} else if (okay.isEmpty()){
						
						List<String> halfOkay = new ArrayList<String>();
						
						System.out.println("okay empty");
						for(int j = 0; j < sameLength.size(); j++) {
							String lengthS = sameLength.get(j);
							System.out.println("lengthS = " + lengthS);
							if ((getDuplicate(dictS) == getDuplicate(lengthS))
									&& (getFirstIndex(dictS, getDuplicateChar(dictS)) == (getFirstIndex(lengthS, getDuplicateChar(lengthS))))
									&& (getLastIndex(dictS, getDuplicateChar(dictS)) == (getLastIndex(lengthS, getDuplicateChar(lengthS))))
									) {
								halfOkay.add(lengthS);
							}
						}
						
						if(halfOkay.size() == 1) {
							wordMap.put(dictS, halfOkay.get(0));
							removeTarget(dictS, dictList);
							removeTarget(halfOkay.get(0), lineList);
							additionalMapping2(list, dictS, halfOkay.get(0));
						} else {
							
						}
						
						
					}
					
					
				}
				
			}
			count++;
			System.out.println("wordMap = " + wordMap);
		}
		
		newList.add(map);
		newList.add(map2);
		
	}
	
	
	private static char getDuplicateChar(String s) {
		
		int[] cnt = new int[26];
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 97]++;
		}
		
		printArray(cnt);
		
		for(int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				index = i;
			}
		}
		
		System.out.println("getDuplicateChar  = " + ((char)(index + 97)));
		return ((char)(index + 97));
	}
	
	private static int getFirstIndex(String s1, char c) {
		
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == c) {
				System.out.println("getFirstIndex = " + i);
				return i;
			}
		}
		System.out.println("getFirstIndex = -1");
		return -1;
	}
	
	private static int getLastIndex(String s1, char c) {
		
		int cnt = 0;
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == c) {
				cnt = i;
			}
		}
		System.out.println("getLastIndex = " + cnt);
		return cnt;
		
		
	}
	
	
	private static boolean isOkay(String s1, String s2) {
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	private static int getDuplicate(String s1) {
		
		int[] cnt = new int[26];
		
		int max = 0;
		
		for(int i = 0; i < s1.length(); i++) {
			cnt[s1.charAt(i) - 97]++;
		}
		
		for(int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
			}
		}
		
		return max;
		
	}
	
	private static void additionalMapping2(List<HashMap<Character, Character>> list, String dict, String line) {
		List<HashMap<Character, Character>> newList = new ArrayList<HashMap<Character, Character>>();
		
		HashMap<Character, Character> map = list.get(0);
		HashMap<Character, Character> map2 = list.get(1);
		
		for(int i = 0; i < dict.length(); i++) {
			char dictC = dict.charAt(i);
			char lineC = line.charAt(i);
			
			if(!map.containsKey(dictC) && !map.containsValue(lineC)) {
				System.out.println("dictC = " + dictC + ", lineC = " + lineC);
				map.put(dictC, lineC);
				map2.put(lineC, dictC);
			}
		}
	}
	
	private static void removeTarget(String target, List<String> list) {
		
		for(int i = 0; i < list.size(); i++) {
			if (target.equals(list.get(i))) {
				list.remove(i);
				break;
			}
		}
	}
	
	
	private static boolean isSame(List<String> list1, List<String> list2) {
		for(int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	
	private static List<String> getSameLengthE(List<String> list, String s) {
		
		List<String> newList = new ArrayList<String>();
		int sLength = s.length();
		
		
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).length() == sLength) {
				newList.add(list.get(i));
			}
		}
		
		return newList;
		
		
	}
	
	
	private static List<String> encrypt(Map<Character, Character> map, List<String> list) {
		
		List<String> newList = new ArrayList<String>();
		
		StringBuilder sb;
		
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			sb = new StringBuilder();
			for(int j = 0; j < s.length(); j++) {
				char sC = s.charAt(j);
				if (sC != ' ') {
					if (map.containsKey(sC)) {
						sb.append(map.get(sC));
					} else {
						sb.append(sC);
					}
				} else {
					sb.append(' ');
				}
			}
			newList.add(sb.toString());
		}
		return newList;
		
		
	}
	
	private static int getLongestLength(String[] arr) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i].length() > max) {
				max = arr[i].length();
			}
		}
		return max;
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
	
	
	
	private static List<HashMap<Character, Character>> mapping(String s) {
		
		List<HashMap<Character, Character>> list = new ArrayList<HashMap<Character, Character>>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char sampleC = sample.charAt(i);
			
			if ((c != ' ') && (c != '?') && !map.containsKey(c)) {
				
				map.put(sampleC, c);
				map2.put(c, sampleC);
			}
		}
		
		list.add(map);
		list.add(map2);
		
		return list;
	}
	
}
