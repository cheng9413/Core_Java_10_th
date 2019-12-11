package _Chapter5._5_11_arrayList;

import _Chapter5._5_8_equals.Employee;
import java.util.ArrayList;

public class ArrayListTest {
  public static void main(String[] args) {
    // fill the staff array list with three Employee objects
    var staff = new ArrayList<Employee>();

    staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
    staff.add(new Employee("Harry Cracker", 50000, 1989, 10, 1));
    staff.add(new Employee("Tony Tester", 40000, 1987, 3, 15));

    // raise everyone's salary by 5%
    for (Employee e : staff) {
      e.raiseSalary(5);
    }

    // print out information about all Employee objects
    for (Employee e : staff) {
      System.out.println(
          "name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
    }
  }
}
