package week2;

import java.util.Scanner;

public class RemoconTest {

	public static void main(String[] args) {
		
		Remocon remocon = new Remocon();
		
		Scanner input = new Scanner(System.in);
		
		remocon.display();
		
		boolean end  = false;
		int selection = 0;
		while (!end) {
			System.out.println("1. Volume up.");
			System.out.println("2. Volume down.");
			System.out.println("3. Channel up.");
			System.out.println("4. Channel down.");
			
			selection = input.nextInt();
			switch (selection) {
			case 1:
				remocon.volumeUp();
				break;
			case 2:
				remocon.volumeDown();
				break;
			case 3:
				remocon.channelUp();
				break;
			case 4:
				remocon.channelDown();
				break;
			default:
				System.out.println("시스템을 종료합니다.");
				end = true;
			}
		}
		input.close();
	}
}
