package org.myproject.Employeeproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class EmployeeController {
    
    //DEPENDENCY INJECTION
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("employees")
    public @ResponseBody List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public @ResponseBody Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }
    
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.creatEmployee(employee);
    }
    
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleterEmployee(id))   
            return "Deleted Successfully";
        return "Employee Not Found";
    }

    @PutMapping("path/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}

