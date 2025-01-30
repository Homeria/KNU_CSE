package week3;

import java.util.*;

public class restaurant4 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String line;
		String[] token;
		
		Queue<String> queue = new LinkedList<String>();
		
		while(input.hasNextLine()) {
			int cnt = Integer.parseInt(input.nextLine());
			int target = 0;
			String[] arr = new String[cnt];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = "#";
			}
			line = input.nextLine();
			token = line.split(" ");
			for(int i = 0; i < token.length; i++) {
				if (!token[i].equals("*")) {
					for(int j = 0; j < arr.length; j++) {
						if (arr[j].equals("#")) {
							arr[j] = token[i];
							break;
						}
					}
				} else if (token[i].equals("*")) {
					for(int j = 0; j < arr.length; j++) {
						if (!arr[j].equals("#")) {
							arr[target] = "#";
							if (target == cnt - 1) {
								target = 0;
							} else {
								target++;
							}
							break;
						}
					}
				}
			}
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
				if (i != arr.length - 1) {
					System.out.print(" ");
				}
			}
		}
		input.close();
	}

}
