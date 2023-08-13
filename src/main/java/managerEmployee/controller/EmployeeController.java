package managerEmployee.controller;

import managerEmployee.model.Department;
import managerEmployee.model.Employee;
import managerEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String showEmployee(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "home";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("departments", employeeService.getDepartment());
        return "add";
    }

//    @PostMapping("/add")
//    public String add(@RequestParam String name, String employeeCode,int age, int salary, int idDepartment) {
//        employeeService.add(new Employee(employeeCode,name,age,salary, new Department(idDepartment)));
//        return "redirect:/employees";
//    }
    @PostMapping("/add")
    public String add(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees";
    }
    @GetMapping("/delete{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
    @GetMapping("/{id}")
    public String editForm(@PathVariable int id, Model model ){
        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("departments", employeeService.getDepartment());
        return "edit";
    }
    @PostMapping("/{id}")
    public String edit(@PathVariable int id,String name,String employeeCode,int age, int salary, int idDepartment){
        Department department = new Department(idDepartment);
        employeeService.edit(id,new Employee(employeeCode,name,age,salary,department));
        return "redirect:/employees";
    }
    @GetMapping("/info{id}")
    public String info(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "info";
    }
    @GetMapping("/sortASC")
    public String sortASC(Model model){
        model.addAttribute("employees", employeeService.sortASC());
        return "home";
    }
    @GetMapping("/sortDESC")
    public String sortDESC(Model model){
        model.addAttribute("employees", employeeService.sortDESC());
        return "home";
    }
    @GetMapping("/search")
    public String search(String nameSearch, Model model){
        model.addAttribute("employees", employeeService.findByName(nameSearch));
        return "home";
    }

}
