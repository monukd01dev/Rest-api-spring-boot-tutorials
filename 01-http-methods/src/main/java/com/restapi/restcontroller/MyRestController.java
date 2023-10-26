package com.restapi.restcontroller;

import com.restapi.model.Book;
import com.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Name    : Monu KD (monukd01dev)
    Project : 01-get-method
    Date    : 26-Oct-2023
    
    Connect
    Twitter  : https://twitter.com/monukd01dev
    LinkedIN : https://www.linkedin.com/in/monukd01dev/
    GitHub   : https://github.com/monukd01dev
     
*/
@RestController
public class MyRestController {

    private BookService bookService;

    @Autowired
    public MyRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home() {
        return "at home of books";
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBook(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id) {
         this.bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book,@PathVariable("id") int id) {
         this.bookService.updateBook(book, id);
    }
}
