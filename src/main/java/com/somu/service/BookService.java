package com.somu.service;

import com.somu.entity.Book;
import com.somu.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo repo;

    public Book add(Book b)
    {
        repo.save(b);

        return b;
    }

    public List<Book> findAll(){
        return repo.findAll();
    }

    public Book[] addBulk(Book[] b) {
        for (Book x : b) {
            repo.save(x);
        }
        return b;
    }
}
