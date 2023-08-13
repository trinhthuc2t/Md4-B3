package managerEmployee.model;

public class Employee {
    private int id;
    private String employeeCode;
    private String name;
    private int age;
    private int salary;
    private Department department;

    public Employee() {
    }

    public Employee(String employeeCode, String name, int age, int salary, Department department) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
    public Employee(int id, String employeeCode, String name, int age, int salary, Department department) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
