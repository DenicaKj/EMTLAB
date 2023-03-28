package com.example.emt.service.Impl;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import com.example.emt.model.DTO.BookDTO;
import com.example.emt.model.enumeration.Category;
import com.example.emt.model.exception.NoAvailableCopies;
import com.example.emt.repository.AuthorRepository;
import com.example.emt.repository.BookRepository;
import com.example.emt.service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void delete(Book book){
        bookRepository.delete(book);
    }
    @Override
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(String name, String category, Long authorId, int available) {
        Category category1=Category.valueOf(category);
        Author author=authorRepository.findById(authorId).get();
        return Optional.of(bookRepository.save(new Book(name,category1,author,available)));
    }

    @Override
    public Optional<Book> save(BookDTO bookDTO) {
        Category category1=Category.valueOf(bookDTO.getCategory());
        Author author=authorRepository.findById(bookDTO.getAuthor()).get();
        return Optional.of(bookRepository.save(new Book(bookDTO.getName(),category1,author,bookDTO.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, String name,String category, Long authorId, int available) {
        Book book=bookRepository.findById(id).get();
        book.setName(name);
        book.setCategory(Category.valueOf(category));
        Author author=authorRepository.findById(authorId).get();
        book.setAuthor(author);
        book.setAvailableCopies(available);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDTO bookDTO) {
        Book book=bookRepository.findById(id).get();
        book.setName(bookDTO.getName());
        book.setCategory(Category.valueOf(bookDTO.getCategory()));
        Author author=authorRepository.findById(bookDTO.getAuthor()).get();
        book.setAuthor(author);
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void mark(Long id) {
        Book book=bookRepository.findById(id).get();
        int pom=book.getAvailableCopies();
        if(pom-1<0){
          throw new NoAvailableCopies();
        }else {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }

    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}
