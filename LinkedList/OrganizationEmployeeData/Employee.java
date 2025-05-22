package LinkedList.OrganizationEmployeeData;

public class Employee {
    private int empId;
    private String name;
    private int age;
    private String role;
    Employee next;
    Employee prev;

    public Employee(int empId, String name, int age, String role){
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.role = role;
    }
    public int getEmpId(){
        return this.empId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
}
