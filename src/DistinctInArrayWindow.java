import java.util.HashSet;

public class DistinctInArrayWindow {
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 1, 3, 4, 2, 3};
		int k = 4, i = 0;
		
		while(i+k <=7) {
			System.out.println("For "+k+" window, distinct count is : "+getDistinctCount(arr, i, i+k));
			i++;
		}
	}
	
	public static int getDistinctCount(int[] arr, int startIdx, int endIdx) {
		
		int distinct = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=startIdx;i<endIdx;i++)
			if(set.add(arr[i]))
				distinct++;
		return distinct;
	}

}
