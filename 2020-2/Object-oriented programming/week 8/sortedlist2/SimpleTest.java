package w8.sortedlist2;

public class SimpleTest {

	public static void main(String[] args) {
		System.out.println("네 개의 구성자 테스트----------------");
		
		SortedIntList sortedIntList;
		
		try {
			sortedIntList = new SortedIntList(true, -1);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			sortedIntList = new SortedIntList(true, 10);
			System.out.println(sortedIntList);
			sortedIntList = new SortedIntList(-1);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		sortedIntList = new SortedIntList(10);
		System.out.println(sortedIntList);
		
		
		System.out.println("");
		
		
		System.out.println("초기 용량이 5인 SortedIntList");
		sortedIntList = new SortedIntList(5);
		System.out.println("add(value) 테스트 - 정렬, 용량 자동 증가 확인");
		System.out.println("33, 12, -9, 1024, 1024, 1024를 차례로 add");
		
		int[] array = {33, 12, -9, 1024, 1024, 1024};
		for(int a : array) {
			sortedIntList.add(a);
		}
		System.out.println(sortedIntList);
		
		
		System.out.println("add(index, value) 테스트 ------------");
		try {
			sortedIntList.add(0, 1);
		}
		catch (UnsupportedOperationException e){
			System.out.println("UnsupportedOperationException이 던져졌습니다.");
		}
		
		
		System.out.println("");
		
		
		System.out.println("remove(index) 테스트 --- 1번방 삭제");
		sortedIntList.remove(1);
		System.out.println(sortedIntList);
		System.out.println("indexOf(value) 테스트 --------");
		System.out.println("33의 인덱스 = " + sortedIntList.indexOf(33));
		System.out.println("contains(value) 테스트 -------");
		System.out.println("33을 포함하나? " + sortedIntList.contains(33));
		System.out.println("333을 포함하나? " + sortedIntList.contains(333));
		System.out.println("max() 테스트--------");
		System.out.println("최대값 : " + sortedIntList.max());
		System.out.println("min() 테스트--------");
		System.out.println("최소값 : " + sortedIntList.min());
		
		
		System.out.println("");
		
		
		System.out.println("2단계 구현 테스트 ===============");
		System.out.println("중복금지가 true이고 용량이 5인 리스트 구성");
		sortedIntList = new SortedIntList(true, 5);
		System.out.println(sortedIntList);
		
		System.out.println("add(value) 테스트 - 정렬, 중복금지 확인");
		System.out.println("33, 12, -9, 1024, 1024, 1024를 차례로 add");
		for(int a : array) {
			sortedIntList.add(a);
		}
		System.out.println(sortedIntList);
		
		
		
		
	}
	
	
	
}
