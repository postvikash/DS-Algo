
//import for Scanner and other utility  classes
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
       
        int testCases;
        Scanner sc = new Scanner(System.in);
        testCases = sc.nextInt();
        int[] tickets = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            tickets[i] = sc.nextInt();
        }

        for (int i = 0; i < testCases; i++) {
            countCheckPoints(tickets[i]);
        }
        sc.close();
    }
    
    public static void countCheckPoints(int ticketNum) {
    	int sum = 0;
    	int count = 0;
    	for(int j=1;j<=ticketNum/2+1;j++) {
    		for(int i=j;i<=ticketNum/2+1;i++) {
    			sum = sum+i;
    			if(sum < ticketNum)
    				continue;
    			if(sum == ticketNum) {
    				count++;
    				sum = 0;
    				break;
    			}
    			if(sum > ticketNum) {
    				sum = 0;
    				break;
    			}
    		}
        }
        System.out.println(count);
    }
}
