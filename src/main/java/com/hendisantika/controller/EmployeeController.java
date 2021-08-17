package com.hendisantika.controller;

import com.hendisantika.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-binding-list-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/08/21
 * Time: 05.15
 */
@Controller
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
}
