package week1;

import java.util.*;

public class second {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		String s = null;
		int hex = 0;
		int dec = 0;
		String hs = null;
		
		while (input.hasNextLine()) {
            s = input.nextLine();
            if (s.charAt(0) == '0') {
                hex = Integer.parseInt(s.substring(2), 16); // Skip two characters "0x"
                System.out.println(hex);
            }
            else {
                dec = Integer.parseInt(s);
                hs = Integer.toHexString(dec);
                System.out.println("0x" + hs.toUpperCase());
            }
            
            System.out.println("s = " + s);
    		System.out.println("hex = " + hex);
    		System.out.println("dec = " + dec);
    		System.out.println("hs = " + hs);
        }
		
		
		
		
		input.close();

		
	}

}
