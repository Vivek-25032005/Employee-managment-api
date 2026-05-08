package org.spring.empolyee_managment;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@CrossOrigin(
    origins = "https://employee-managment-ui.vercel.app",
    allowedHeaders = "*",
    methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.PUT,
    RequestMethod.DELETE,
    RequestMethod.OPTIONS
}
)
public class EmpController {
    
     //List<Employee> employees = new ArrayList<>();

     @Autowired
     Empservice employeeservice ;

    @GetMapping("employees")
    public List<Employee> getallEmployees() {
         return employeeservice.readEmployees();
    }

     @GetMapping("employees/{id}")
    public Employee getEmployeesByIdEmployees(@PathVariable Long id) {
         return employeeservice.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
       // employees.add(employee);
      return  employeeservice.createEmployee(employee);
        
    
    }
    @DeleteMapping("employees/{id}")
   public String deleteEmployee(@PathVariable Long id){
    if(employeeservice.deleteEmployee(id))
        return "Delete Successful";
    return "Not found";
   }
    
    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeservice.updateEmployee(id, employee);
    }
}
