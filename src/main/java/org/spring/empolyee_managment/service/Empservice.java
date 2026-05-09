package org.spring.empolyee_managment.service;

import java.util.List;
import org.spring.empolyee_managment.model.Employee;

public interface Empservice {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id) ;
    String updateEmployee(Long id , Employee employee);
    Employee readEmployee(Long id);

}
