package com.hendisantika.service;

import com.hendisantika.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-binding-list-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/08/21
 * Time: 04.50
 */
@Service
public class BookService {
    static Map<Long, Book> booksDB = new HashMap<>();
}
