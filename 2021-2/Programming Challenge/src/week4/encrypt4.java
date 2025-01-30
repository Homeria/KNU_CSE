package week4;

import java.util.Scanner;

public class encrypt4 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String[] arr = new String[6];
		
		//String lineName = input.nextLine();
		String lineName = "ADFGVX";
		
		//String statement = input.nextLine();
		String statement = "qw0ert1yu23iop4as56dfg7hjk8lzxc9vbnm";
		
		separation(arr, statement);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			
			String decrypted = decrypt(arr, lineName, s);
			if (decrypted == null) {
				System.out.println("-ERROR-");
			} else {
				System.out.println(decrypted);
			}
			
			
		}
		
		input.close();
		
		
	}
	
	private static void separation(String[] arr, String s) {
		
		int index = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			arr[i] = s.substring(index, index + 6).toLowerCase();
			index += 6;
		}
	}
	
	private static String decrypt(String[] arr, String lineName, String s) {
		
		if (s.length() <= 1) {
			return null;
		}
		
		int n = 0;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				n++;
			}
		}
		if ((n % 2) != 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		String newS = s.toUpperCase();
		
		int index = 0;
		int x = -1;
		int y = -1;;
		
		try {
			for(int i = 0; i < newS.length();) {
				
				x = -1;
				y = -1;
				
				char c1 = newS.charAt(index);
				char c2 = newS.charAt(index + 1);
				
				if (c1 == ' ') {
					if (c2 == ' ') {
						sb.append("  ");
						index += 2;
						i += 2;
						continue;
					} else  {
						sb.append(" ");
						index++;
						i++;
						continue;
					}
				}
				
				if ((c1 < 65) || (c1 > 122) || (c2 < 65) || (c2 > 122)) {
					return null;
				}
				
				for(int j = 0; j < lineName.length(); j++) {
					if (c1 == lineName.charAt(j)) {
						x = j;
					}
					if (c2 == lineName.charAt(j)) {
						y = j;
					}
				}
				
				if ((x == -1) || (y == -1)) {
					return null;
				} else {
					sb.append(arr[x].charAt(y));
					
				}
				index += 2;
				i += 2;
			}
			return sb.toString();
		} catch (NullPointerException e1) {
			return null;
		} catch (ArrayIndexOutOfBoundsException e2) {
			return null;
		}
		
	}

}
