package w6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CollectionsExercise {

	public static void main(String[] args) {
		
		final int N = 100;
		final int MAX = 10;
		
		Random random = new Random();
		
		System.out.println("N(난수 발생 갯수) = " + N);
		System.out.println("MAX(난수 최대값 + 1) = " + MAX);

		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			list.add(random.nextInt(MAX));
		}
		Iterator<Integer> iter = list.iterator();
		System.out.println("list");
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		System.out.println("list - 오름차순으로 정렬된 난수");
		Collections.sort(list);
		iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		System.out.println("set - 중복을 제거한 난수 집합");
		Set<Integer> set = new HashSet<>(list);
		iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		System.out.println("list의 각 숫자가 몇 번이나 중복되었는가?");
		System.out.println("map - 숫자:중복도");
		Map<Integer, Integer> map = new HashMap<>();
		int count;
		for(int i = 0; i < MAX; i++) {
			count = 0;
			for(int j = 0; j < N; j++) {
				if(list.get(j).equals(i)) {
					count++;
				}
			}
			if(count > 0) {
				map.put(i, count);
			}
		}
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			Integer value = map.get(key);
			System.out.println(key + ":" + value);
		}
		
		
		System.out.println("중복도 도수분포");
		int num = 0;
		int[] countArray = new int[N];
		for(Integer key : keys) {
			Integer value = map.get(key);
			countArray[value]++;
			if(value > num) {
				num = value;
			}
		}
		for(int i = 1; i <= num; i++) {
			System.out.println(i + "중복 : " + countArray[i] + "개");
		}
		
		
		
	}
}
		
		
		
		
		


