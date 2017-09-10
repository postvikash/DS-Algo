import java.util.HashMap;

public class PossibleDecoding {
	
	public static void main(String[] args){
		
		HashMap<Integer,Character> hmap = new HashMap<Integer, Character>();
		System.out.println("Hashmap established");
		hmap.put(1, 'A');hmap.put(2, 'B');hmap.put(3, 'C');hmap.put(4, 'D');hmap.put(5, 'E');hmap.put(6, 'F');hmap.put(7, 'G');
		hmap.put(8, 'H');hmap.put(9, 'I');hmap.put(10, 'J');hmap.put(11, 'K');hmap.put(12, 'L');hmap.put(13, 'M');hmap.put(14, 'N');
		hmap.put(15, 'O');hmap.put(16, 'P');hmap.put(17, 'Q');hmap.put(18, 'R');hmap.put(19, 'S');hmap.put(20, 'T');
		hmap.put(21, 'U');hmap.put(22, 'V');hmap.put(23, 'W');hmap.put(24, 'X');hmap.put(25, 'Y');hmap.put(26, 'Z');
		StringBuffer str = new StringBuffer("10310");
		String partial = new String("");
		decodeAndPrint(str, 0, partial, hmap);
	}
	
	public static void decodeAndPrint(StringBuffer str, int idx, String partial, HashMap<Integer,Character> hmap) {
		
		if(idx > str.length()-1) {
			System.out.println(partial);
			return;
		}
		
		if(idx < str.length()-1 && str.charAt(idx+1)!='0') {
			partial = partial+hmap.get(str.charAt(idx)-48);
			decodeAndPrint(str, idx+1, partial, hmap);
		}
		
		else if(idx < str.length()-1 && str.charAt(idx+1)=='0') {
			partial = partial+hmap.get((str.charAt(idx)-48)*10+str.charAt(idx+1)-48);
			decodeAndPrint(str, idx+2, partial, hmap);
		}
		
		if(idx == str.length()-1) {
			partial = partial+hmap.get(str.charAt(idx)-48);
			decodeAndPrint(str, idx+1, partial, hmap);
		}
		
		if(idx < str.length()-1 && hmap.get((str.charAt(idx)-48)*10+str.charAt(idx+1)-48) !=null && str.charAt(idx+1)!='0') {
			if(partial.length() > 0) {
				partial = partial.substring(0, partial.length() - 1);
				partial = partial+ hmap.get((str.charAt(idx)-48)*10+str.charAt(idx+1)-48);
				decodeAndPrint(str, idx+2, partial, hmap);
			}
			
		}
	}

}
