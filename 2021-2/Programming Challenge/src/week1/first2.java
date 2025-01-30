package week1;

import java.util.*;

public class first2 {

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String s = input.nextLine();
            int words = 1, letters = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ')
                    words++;
                else
                    letters++;
            }

            System.out.println(words + " " + letters);
        }
        
        String a = "abc \n abc";
        System.out.println(a);
        
        input.close();
	}

}
