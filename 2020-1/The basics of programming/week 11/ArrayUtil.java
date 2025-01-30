package week11;

/**
 * 여러 어플리케이션에서 많이 쓰이는 배열 조작 메소드를 모아놓은 프로그램
 * 이 내에 있는 메소드 목록
 * fillRandom(중복 허용하여 배열에 난수를 채워줌), distinct(배열의 원소들의 중복 여부 검사),
 * fillRandomDistinct(중복 없이 배열에 난수를 채워줌), makeRandomArray(중복 허용하여 배열에 난수 채운 후 채운 배열 반환)
 * @author 차경호
 *
 */
public class ArrayUtil {

	public static void main(String[] args) {
		
		System.out.println("printArray 메소드 테스트 ----------");
		
		int[] a = new int[10];
		for(int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		 
		System.out.print("printArray(a, 0) : ");
		printArray(a, 0);
		
		System.out.print("printArray(a, 1) : ");
		printArray(a, 1);
		
		System.out.print("printArray(a, a.length) : ");
		printArray(a, a.length);
		
		System.out.print("printArray(a, a.length + 1) : ");
		printArray(a, a.length + 1);
		
		System.out.print("printArray(a, -1) : ");
		printArray(a, -1);
		
		System.out.println("");
		
		
		System.out.println("fillRandom 메소드 테스트 ----------");
		
		System.out.print("fillRandom(a, 10) : ");
		fillRandom(a, 10);
		printArray(a, 10);
		
		System.out.print("fillRandom(a, 100) : ");
		fillRandom(a, 100);
		printArray(a, 10);
		
		System.out.print("fillRandom(a, 2) : ");
		fillRandom(a, 2);
		printArray(a, 10);
		
		System.out.print("fillRandom(a, 1) : ");
		fillRandom(a, 1);
		printArray(a, 10);
		
		System.out.println("");
		
		
		System.out.println("distinct 메소드 테스트 ----------");
		
		int[] a2 = {1, 1, 2};
		System.out.println("a2 = {1, 1, 2}");
		System.out.println("distinct(a2, 1) : " + distinct(a2, 1));
		System.out.println("distinct(a2, 2) : " + distinct(a2, 2));
		System.out.println("distinct(a2, a2.length) : " + distinct(a2, a2.length));
		System.out.println("distinct(a2, a2.length + 1) : " + distinct(a2, a2.length + 1));
		System.out.println("distinct(a2, 0) : " + distinct(a2, 0));
		System.out.println("distinct(a2, -1) : " + distinct(a2, -1));
		
		int[] a3 = {1, 2, 3};
		System.out.println("a3 = {1, 2, 3}");
		System.out.println("distinct(a3, a3.length) : " + distinct(a3, a3.length));
		System.out.println("distinct(a3, a3.length + 1) : " + distinct(a3, a3.length + 1));
		
		int[] a4 = {1};
		System.out.println("a4 = {1}");
		System.out.println("distinct(a4, a4.length) : " + distinct(a4, a4.length));
		System.out.println("distinct(a4, a4.length + 1) : " + distinct(a4, a4.length + 1));
		
		int[] a5 = {};
		System.out.println("a5 = {}");
		System.out.println("distinct(a5, a5.length) : " + distinct(a5, a5.length));
		System.out.println("distinct(a5, a5.length + 1) : " + distinct(a5, a5.length + 1));
		
		System.out.println("");
		
		
		System.out.println("fillRandomDistinct 메소드 테스트 ----------");
		
		System.out.println("크기가 10인 배열 a");
		System.out.print("fillRandomDistinct(a, 10) : ");
		fillRandomDistinct(a, 10);
		printArray(a, a.length);
		System.out.println("distinct? : " + distinct(a, a.length));
		
		System.out.print("fillRandomDistinct(a, 100) : ");
		fillRandomDistinct(a, 100);
		printArray(a, a.length);
		System.out.println("distinct? : " + distinct(a, a.length));
		
		System.out.print("fillRandomDistinct(a, 1) : ");
		fillRandomDistinct(a, 1);
		printArray(a, a.length);
		System.out.println("distinct? : " + distinct(a, a.length));
		
		System.out.print("fillRandomDistinct(a, 0) : ");
		fillRandomDistinct(a, 0);
		printArray(a, a.length);
		System.out.println("distinct? : " + distinct(a, a.length));
		
		System.out.print("fillRandomDistinct(a, -1) : ");
		fillRandomDistinct(a, -1);
		printArray(a, a.length);
		System.out.println("distinct? : " + distinct(a, a.length));
		
		int[] a6 = new int[1];
		System.out.println("크기가 1인 배열 a6");
		System.out.print("fillRandomDistinct(a6, 1) : ");
		fillRandomDistinct(a6, 1);
		printArray(a6, a6.length);
		System.out.println("distinct? : " + distinct(a6, a6.length));
		
		int[] a7 = new int[0];
		System.out.println("크기가 0인 배열 a7");
		System.out.print("fillRandomDistinct(a7, 7) : ");
		fillRandomDistinct(a7, 7);
		printArray(a7, a7.length);
		System.out.println("distinct? : " + distinct(a7, a7.length));
		
		System.out.println("");
		
		
		System.out.println("makeRandomArray 메소드 테스트 ----------");
		
		System.out.print("makeRandomArray(10, 10) : ");
		printArray(makeRandomArray(10, 10), 10);
		
		System.out.print("makeRandomArray(10, 1) : ");
		printArray(makeRandomArray(10, 1), 10);
		
		System.out.print("makeRandomArray(1, 10) : ");
		printArray(makeRandomArray(1, 10), 1);
		
		System.out.print("makeRandomArray(1, 0) : ");
		printArray(makeRandomArray(1, 0), 1);
		
		System.out.print("makeRandomArray(0, 0) : ");
		printArray(makeRandomArray(0, 0), 1);
		
		System.out.print("makeRandomArray(-1, 0) : ");
		printArray(makeRandomArray(-1, 0), 1);
		
		
		
	}
	
	
	/**
	 * 배열의 앞에 있는 n개의 원소들을 출력하고 마지막에 new line을 출력한다.
	 * n > a.length 인 경우에는 a.length 개의 원소를 출력한다.
	 * n이 0 이하인 경우에는 아무 것도 출력하지 않는다.
	 * @param a 배열
	 * @param n 출력할 원소의 개수
	 */
	public static void printArray(int[] a, int n) {
		if (n > a.length) {
			n = a.length;
		}
		for(int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	
	/**
	 * 배열 list에 0 이상 uBound (Upper Bound) 미만 정수 난수를 채워준다. 난수는 중복될 수 있다.
	 * uBound가 1 이하인 경우에는 0을 채운다.
	 * @param list 난수를 채울 배열
	 * @param uBound 난수의 최대값 + 1
	 */
	public static void fillRandom(int[] list, int uBound) {
		for(int i = 0; i < list.length; i++) {
			if(uBound > 1) {
				list[i] = (int)(Math.random() * uBound);
			} else {
				list[i] = 0;
			}
			
		}
	}
	
	
	/**
	 * 배열의 앞 n개 방(0번부터 n-1번)의 원소들이 서로 다른지 검사한다.
	 * 원소들이 서로 다른가?
	 * n > a.length 일 때는 n == a.length 일 때와 똑같이 작동한다.
	 * @param a 배열
	 * @param n 배열의 앞 몇개 방에 중복 여부 검사를 할 것인가?
	 * @return true, 배열의 앞 n개 원소들이 모두 다른 경우
	 * 			false, 배열의 앞 n개 방에 중복된 원소가 있는 경우
	 */
	public static boolean distinct(int[] a, int n) {
		if (n > a.length) {
			n = a.length;
		}
		int count = n - 1;
		while(count > 0) {
			if(Search.linearSearch(a, count, a[count]) != -1) {
				return false;
			} else {
				count -= 1;
			}
		}
		return true;
	}
	
	
	/**
	 * 배열 list에 0 이상 uBound 미만 "서로 다른" 정수 난수를 채워준다.
	 * 이 메소드를 호출하는 자는 아래 전제조건을 지켜야 한다.
	 * 전제조건 : uBound >= list.length
	 * 이 메소드를 호출하는 자가 위 전제조건을 지키지 않으면 배열을 난수로 채우지 않고 에러 메세지를 출력하고 리턴한다.
	 * @param list 난수를 채울 배열
	 * @param uBound 난수의 최대값 + 1
	 */
	public static void fillRandomDistinct(int[] list, int uBound) {
		int n;
		int count = 0;
		if(uBound >= list.length) {
			while (count < list.length) {
				n = (int)(Math.random() * uBound);
				if(Search.linearSearch(list, count, n) == -1) {
					list[count] = n;
					count += 1;
				}
			}
		} else {
			System.out.println("uBound >= list.length이어야 합니다. 배열의 내용이 변하지 않았습니다.");
		}
	}
	
	
	
	/**
	 * 0 이상 uBound 미만 정수 난수를 n번 발생시켜 이들을 배열에 저장한 후
	 * 배열을 가리키는 참조변수를 반환한다.
	 * 배열에는 같은 숫자가 중복될 수 있다.
	 * @param n 난수 갯수, 배열의 크기 (n이 음수이면 에러 메세지를 출력하고 null을 반환한다.)
	 * @param uBound 난수의 최대값 + 1
	 * @return
	 */
	public static int[] makeRandomArray(int n, int uBound) {
		if (n >= 0) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = (int)(Math.random() * uBound);
			}
			return a;
		} else {
			System.out.println("배열의 크기는 음수일 수 없습니다.");
			return null;
		}
	}

	
	
	
	
	
	

}
