package com.mikelzuzu.spring5webapp.controllers;

import com.mikelzuzu.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // This method will be invoke in the next endpoint
    @RequestMapping("/books")
    public String getBooks(Model model) {
        // Add books attribute to return list of books out of bookReository
        model.addAttribute("book", bookRepository.findAll());

        // This tells Spring MVC to associate with the view calls books
        return "books";
    }
}
