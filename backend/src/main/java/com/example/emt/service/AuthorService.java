package com.example.emt.service;

import com.example.emt.model.Author;
import com.example.emt.model.Book;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> save(String name, String surname, Long countryId);
    Optional<Author> findById(Long id);
}
