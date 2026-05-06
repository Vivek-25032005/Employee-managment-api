package org.spring.empolyee_managment;

import java.util.List;

public interface Empservice {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id) ;
    String updateEmployee(Long id , Employee employee);
    Employee readEmployee(Long id);

}
