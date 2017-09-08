/*
 * Author : Vikash Kumar
 * Dated  : 14th August, 2017
 */
public class MaxSumNonAdjacent {

	public static void main(String[] args) {
		System.out.println("Problem statement :\nMaximum sum such that no two elements are adjacent");
		int arr[] = {5, 5, 10, 100, 10, 5};
		System.out.println(maxSumNonAdjacent(arr,0,0));
	}
	
	public static int maxSumNonAdjacent(int[] arr, int index, int sum) {
		if(index== arr.length-1)
			return sum+arr[index];
		else if (index >= arr.length)
			return sum;
		else {
			int x = maxSumNonAdjacent(arr,index+2,sum+arr[index]);
			int y = maxSumNonAdjacent(arr,index+1,sum);
			System.out.println("X : "+x+" Y: "+y+" Index : "+index);
			return sum+max(x,y);
		}
	}
	
	public static int max(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}
}
/*
first window :
	x= arr,2,5;
	y= arr,1,0;






*/