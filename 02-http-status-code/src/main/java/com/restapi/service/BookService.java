package com.restapi.service;

import com.restapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/*
    Name    : Monu KD (monukd01dev)
    Project : 01-get-method
    Date    : 26-Oct-2023
    
    Connect
    Twitter  : https://twitter.com/monukd01dev
    LinkedIN : https://www.linkedin.com/in/monukd01dev/
    GitHub   : https://github.com/monukd01dev
     
*/
@Service
public class BookService {

    private static List<Book> bookList = new ArrayList<>(List.of(new Book(1,"Spring Reference","Andrie","study"),
            new Book(2,"Silence of Sound","Jake Knight","horror"),
            new Book(3,"Why Sky is Blue","Whips Hike","Idiotic")));

    public List<Book> getAllBooks(){
        return bookList;
    }

    public Book getBook(int id) {
        Book book = new Book();
        book = bookList.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    public Book addBook(Book book) {
        bookList.add(book);
        return book;
    }

    public void deleteBook(int id) {
        bookList = bookList.stream().filter(e->e.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(Book book, int bid) {
        bookList = bookList.stream().map(book1->{
            if(book1.getId() == bid) {
                book1.setAuthor(book.getAuthor());
                book1.setTitle(book.getTitle());
                book1.setGener(book.getGener());
            }
            return book1;
        }).collect(Collectors.toList());

    }

}
