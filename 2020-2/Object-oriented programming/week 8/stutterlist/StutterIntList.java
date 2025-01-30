package w8.stutterlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class StutterIntList extends ArrayIntList {

	// "stretch factor(반복도)" - 원소를 추가할 때 몇 개씩이나 추가되게 할 것인가?
	private int stretch;
	
	/**
	 * 구성자.
	 * 주어진 stretch factor와 주어진 용량을 갖는 리스트를 구성한다.
	 * @param stretch 반복도. {@literal stretch >= 0}.
	 * @param capacity 용량(배열의 크기). {@literal capacity >= 0}.
	 */
	public StutterIntList(int stretch, int capacity) {
		super(capacity);
		if (stretch < 0) {
			throw new IllegalArgumentException("반복도는 음수일 수 없습니다 : " + stretch);
		}
		this.stretch = stretch;
	}

	
	/**
	 * 구성자
	 * 주어진 stretch factor를 갖는 기본 용량의 리스트를 구성한다.
	 * @param stretch 반복도. {@literal stretch >= 0}.
	 */
	public StutterIntList(int stretch) {
		this(stretch, DEFAULT_CAPACITY);
	}
	
	
	/**
	 * 주어진 값을 주어진 위치에 추가하되 stretch factor 수 만큼 추가한다.
	 */
	@Override
	public void add(int index, int value) {
		for (int i = 1; i <= stretch; i++) {
			super.add(index, value);
		}
	}
	
	/**
	 * 주어진 값을 리스트에 추가하되 stretch factor 수 만큼 추가한
	 */
	public void add(int value) {
		add(size, value);
	}
	
	
	/**
	 * 이 StutterIntList의 stretch factor를 반환한다.
	 * @return stretch factor.
	 */
	public int getStretch() {
		return stretch;
	}
	
	
	/**
	 * 주어진 값이 이 리스트에 몇 개나 들어 있는지 알아낸다.
	 * @param value 주어진 값.
	 * @return 리스트에 value가 몇 개나 들어 있나?
	 */
	public int count(int value) {
		int number = 0;
		for (int i = 0; i < size; i++) {
			if (element[i] == value) {
				number++;
			}
		}
		return number;
	}
	
	
	/**
	 * 이 리스트에 들어 있는 각 값이 각각 몇 개씩이나 들어 있는지 알려준다.
	 * @return 리스트에 value가 몇 개나 들어 있나?
	 */
	public Map<Integer, Integer> counts() {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		
		for(int num : element) {
			set.add(num);
		}		
		
		Iterator<Integer> iter = set.iterator();
		int num, count;
		while(iter.hasNext()) {
			num = (int) iter.next();
			count = count(num);
			if (num != 0) {
				map.put(num, count);
			}
			
		}
		
		return map;
	}
	
	
	
}
