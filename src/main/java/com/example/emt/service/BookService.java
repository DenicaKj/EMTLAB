package com.example.emt.service;

import com.example.emt.model.Book;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void delete(Book book);
    void deleteById(Long id);
    Optional<Book> save(String name,String categroy,Long authorId, int available);
    Optional<Book> edit(Long id,String name,String category,Long authorId,int available);
    void mark(Long id);
    List<Book> findAll();
}
