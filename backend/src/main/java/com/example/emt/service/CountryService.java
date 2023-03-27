package com.example.emt.service;

import com.example.emt.model.Country;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CountryService {
    Optional<Country> save(String name,String continent);
}
