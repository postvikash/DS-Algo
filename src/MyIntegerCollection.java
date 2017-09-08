import java.util.Arrays;

public class MyIntegerCollection {
	
	private int capacity = 20;
	private int size = 0;
	private int [] myList = new int[capacity];
	
	public void addElement(int data) {
		this.ensureCapacity();
		myList[size] = data;
		size++;
	}
	
	private void ensureCapacity() {
		if(size == capacity) {
			myList = Arrays.copyOf(myList, 2*capacity);
			capacity = 2*capacity;
		}
	}
	
	public int getElementAt(int index) throws Exception{
		if(index >= size)
			throw new Exception("Illegal Index");
		else
			return myList[index];
	}
	
	public void showContent() {
		if(size == 0) 
			System.out.println("List is empty");
		else {
			System.out.print(myList[0]);
			for(int i=1;i<size;i++) 
				System.out.print(", "+myList[i]);
		}
		System.out.println("");
	}

}
