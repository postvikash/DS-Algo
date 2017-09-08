
import java.util.*;

class TestClass1 {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String [] input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.next();
        }
        for (int i = 0; i < N; i++) {
            printRequiredSubstring(input[i]);
        }
        sc.close();
    }
    
    public static void printRequiredSubstring(String str) {
    	String findStr = "hello";
    	int lastIndex = 0;
    	int count = 0;

    	while(lastIndex != -1){

    	    lastIndex = str.indexOf(findStr,lastIndex);

    	    if(lastIndex != -1){
    	        count ++;
    	        lastIndex += findStr.length();
    	    }
    	}
    	System.out.println(count);

    }
}
