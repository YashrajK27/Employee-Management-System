package org.myproject.Employeeproject;

import java.util.List;

public interface EmployeeService {
    String creatEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleterEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee readEmployee(Long id);
}
