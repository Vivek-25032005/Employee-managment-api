package org.spring.empolyee_managment;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class EmplserviceImpl implements Empservice {
    
    @Autowired
     EmployeeRepository employeeRepository;

    List<Employee> employees = new ArrayList<>();

    @Override
    @Transactional
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
       
        employeeRepository.save(employeeEntity);
      // employees.add(employee);
       return "saved Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
             EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
            Employee employee = new Employee();
        BeanUtils.copyProperties( employeeEntity , employee);
        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
      List<EmployeeEntity> employeesList =  employeeRepository.findAll();
       List<Employee> employees = new ArrayList<>();
       for(EmployeeEntity employeeEntity : employeesList){
        Employee emp = new Employee();
        emp.setName(employeeEntity.getName());
        emp.setEmail(employeeEntity.getEmail());
        emp.setId(employeeEntity.getId());
        emp.setPhone(employeeEntity.getPhone());
          employees.add(emp);
       }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
         employeeRepository.delete(emp);
         return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
       EmployeeEntity exestingEmployee = employeeRepository.findById(id).get();
       exestingEmployee.setEmail(employee.getEmail());
       exestingEmployee.setName(employee.getName());
       exestingEmployee.setPhone(employee.getPhone());

       employeeRepository.save(exestingEmployee);
       return "update successfully";
    }

   


    

}
