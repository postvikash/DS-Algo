
public class StockBuySellNoLimits {
	
	public static void main(String[] args) {
		
		int[] prices = {9, 8, 7, 6, 5, 10, 12};
		int min = prices[0];
		int max = Integer.MIN_VALUE;
		int profit =0;
		for(int i=1;i<prices.length;i++) {
			if(prices[i]<min && max!= Integer.MIN_VALUE) {
				profit = profit+max-min;
				min = prices[i];
				max = Integer.MIN_VALUE;
			}
			
			else if(prices[i]<min && max== Integer.MIN_VALUE) {
				min = prices[i];
			}
			else if(prices[i] > max)
				max = prices[i];
		}
		
		if(max > min) {
			profit = profit+max-min;
		}
		System.out.println("Max profit will be "+profit);
	}

}
