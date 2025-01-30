package w7;

import java.util.*;                                                    

public class Mystery2 {                               
	public static void main(String[] args) {   
		
		ArrayList<Integer> list = new ArrayList<Integer>();                                               
		for (int i = 1; i <= 5; i++) {                                                      
			list.add(2 * i);   // [2, 4, 6, 8, 10]                                     
		}                                                   
		System.out.println(list);                               


		for (int i = list.size(); i > 0; i--) {
			list.add(i, 100);
		}

		System.out.println(list);
	}
}

