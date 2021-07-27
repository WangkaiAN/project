package org.example.service;

import com.github.pagehelper.PageHelper;
import org.example.mapper.BookMapper;
import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> queryAsDict() {
        return bookMapper.queryAsDict();
    }

    public List<Book> query(Book input) {
        PageHelper.startPage(input);
        return bookMapper.selectAll();
    }

    public int add(Book book) {
        return bookMapper.insertSelective(book);
    }

    public Book queryById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    public int update(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
    }

    public int delete(List<Integer> ids) {
        return bookMapper.deleteByIds(ids);
    }
}
