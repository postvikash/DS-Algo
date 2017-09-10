
public class MaxDecodeCount {
	
	public static void main(String[] args) {
		String str = "10021";
		System.out.println("Possible decoding count is "+getDecodeCount(str.toCharArray()));
	}
	
	public static int getDecodeCount(char[] arr) {
		int count = 1;
		for(int i=0;i<arr.length-2;i++) {
			if(i == '0')
				continue;
			else {
				if(arr[i] == '2' && arr[i+1] < '7')
					count++;
				else if(arr[i] == '1')
					count++;
			}
		}
		return count;
	}

}
