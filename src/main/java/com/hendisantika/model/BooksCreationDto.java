package com.hendisantika.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-binding-list-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/08/21
 * Time: 04.57
 */
@Data
public class BooksCreationDto {
    private List<Book> books;

    public BooksCreationDto() {
        this.books = new ArrayList<>();
    }

    public BooksCreationDto(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}
