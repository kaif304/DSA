package LinkedList.OrganizationEmployeeData;

public class EmployeeList {
    Employee head;
    Employee tail;

    public void showEmployeeList(){
        Employee node = head;
        System.out.println("Employees list : ");
        while(node != null){
            System.out.println("Name: "+node.getName());
            System.out.println("Jobe role: "+node.getRole());
            System.out.println();

            node = node.next;
        }
    }
    public void showEmployee(int empId){
        Employee employee = head;
        while(employee != null && employee.getEmpId() != empId){
            employee = employee.next;
        }
        if(employee == null) return;

        System.out.println("Employee Details: ");
        System.out.println("Emp Id: "+employee.getEmpId());
        System.out.println("Name: "+employee.getName());
        System.out.println("Age: "+employee.getAge());
        System.out.println("Jobe role: "+employee.getRole());
    }
    public void addEmployee(int empId, String name, int age, String role){
        Employee newEmployee = new Employee(empId, name, age, role);

        if(head == null){
            head = newEmployee;
            tail = head;
            return;
        }

        tail.next = newEmployee;
        newEmployee.prev = tail;
        tail = newEmployee;
    }

    public void updateEmployeeDetails(int empId, String name, int age, String newRole){
        // search for employee
        Employee employee = head;
        while (employee != null && empId != employee.getEmpId()){
            employee = employee.next;
        }
        if(employee == null){
            System.out.println("Employee does not exist!");
            return;
        }

        employee.setName(name);
        employee.setAge(age);
        employee.setRole(newRole);
    }
    public void removeEmployee(int empId){
        Employee emp = head;
        while(emp != null && empId != emp.getEmpId()){
            emp = emp.next;
        }
        if(emp == null) return;

        if(emp == head) {
            removeFirst();
            return;
        }
        if(emp == tail) {
            removeLast();
            return;
        }

        if(emp.prev != null){
            emp.prev.next = emp.next;
        }
        if(emp.next != null){
            emp.next.prev = emp.prev;
        }
    }
    public void removeFirst() {
        if (head == null) return;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
    }
    public void removeLast() {
        if (tail == null) return;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
    }


}
