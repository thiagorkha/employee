import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employee;


class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    System.out.print("How many employees will be registered? ");
    int n = sc.nextInt();
    sc.nextLine();

    List<Employee> list = new ArrayList<>();

    for (int i=0; i<n; i++) {
      System.out.println("Employee #" + (i+1));
      System.out.print("Id: ");
      int id = sc.nextInt();
      sc.nextLine();
      System.out.print("Name: ");
      String name = sc.nextLine();
      System.out.print("Salary: ");
      double salary = sc.nextDouble();

      list.add(new Employee(id, name, salary));
    }

    System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

    System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}
				
		sc.close(); 
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

    
  
}