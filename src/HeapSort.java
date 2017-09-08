
public class HeapSort {

	public static void main(String[] args) {
		int[] input = {40,60,50,30,20,80};
		heapsort(input);
	}
	
	public static void heapsort(int[] arr) {
		int size = arr.length;
		int parentIndex = (size-2)/2;
		for(int i=parentIndex;i>=0;i--) {
			heapify(arr, i, size);
		}
		for(int i=0;i<arr.length;i++) 
			System.out.print(arr[i]+" ");
		while(size > 1) {
			swap(arr, 0, size-1);
			size--;
			heapify(arr,0, size);
		}
		System.out.print("\n");
		for(int i=0;i<arr.length;i++) 
			System.out.print(arr[i]+" ");
	}
	
	public static void heapify(int[] arr, int parentIndex, int size) {

		int largest = parentIndex;
		int leftChildIndex = parentIndex*2+1;
		int rightChildIndex = parentIndex*2+2;
		if(size > leftChildIndex && arr[parentIndex] < arr[leftChildIndex])
			largest = leftChildIndex;
		if(size > rightChildIndex && arr[largest] < arr[rightChildIndex])
			largest = rightChildIndex;
		
		if(largest != parentIndex) {
			swap(arr,parentIndex, largest);
			heapify(arr,largest, size);
		}
			
	}
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
