package com.restapi.service;

import com.restapi.model.Book;
import com.restapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBook(int id) throws Exception{
        return this.bookRepository.findById(id).get();
    }

    public Book addBook(Book book) throws Exception{
        return this.bookRepository.save(book);
    }

    public void deleteBook(int id) throws Exception{
        this.bookRepository.deleteById(id);
    }

    public void updateBook(Book book) throws Exception{
        this.bookRepository.save(book);
    }

}
