package week6;

import java.util.*;

public class second {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		StringBuilder sb;
		
		List<String> list;
		
		boolean first = true;
		
		while(input.hasNextLine()) {
			
			first = true;
			
			sb = new StringBuilder();
			
			list = new ArrayList<String>();
			
			String line = input.nextLine();
			
			if(line.equals("")) {
				continue;
			}
			
			String[] splited = line.split(" ");
			
			int size = Integer.parseInt(splited[0]);
			
			if (size > 1) {
				for(int i = 2; i <= size; i++) {
					
					if(first) {
						if (splited[i - 1].equals(splited[i])) {
							System.out.println(splited[i] + " ");
							break;
						} else {
							
							if ((splited[i - 1].length() == 1) && (splited[i].length() == 1)) {
								System.out.println(splited[i - 1] + " ");
								break;
							} else {
								
								if (isOkay(list, splited[i - 1], splited[i])) {
									sb.append(splited[i - 1] + " ");
									if (size == 2) {
										sb.append(splited[i]);
									} else {
										sb.append(splited[i] + " ");
									}
									//System.out.print(splited[i] + " ");
									list.add(splited[i - 1]);
									list.add(splited[i]);
									first = false;
								} else {
									System.out.println(splited[i - 1] + " ");
									break;
								}
								
								
								
								
							}
							
							
						}
						
						
					} else {
						
						if(isOkay(list, splited[i - 1], splited[i])) {
							if (!isDuplicate(list, splited[i])) {
								sb.append(splited[i] + " ");
								//System.out.print(splited[i]);
								list.add(splited[i]);
							} else {
								break;
							}
							
						} else {
							break;
						}
					}
					
					
				}
				
				String s = sb.toString();
				if (!s.equals("")) {
					System.out.println(sb.toString());
				}
				
				
			} else {
				System.out.println(splited[1] + " ");
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
