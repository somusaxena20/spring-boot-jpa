package com.somu.controller;

import com.somu.entity.Book;
import com.somu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BookService service;

    @GetMapping(value = {"/","/findall"})
    public List<Book> home() {
        log.info("Inside Find All...");
        return service.findAll();
    }

    @PostMapping("/add")
    public Book add(@RequestBody Book b)
    {
        log.info("Adding Book : "+b);
        return service.add(b);
    }

    @PostMapping("/addbulk")
    public Book[] add(@RequestBody Book[] b)
    {
        log.info("Adding Book : "+b);
        return service.addBulk(b);
    }

}
