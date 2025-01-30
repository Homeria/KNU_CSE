package week6;

import java.util.*;

public class Crypt29 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		// Input crypted sample
		//String cryptedSample = input.nextLine();
		//String cryptedSample = "??i ????? h???? u?? ????? ??i? ??i ???? ??m";
		String cryptedSample = "??? b???? ????? ??j i??x? ???? ??? ??l? ???";
		//String cryptedSample = "?e? ????? r???? n?? i???? ???? ?e? ???? ???";
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		//String output = "wsm baduo qretf cej iahxg epmr wsm knly vez"
		
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
	
	private static void additionalMapping(List<HashMap<Character, Character>> list, String original, String line) {
		
		List<HashMap<Character, Character>> newList = new ArrayList<HashMap<Character, Character>>();
		HashMap<Character, Character> map = list.get(0);
		HashMap<Character, Character> map2 = list.get(1);
		
		String sample = original;
		String[] sampleArr = sample.split(" ");
		String crypted = line;
		String[] cryptedArr = crypted.split(" ");
		
		Map<String, String> wordMap = new HashMap<String, String>();
		
		List<String> dictTmp;
		List<String> dictList = new ArrayList<String>();
		List<String> lineList = new ArrayList<String>();
		
		for(int i = 0; i < cryptedArr.length; i++) {
			dictList.add(sampleArr[i]);
			lineList.add(cryptedArr[i]);
		}
		
		int count = 0;
		
		while(count <= 2) {
			
			System.out.println("===================================================");
			System.out.println("count = " + (count + 1));
			
			map = list.get(0);
			map2 = list.get(1);
			
			dictTmp = new ArrayList<String>(dictList);
			
			dictTmp = encrypt(map, dictTmp);
			
			System.out.println("dictList = " + dictList);
			System.out.println();
			System.out.println("dictTmp = " + dictTmp);
			System.out.println("lineList = " + lineList);
			
			System.out.println();
			System.out.println("map = " + map);
			System.out.println("map2 = " + map2);
			System.out.println();
			System.out.println("wordMap = " + wordMap);
			//System.out.println("dictList = " + dictList);
			
			
			for(int i = 0; i < dictTmp.size(); i++) {
				
				System.out.println("-------------------------------------");
				
				List<String> sameLength = new ArrayList<String>();
				List<String> okay = new ArrayList<String>();
				List<String> okay2 = new ArrayList<String>();
				String s = dictTmp.get(i);
				String sampleS = dictList.get(i);
				
				System.out.println();
				
				
				System.out.println("s = " + s);
				for(int j = 0; j < lineList.size(); j++) {
					String stringS = lineList.get(j);
					if ((s.length() == stringS.length())) {
						sameLength.add(stringS);
					}
				}
				
				System.out.println("sameLength = " + sameLength);
				
				if(sameLength.size() == 1) {
					System.out.println("sameLength is 1");
					String target = sameLength.get(0);
					wordMap.put(sampleS, target);
					removeTarget(sampleS, dictList);
					removeTarget(s, dictTmp);
					removeTarget(target, lineList);
					additionalMapping2(list, sampleS, target);
					i--;
					
				} else {
					
					for(int j = 0; j < sameLength.size(); j++) {
						String stringS = sameLength.get(j);
						if (isOkay(map, map2, s, stringS)) {
							System.out.println(s + " and " + stringS + " is okay");
							okay.add(stringS);
						}
					}
					
					System.out.println("okay = " + okay);
					
					if(okay.size() == 1) {
						String target = okay.get(0);
						wordMap.put(s, target);
						removeTarget(sampleS, dictList);
						removeTarget(s, dictTmp);
						removeTarget(target, lineList);
						additionalMapping2(list, sampleS, target);
						i--;
					} else if (okay.isEmpty()){
						
					} else {
						for(int j = 0; j < okay.size(); j++) {
							String stringS = okay.get(j);
							if(getDuplicate(s) == getDuplicate(stringS)) {
								okay2.add(stringS);
							}
						}
						
						if (okay2.size() == 1) {
							String target = okay2.get(0);
							wordMap.put(s, target);
							removeTarget(sampleS, dictList);
							removeTarget(s, dictTmp);
							removeTarget(target, lineList);
							additionalMapping2(list, sampleS, target);
							i--;
						}
					}
					
					
					System.out.println("sampleS = " + sampleS);
					
				}
				
				System.out.println("sameLength = " + sameLength);
				
			}
			
			
			count++;
			
		}
		
		newList.add(map);
		newList.add(map2);
		
	}
	
	
	private static boolean isOkay(Map<Character, Character> map, Map<Character, Character> map2, String s1, String s2) {
		
		for(int i = 0; i < s1.length(); i++) {
			
			char sampleC = s1.charAt(i);
			char c = s2.charAt(i);
			
//			System.out.println();
//			System.out.println("map.get(sampleC) = " + map.get(sampleC));
//			System.out.println("map2.get(c) = " + map2.get(c));
//			System.out.println();
			
			if ((map.get(sampleC) != null && map.get(sampleC) != c)
					|| (map2.get(c) != null && map2.get(c) != sampleC)) {
				//System.out.println("false!");
				return false;
				
			}
		}
		
		return true;
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
		
		HashMap<Character, Character> map = list.get(0);
		HashMap<Character, Character> map2 = list.get(1);
		
		for(int i = 0; i < dict.length(); i++) {
			char dictC = dict.charAt(i);
			char lineC = line.charAt(i);
			
			if(!map.containsKey(dictC) && !map.containsValue(lineC)) {
				System.out.println("dictC = " + dictC + ", lineC = " + lineC);
				System.out.println("map " + dictC + " and " + lineC);
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
	
	
	
	private static List<HashMap<Character, Character>> mapping(String s) {
		
		List<HashMap<Character, Character>> list = new ArrayList<HashMap<Character, Character>>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		
		String sample = "the quick brown fox jumps over the lazy dog";
		
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char sampleC = sample.charAt(i);
			if ((c != ' ') && (c != '?') && !map.containsKey(sampleC)) {
				
				map.put(sampleC, c);
				map2.put(c, sampleC);
			}
		}
		
		list.add(map);
		list.add(map2);
		
		return list;
	}
	
}
