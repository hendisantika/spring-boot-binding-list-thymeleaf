package com.hendisantika.controller;

import com.hendisantika.model.Book;
import com.hendisantika.model.BooksCreationDto;
import com.hendisantika.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-binding-list-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/08/21
 * Time: 04.54
 */
@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("books", bookService.findAll());

        return "allBooks";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        BooksCreationDto booksForm = new BooksCreationDto();

        for (int i = 1; i <= 3; i++) {
            booksForm.addBook(new Book());
        }

        model.addAttribute("form", booksForm);

        return "createBooksForm";
    }
}
