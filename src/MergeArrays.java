/**
 * Given k sorted arrays of size n each, merge them and print the sorted output.
 * Author	: Vikash Kumar
 * Date		: 20th July, 2017
 */
import java.util.Scanner;

public class MergeArrays {
	
	static public void main(String[] args) {
		/*int[][] arr = { {1, 3, 5, 7},
	            		{2, 4, 6, 8},
	            		{0, 9, 10, 11}};*/
		Scanner sc = new Scanner(System.in);
		int t = 0;
		try {
			t = sc.nextInt();
		}
		
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		if(t==0)
			System.out.println(t);
		else
			System.out.println(t);
		sc.close();
	}

}
