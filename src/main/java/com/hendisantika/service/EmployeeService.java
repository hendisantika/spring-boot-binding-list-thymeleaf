package com.hendisantika.service;

import com.hendisantika.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    private void saveFile(MultipartFile multipartFile) {
        try {
            saveToFilesystem(multipartFile);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save file", e);
        }
    }

}
