
/**
 * 
 *Input:  digits[] = "121"
 *Output: 3
 *The possible decodings are "ABA", "AU", "LA"
 *
 *Input: digits[] = "1234"
 *Output: 3
 *The possible decodings are "ABCD", "LCD", "AWD"
 * 
 */
import java.util.HashMap;
public class MaxPossibleDecoding {
	
	public static void main(String[] args) {
		
		char[] digits = {'1','2','3', '4'};
		HashMap<Integer,Character> hmap = new HashMap<Integer, Character>();
		System.out.println("Hashmap established");
		hmap.put(1, 'A');hmap.put(2, 'B');hmap.put(3, 'C');hmap.put(4, 'D');hmap.put(5, 'E');hmap.put(6, 'F');hmap.put(7, 'G');
		hmap.put(8, 'H');hmap.put(9, 'I');hmap.put(10, 'J');hmap.put(11, 'K');hmap.put(12, 'L');hmap.put(13, 'M');hmap.put(14, 'N');
		hmap.put(15, 'O');hmap.put(16, 'P');hmap.put(17, 'Q');hmap.put(18, 'R');hmap.put(19, 'S');hmap.put(20, 'T');
		hmap.put(21, 'U');hmap.put(22, 'V');hmap.put(23, 'W');hmap.put(24, 'X');hmap.put(25, 'Y');hmap.put(26, 'Z');
		decode(digits, 0, null, hmap);
		
	}
	
	public static void decode(char[] digits, int index, String partial, HashMap<Integer, Character> hmap) {
		if(index == digits.length-1) {
			partial = partial+Character.toString(hmap.get(digits[index]-48));
			System.out.println("Answer : "+partial);
			return;
		}
		if(index == digits.length) {
			System.out.println("Answer : "+partial);
			return;
		}
		int code;
		String temp = partial;
		code = digits[index]-48;
		if(hmap.containsKey(code)) {
			if(partial == null)
				partial = Character.toString(hmap.get(code));
			else
				partial = partial+Character.toString(hmap.get(code));
			//System.out.println("recursive window "+index+" partial string "+partial);
			decode(digits, index+1, partial, hmap);
			
		}
		if(index+1<digits.length) {
			code = (digits[index]-48)*10+(digits[index+1]-48);
			if(hmap.containsKey(code)) {
				if(temp == null)
					temp = Character.toString(hmap.get(code));
				else
					temp = temp+Character.toString(hmap.get(code));
				//System.out.println("recursive window "+index+" partial string "+temp);
				decode(digits, index+2, temp, hmap);
				
			}
		}
	}

}
