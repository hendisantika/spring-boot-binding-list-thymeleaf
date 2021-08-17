package com.hendisantika.controller;

import com.hendisantika.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.apache.http.entity.ContentType.DEFAULT_BINARY;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-binding-list-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/08/21
 * Time: 05.24
 */
@WebMvcTest
@EnableWebMvc
class EmployeeControllerTest {
    private static final MockMultipartFile A_FILE = new MockMultipartFile("document", null, DEFAULT_BINARY.toString()
            , "Employee Record".getBytes());

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void givenFormData_whenPost_thenReturns200OK() throws Exception {
        mockMvc.perform(multipart("/employees")
                        .file(A_FILE)
                        .param("name", "testname"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenEmployeeJsonAndMultipartFile_whenPostWithRequestPart_thenReturnsOK() throws Exception {
        MockMultipartFile employeeJson = new MockMultipartFile("employee", null,
                "application/json", "{\"name\": \"Emp Name\"}".getBytes());

        mockMvc.perform(multipart("/employees/requestpart")
                        .file(A_FILE)
                        .file(employeeJson))
                .andExpect(status().isOk());
    }

    @Test
    public void givenRequestPartAndRequestParam_whenPost_thenReturns200OK() throws Exception {
        mockMvc.perform(multipart("/employees/requestparam")
                        .file(A_FILE)
                        .param("name", "testname"))
                .andExpect(status().isOk());
    }

}
