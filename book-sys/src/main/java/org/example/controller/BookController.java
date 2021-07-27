package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询图书数据字典（图书下拉菜单初始化）
     * */
    @GetMapping("/queryAsDict")
    public Object queryAsDict(){
        List<Book> books = bookService.queryAsDict();
        return books;
    }

    /**
     * /api/book/query
     * */
    @GetMapping("/query")
    public Object query(Book input){
        List<Book> books = bookService.query(input);
        return books;
    }

    /**
     * /api/book/add
     * */
    @PostMapping("/add")
    public Object add(@RequestBody Book book){
        int n = bookService.add(book);
        return null;
    }

    /**
     * /api/book/queryById
     * 先查找，再修改
     * */
    @GetMapping("/queryById")
    public Object queryById(Integer id){
        Book book = bookService.queryById(id);
        return book;
    }
    /**
     * /api/book/update
     * */
    @PostMapping("/update")
    public Object update(@RequestBody Book book){
        int n = bookService.update(book);
        return null;
    }
    /**
     * /api/book/delete?ids=5
     * Get
     * */
    @GetMapping("/delete")
    public Object delete(@RequestParam("ids") List<Integer> ids){
        int n = bookService.delete(ids);
        return null;
    }
}
