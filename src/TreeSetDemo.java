import java.util.TreeSet;
import java.util.Comparator;

public class TreeSetDemo {
	
	public static void main(String[] args) {
		
		TreeSet<String> tset = new TreeSet<String>(new MyComparator());
		tset.add("Vikash");
		tset.add("Rohit");
		tset.add("Mohit");
		tset.add("Neha");
		tset.add("Kanishk");
		System.out.print(tset);
	}

}

class MyComparator implements Comparator<String> {
	
	public int compare(String obj1, String obj2) {
		String s1 = (String)obj1;
		String s2 = (String)obj2;
		return s2.compareTo(s1);
	}
}
