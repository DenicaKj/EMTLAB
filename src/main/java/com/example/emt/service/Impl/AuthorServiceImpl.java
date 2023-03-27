package com.example.emt.service.Impl;

import com.example.emt.model.Author;
import com.example.emt.model.Country;
import com.example.emt.repository.AuthorRepository;
import com.example.emt.repository.CountryRepository;
import com.example.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country=countryRepository.findById(countryId).get();
        return Optional.of(authorRepository.save(new Author(name,surname,country)));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
