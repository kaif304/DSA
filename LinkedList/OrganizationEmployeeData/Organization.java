package LinkedList.OrganizationEmployeeData;

public class Organization {
    public static void main(String[] args) {
        EmployeeList emp = new EmployeeList();

        emp.addEmployee(100, "Rohan", 22, "SDE 1");
        emp.addEmployee(101, "Jadeep", 22, "SDE 2");
        emp.addEmployee(102, "Sumit", 22, "SDE 3");

        emp.showEmployee(102);
        System.out.println();
        emp.showEmployeeList();
    }
}
