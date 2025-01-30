package week6;

import java.util.*;

public class second4 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		StringBuilder sb;
		
		List<String> list;
		
		boolean first = true;
		
		while(input.hasNextLine()) {
			
			sb = new StringBuilder();
			
			list = new ArrayList<String>();
			
			String line = input.nextLine();
			
			String[] splited = line.split(" ");
			
			int size = Integer.parseInt(splited[0]);
			
			if (size > 1) {
				for(int i = 2; i <= size; i++) {
					
					System.out.println("splited[i - 1] = " + splited[i - 1] + ", splited[i]" + splited[i]);
					
					if(first) {
						sb.append(splited[i - 1] + " ");
						sb.append(splited[i] + " ");
						//System.out.print(splited[i] + " ");
						list.add(splited[i]);
						first = false;
						
					} else {
						
						if(isOkay(list, splited[i - 1], splited[i])) {
							System.out.println("is Okay");
							if (!isDuplicate(list, splited[i])) {
								
								System.out.println("is not duplicate");
								sb.append(splited[i]);
								//System.out.print(splited[i]);
								
								if(i != size) {
									sb.append(" ");
									//System.out.print(" ");
								}
								list.add(splited[i]);
							} else {
								System.out.println("is duplicate");
								break;
							}
							
						} else {
							System.out.println("is not okay");
							System.out.println();
							break;
						}
					}
					
					
				}
				
				System.out.println("sb = " + sb.toString());
				
			} else {
				System.out.println(splited[1]);
			}
			
			
			
			
			
		}
		
		
		input.close();
		
		
		
	}
	
	
	private static boolean isOkay(List<String> list, String s1, String s2) {
		
//		System.out.println("list = " + list);
//		System.out.println("s1 = " + s1 + ", s2 = " + s2);
//		
//		System.out.println("s1.charAt(s1.length() - 1) = " + s1.charAt(s1.length() - 1));
//		System.out.println("s2.charAt(0) = " + s2.charAt(0));
		
		if ((s1.charAt(s1.length() - 1) == s2.charAt(0))) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private static boolean isDuplicate(List<String> list, String s1) {
		if (list.contains(s1)) {
			return true;
		} else {
			return false;
		}
	}
	

}
