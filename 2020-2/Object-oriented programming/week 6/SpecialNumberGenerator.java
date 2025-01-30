package w6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SpecialNumberGenerator {

	
	/**
	 * 첫 n개의 소수를 찾아낸다. n은 1 이상이어야 한다.
	 * @param n 주어진 갯수. (n >= 1)
	 * @return 찾은 소수들이 들어 있는 Collection.
	 */
	public static Collection<Long> getPrimes (int n) {
		List<Long> list = new ArrayList<>();
		list.add(2L);
		for(int i = 0; i < n - 1; i++) {
			list.add(getNextPrime(list));
		}
		return list;
	}
	
	
	/**
	 * 이미 찾은 소수들이 주어졌을 때 그 다움 소수를 찾는다.
	 * @param primes 이미 찾은 소수들의 들어 있는 리스트
	 * @return 찾은 다음 소수.
	 */
	private static long getNextPrime(List<Long> primes) {
		long prime = primes.get(primes.size() - 1) + 1;
		int count;
		while (true) {
			count = 0;
			for(long a : primes) {
				if((prime % a) == 0) {
					prime++;
					break;
				} else {
					count++;
				}
			}
			if (count == primes.size()) {
				return prime;
			}
		}
	}
	
	
	
	/**
	 * 첫 n개의 못난이수를 찾아낸다. n은 1 이상이어야 한다.
	 * @param n 주어진 갯수. (n >= 1)
	 * @return 찾은 못난이수들이 들어 있는 Collection.
	 */
	public static Collection<Long> getUglies (int n) {
		SortedSet<Long> set = new TreeSet<>();
		SortedSet<Long> testSet = new TreeSet<>();
		long[] countList = {2L, 3L, 5L};
		set.add(1L);
		long count = 1L;
		while (true) {
			for(long a : countList) {
				if (set.size() == n) {
					return set;
				} else {
					set.add(count * a);
				}
			}
			testSet = new TreeSet<>(set.tailSet(count));
			testSet.remove(count);
			count = testSet.first();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		List<Long> list = new ArrayList<Long>(getPrimes(500));
		ListIterator<Long> iter = list.listIterator(list.size());
		for(int i = 0; i < 10; i++) {
			System.out.println(iter.previous());
		}
		
		System.out.println("");
		
		
		Collection<Long> set = getUglies(20);
		System.out.println("못난이수 : " + set);
		
		
		System.out.println("");
		set = getUglies(130);
		System.out.println("소수 : " + list);
		System.out.println("못난이수 : " + set);
		
		
		System.out.println("");
		
		
		List<Long> intersection = new ArrayList<>(list);
		intersection.retainAll(set);
		System.out.println("Intersection : " + intersection);
		
		
		System.out.println("");
		
		
		SortedSet<Long> union = new TreeSet<>(set);
		union.addAll(list);
		System.out.println("union : " + union);
		
		
		System.out.println("");
		
		
		List<Long> unionList = new ArrayList<>(union);
		ListIterator<Long> iter2 = unionList.listIterator();
		System.out.print("Union의 앞 20개 수 : ");
		for(int i = 0; i < 20; i++) {
			System.out.print(iter2.next() + " ");
		}
		
		
		System.out.println("");
		
		
		System.out.print("Union의 뒤 10개 수 : ");
		iter2 = unionList.listIterator(unionList.size() - 10);
		for(int i = 0; i < 10; i++) {
			System.out.print(iter2.next() + " ");
		}
		
		
		
	}

}
