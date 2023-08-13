package managerEmployee.service;

import managerEmployee.DAO.EmployeeDAO;
import managerEmployee.model.Department;
import managerEmployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public List<Department> getDepartment() {
        return employeeDAO.getDepartment();
    }

    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    public void delete(int id) {
        employeeDAO.delete(id);
    }

    public Employee findById(int id) {
        List<Employee> employeeList = employeeDAO.getAll();
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()){
                return employeeList.get(i);
            }
        }return null;
    }

    public List<Employee> findByName(String name) {
        List<Employee> employeeList = getAll();
        List<Employee> employees = new ArrayList<>();
        for (Employee e :
                employeeList) {
            if (e.getName().toUpperCase().contains(name.toUpperCase())) {
                employees.add(e);
            }

        }
        return employees;
    }
    public void edit(int id, Employee employee){
        employeeDAO.edit(id, employee);
    }
    public List<Employee> sortASC(){
        return employeeDAO.sortASC();
    }public List<Employee> sortDESC(){
        return employeeDAO.sortDESC();
    }
}
