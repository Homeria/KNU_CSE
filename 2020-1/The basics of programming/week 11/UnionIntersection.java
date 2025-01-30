package week11;

/**
 * 난수로 채워진 두 개의 배열의 합집함과 교집합을 구하는 프로그램
 * @author 차경호
 *
 */
public class UnionIntersection {

	public static void main(String[] args) {
		
		final int ALENGTH = 10;
		final int BLENGTH = 10;
		final int MAX = 20;
		
		int[] a = new int[ALENGTH];
		int[] b = new int [BLENGTH];
		
		int[] union = new int[ALENGTH + BLENGTH];
		int unionSize;
		
		int[] intersection;
		
		intersection = new int[ALENGTH];
		int intersectionSize;
		
		ArrayUtil.fillRandomDistinct(a,  MAX);
		System.out.print("배열 1 : ");
		ArrayUtil.printArray(a, a.length);
		if(!ArrayUtil.distinct(a,  a.length)) {
			System.out.println("엥? 배열에 중복된 원소가 있네!");
		}
		
		ArrayUtil.fillRandomDistinct(b,  MAX);
		System.out.print("배열 2 : ");
		ArrayUtil.printArray(b, b.length);
		if(!ArrayUtil.distinct(a,  a.length)) {
			System.out.println("엥? 배열에 중복된 원소가 있네!");
		}
		
		unionSize = unionArrays(a, b, union);
		System.out.print("Union : ");
		ArrayUtil.printArray(union, unionSize);
		if(!ArrayUtil.distinct(union,  unionSize)) {
			System.out.println("엥? 배열에 중복된 원소가 있네!");
		}
		
		intersectionSize = intersectionArrays(a, b, intersection);
		System.out.print("Intersection : ");
		ArrayUtil.printArray(intersection, intersectionSize);
		if(!ArrayUtil.distinct(intersection, intersectionSize)) {
			System.out.println("엥? 배열에 중복된 원소가 있네!");
		}
			
		
		
	}
	
	
	/**
	 * 배열 a의 우너소들과 배열 b의 원소들의 합집합을 배열 union에 넣고 합집합의 원소의 수를 반환
	 * 전제조건 : union.length >= a.length + b.length
	 * @param a 배열
	 * @param b 배열
	 * @param union a, b의 합집합
	 * @return 합집합의 원소의 개수
	 */
	public static int unionArrays(int[] a, int[] b, int[] union) {
		int unionSize = 0;
		// a 배열의 원소를 모두 union 배열에 넣기
		for(int i = 0; i < a.length; i++) {
			union[i] = a[i];
			unionSize += 1;
		}
		// b 배열의 원소 중 a 배열에 없는 원소이고, union 배열에 없는 원소만을 union 배열에 넣기
		for(int i = a.length; i < a.length + b.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if ((Search.linearSearch(a, a.length, b[j]) == -1) && (Search.linearSearch(union, i, b[j]) == -1)) {
					union[i] = b[j];
					unionSize += 1;
					break;
				}
			}
		}
		return unionSize;
	}
	
	
	/**
	 * 배열 a의 원소들과 배열 b의 원소들의 교집합을 배열 intersection에 넣고 교집합의 원소의 수를 반환
	 * 전제조건 : intersection.length >= min(a.length, b.length)
	 * @param a 배열
	 * @param b 배열
	 * @param union a, b의 교집합
	 * @return 교집합의 원소의 개수
	 */
	public static int intersectionArrays(int[] a, int[] b, int[] intersection) {
		int intersectionSize = 0;
		// b 배열의 원소 중 a 배열에 있는 원소이고, intersection 배열에 없는 원소만을 intersection 배열에 넣기
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if((Search.linearSearch(a, a.length, b[j]) != -1) && (Search.linearSearch(intersection, i, b[j]) == -1)) {
					intersection[i] = b[j];
					intersectionSize += 1;
					break;
				}
			}
		}
		return intersectionSize;
	}
	
	

}
