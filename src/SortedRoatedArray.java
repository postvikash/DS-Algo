
public class SortedRoatedArray {
	
	public static void main(String[] args) {
		int[] arr = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		System.out.println("Min element is "+getMinOfSortedRotated(arr));
	}
	
	public static int getMinOfSortedRotated(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		int mid = -1;
		while(low<=high) {
			mid = (low+high)/2;
			if(mid>0 && arr[mid-1] > arr[mid]) 
				break;
			else if(arr[low]>arr[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		if(low>high)
			return arr[0];
		else
			return arr[mid];
	}
}
