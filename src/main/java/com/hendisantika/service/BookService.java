package com.hendisantika.service;

import com.hendisantika.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public List<Book> findAll() {
        return new ArrayList<>(booksDB.values());
    }

    public void saveAll(List<Book> books) {
        long nextId = getNextId();
        for (Book book : books) {
            if (book.getId() == 0) {
                book.setId(nextId++);
            }
        }

        Map<Long, Book> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity()));

        booksDB.putAll(bookMap);
    }

    private Long getNextId() {
        return booksDB.keySet()
                .stream()
                .mapToLong(value -> value)
                .max()
                .orElse(0) + 1;
    }
}
