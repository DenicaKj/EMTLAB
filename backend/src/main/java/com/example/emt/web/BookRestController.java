package com.example.emt.web;

import com.example.emt.model.Book;
import com.example.emt.model.DTO.BookDTO;
import com.example.emt.service.BookService;
import com.example.emt.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;
    private final CategoryService categoryService;

    public BookRestController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping
    private List<Book> findAll() {
        List<Book> books=bookService.findAll();

        return this.bookService.findAll();
    }
    @GetMapping("/categories")
    private List<String> findAllCat() {

        return this.categoryService.categories();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDTO book) {
        return this.bookService.save(book)
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDTO book) {
        return this.bookService.edit(id, book)
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity mark(@PathVariable Long id) {
        this.bookService.mark(id);
        return ResponseEntity.ok().build();
    }

}





