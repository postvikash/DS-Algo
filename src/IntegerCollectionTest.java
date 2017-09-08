
public class IntegerCollectionTest {
	
	public static void main(String[] args) throws Exception {
		MyIntegerCollection mic = new MyIntegerCollection();
		mic.addElement(10);
		mic.addElement(20);
		mic.addElement(30);
		mic.addElement(40);
		mic.showContent();

		System.out.println(mic.getElementAt(3));
		System.out.println(mic.getElementAt(5));	
	}

}
