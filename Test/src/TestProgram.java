
public class TestProgram {
 
	public static void main(String args[]) {
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		e1.setName("Ashwani");
		e2.setName("Pramod");
		
		System.out.println("e1.getName(): "+e1.getName());
		System.out.println("e2.getName(): "+e2.getName());
		swap(e1, e2);
		
		System.out.println("e1.getName(): "+e1.getName());
		System.out.println("e2.getName(): "+e2.getName());
		
	}
	
	public static void swap(Employee e1, Employee e2) {
		Employee employeeTemp  = new Employee();
		employeeTemp = e1;
		e1= e2;
		e2 = employeeTemp;
	}
	
	
	 public static class Employee {
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	 }
}


