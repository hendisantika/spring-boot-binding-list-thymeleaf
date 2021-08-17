package com.hendisantika.controller;

import com.hendisantika.employee.Employee;
import com.hendisantika.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping(value = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/createEmployeeForm";
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "employees/success";
    }

    @PostMapping(path = "/requestpart", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> saveEmployee(@RequestPart Employee employee, @RequestPart MultipartFile document) {
        employee.setDocument(document);
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/requestparam", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> saveEmployee(@RequestParam String name, @RequestPart MultipartFile document) {
        Employee employee = new Employee(name, document);
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }

}
