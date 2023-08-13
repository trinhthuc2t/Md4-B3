package managerEmployee.DAO;

import managerEmployee.model.Department;
import managerEmployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO {
    Connection connection = ConnectionToMySQL.getConnection();

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "select e.id as employeeId,e.employeeCode, e.name,e.age, e.salary, e.departmentId,d.name as departmentName from employee e join department d on d.id = e.departmentId";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("employeeId"));
                String employeesCode = resultSet.getString("employeeCode");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                int departmentId = resultSet.getInt("departmentId");
                String departmentName = resultSet.getString("departmentName");
                Department department = new Department(departmentId, departmentName);
                Employee employee = new Employee(id, employeesCode, name, age, salary, department);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public List<Department> getDepartment() {
        String sql = "select * from department";
        List<Department> departments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Department department = new Department(id, name);
                departments.add(department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    public void add(Employee employee) {
        String sql = "insert into employee (employeeCode, name, age, salary, departmentId) values (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getEmployeeCode());
            statement.setString(2, employee.getName());
            statement.setInt(3, employee.getAge());
            statement.setInt(4, employee.getSalary());
            statement.setInt(5, employee.getDepartment().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "delete from employee where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void edit(int id, Employee employee) {
        String sql = "UPDATE employee SET  name = ?, employeeCode = ?, age = ?, salary = ?, departmentId = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmployeeCode());
            statement.setInt(3, employee.getAge());
            statement.setInt(4, employee.getSalary());
            statement.setInt(5, employee.getDepartment().getIdDepartment());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> sortASC() {
        List<Employee> employees = new ArrayList<>();

        String sql ="select e.id as employeeId,e.employeeCode, e.name,e.age, e.salary, e.departmentId,d.name as departmentName from employee e join department d on d.id = e.departmentId ORDER BY age ASC";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("employeeId"));
                String employeesCode = resultSet.getString("employeeCode");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                int departmentId = resultSet.getInt("departmentId");
                String departmentName = resultSet.getString("departmentName");
                Department department = new Department(departmentId, departmentName);
                Employee employee = new Employee(id, employeesCode, name, age, salary, department);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
    public List<Employee> sortDESC() {
        List<Employee> employees = new ArrayList<>();

        String sql ="select e.id as employeeId,e.employeeCode, e.name,e.age, e.salary, e.departmentId,d.name as departmentName from employee e join department d on d.id = e.departmentId ORDER BY age DESC";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("employeeId"));
                String employeesCode = resultSet.getString("employeeCode");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                int departmentId = resultSet.getInt("departmentId");
                String departmentName = resultSet.getString("departmentName");
                Department department = new Department(departmentId, departmentName);
                Employee employee = new Employee(id, employeesCode, name, age, salary, department);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
