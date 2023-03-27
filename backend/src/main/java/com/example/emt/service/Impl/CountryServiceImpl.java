package com.example.emt.service.Impl;

import com.example.emt.model.Country;
import com.example.emt.repository.CountryRepository;
import com.example.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        return Optional.of(countryRepository.save(new Country(name,continent)));
    }
}
