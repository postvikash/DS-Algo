import java.lang.Comparable;

public class Employee implements Comparable<Employee> {
	
	String empName;
	int empID;
	
	Employee(String name, int ID) {
		empName = name;
		empID = ID;
	}
	
	public int compareTo(Employee obj1) {
		Employee x = (Employee)obj1;
		if(this.empID > x.empID)
			return 1;
		else
			return -1;
	}
	
}
