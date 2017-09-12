import java.util.ArrayList;
import java.util.Scanner;

public class KLargestNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k;
		System.out.println("Program to get K largest number in a stream of running integers\n");
		System.out.println("Enter the value of K");
		k = sc.nextInt();
		int[] arr = {43,6,10,15,8,45,67,1, 12, 96, 58, 32, 18};
		MinHeap myHeap = new MinHeap(k);
		for(int i=0;i<arr.length;i++) {
			myHeap.addElement(arr[i]);
		}
		myHeap.display();
		sc.close();
	}
}

class MinHeap {
	private ArrayList<Integer> al;
	private final int CAPACITY;
	private int currSize;
	
	public MinHeap(int size) {
		CAPACITY = size;
		currSize = 0;
		al = new ArrayList<Integer>(CAPACITY);
	}
	
	public void addElement(int data) {
		
		if(currSize==CAPACITY) {
			if(al.get(0) < data) {
				al.set(0, data);
				heapifyDown(0);
			}
				
		}
		else {
			al.add(currSize, data);
			heapifyUp(currSize);
			currSize++;
		}
	}
	
	private void heapifyUp(int childIndex){
		if(currSize <= 0)
			return;
		else {
			int parentIndex = (childIndex-1)/2;
			if(al.get(parentIndex) > al.get(childIndex)) {
				swap(parentIndex, childIndex);
				heapifyUp(parentIndex);
			}
		}
	}
	
	private void swap(int pI, int cI) {
		int temp = al.get(pI);
		al.set(pI, al.get(cI));
		al.set(cI, temp);
	}
	
	private void heapifyDown(int index) {
		if(index >= currSize-1)
			return;
		else {
			int leftChildIndex = index*2+1;
			int rightChildIndex = index*2+2;
			int smallest = index;
			if(leftChildIndex < currSize && al.get(leftChildIndex) < al.get(index))
				smallest = leftChildIndex;
			if(rightChildIndex < currSize && al.get(rightChildIndex) < al.get(smallest))
					smallest = rightChildIndex;
			if(smallest != index) {
				swap(index, smallest);
				heapifyDown(smallest);
			}
				
		}
	}
		
	public void display() {	
		
		System.out.println(al);
	}
}
