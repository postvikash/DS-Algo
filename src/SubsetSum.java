
public class SubsetSum {
	
	public static void main(String args[]) {
		int arr[] = {7,8,2,10,3};
		final int SUM = 12;
		boolean answer = ifSubsetExists(arr, SUM, 0);
		System.out.println("\nAnswer is : "+answer);
	}
	
	private static boolean ifSubsetExists(int [] arr, int sum, int index) {
		if(sum<0 || index>=arr.length)
			return false;
		if(sum==0)
			return true;
		else {
			boolean including = ifSubsetExists(arr, sum-arr[index], index+1);
			if(including == true) {
				System.out.print(" "+arr[index]);
				return including;
			}
			boolean excluding = ifSubsetExists(arr, sum, index+1);
			return excluding;
		}
	}

}
