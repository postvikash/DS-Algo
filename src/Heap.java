import java.util.Arrays;

public class Heap {
	
	protected int capacity;
	protected int size;
	protected int[] arr;
	
	Heap(int capacity) {
		
		this.capacity = capacity;
		this.size = 0;
		this.arr = new int[capacity];
	}
	
	public int parentIndex (int childIndex) {return (childIndex-1)/2;}
	
	public int leftChildIndex (int parentIndex) {return 2*parentIndex+1;}

	public int rightChildIndex (int parentIndex) {return 2*parentIndex+2;}
	
	public int parent(int childIndex ) {return arr[(childIndex-1)/2];}
	
	public int leftChild(int parentIndex ) {return arr[2*parentIndex+1];}
	
	public int rightChild(int parentIndex ) {return arr[2*parentIndex+2];}
	
	public boolean hasLeftChild(int parentIndex ) {
		if(2*parentIndex+1 < size)
			return true;
		else
			return false;
	}
	
	public boolean hasRightChild(int parentIndex ) {
		if(2*parentIndex+2 < size)
			return true;
		else
			return false;
	}
	
	public void heapifyUp() {
		int childIndex = size - 1;
		int parentIndex = parentIndex(childIndex);

		while(arr[childIndex] > arr[parentIndex]) {
			swap(arr, childIndex, parentIndex);
			childIndex = parentIndex;
			if(childIndex == 0)
				break;
			else
				parentIndex = parentIndex(childIndex);
		}
	}
	
	public void heapifyDown(int parentIndex) {
		if(size == 1)
			return;
		else {
			int largest = parentIndex;
			if(hasLeftChild(parentIndex) && leftChild(parentIndex) > arr[parentIndex])
				largest = leftChildIndex(parentIndex);
			if(hasRightChild(parentIndex) && rightChild(parentIndex) > arr[parentIndex] && rightChild(parentIndex) > leftChild(parentIndex))
				largest = rightChildIndex(parentIndex);
			
			if(largest != parentIndex) {
				swap(arr, parentIndex, largest);
				heapifyDown(largest);
			}
		}
	}
	
	public void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			arr = Arrays.copyOf(arr, capacity*2);
			capacity = capacity*2;
		}
			
	}
	
	public void add(int val) {
		ensureCapacity();
		size++;
		int index = size - 1;
		arr[index] = val;
		if(size > 1)
			this.heapifyUp();	
	}
	
	public void delete() {
		
		if(size == 0)
			System.out.println("Heap is empty");
		else if(size == 1) {
			size--;
			System.out.println("Item Deleted : "+arr[size]);
		}
		else {
			swap(arr,0,size-1);
			size--;
			heapifyDown(0);
		}		
	}
	
	public void print() {
		if(size == 0) {
			System.out.println("Heap is empty");
			return;
		}	
		else {
			System.out.print("[ "+arr[0]);
			for(int i = 1; i< size; i++) {
				System.out.print(", "+arr[i]);
			}
			System.out.println(" ]");
		}
	}

}
