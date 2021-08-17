package com.hendisantika.repository;

import com.hendisantika.employee.Employee;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-binding-list-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/08/21
 * Time: 05.10
 */
@Repository
public interface EmployeeRepository {
    void saveEmployee(Employee employee);
}

