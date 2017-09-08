
public class HeapDemo {
	
	public static void main(String[] args) {
		
		Heap heap = new Heap(5);
		heap.add(40);
		heap.print();
		heap.add(60);
		heap.print();
		heap.add(20);
		heap.print();
		heap.add(80);
		heap.print();
		heap.add(50);
		heap.print();
		heap.add(30);
		heap.print();
		heap.delete();
		heap.print();
		heap.delete();
		heap.print();
	}

}
