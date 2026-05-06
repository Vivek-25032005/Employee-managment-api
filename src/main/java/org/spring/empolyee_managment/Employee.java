package org.spring.empolyee_managment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    
    private Long id;
    private String name;
    private String phone;
    private String email;
   
}
