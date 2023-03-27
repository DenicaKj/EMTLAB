package com.example.emt.service;

import com.example.emt.model.Book;
import com.example.emt.model.DTO.BookDTO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void delete(Book book);
    void deleteById(Long id);
    Optional<Book> save(String name,String categroy,Long authorId, int available);
    Optional<Book> save(BookDTO bookDTO);
    Optional<Book> edit(Long id,String name,String category,Long authorId,int available);
    Optional<Book> edit(Long id,BookDTO bookDTO);
    void mark(Long id);
    Optional<Book> findById(Long id);
    List<Book> findAll();
}
