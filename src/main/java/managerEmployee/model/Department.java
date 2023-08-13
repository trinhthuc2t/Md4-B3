package managerEmployee.model;

public class Department {
    private int idDepartment;
    private String name;

    public Department(int idDepartment, String name) {
        this.idDepartment = idDepartment;
        this.name = name;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Department(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Department() {
    }

    public int getId() {
        return idDepartment;
    }

    public void setId(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
