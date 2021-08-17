package com.hendisantika.service;

import com.hendisantika.employee.Employee;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-binding-list-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/08/21
 * Time: 05.12
 */
@Service
public class EmployeeService {
    public void save(Employee employee) {
        saveFile(employee.getDocument());
        // save other employee data
    }
}
