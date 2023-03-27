package com.example.emt.repo;

import com.example.emt.model.Author;
import com.example.emt.model.Country;
import com.example.emt.service.AuthorService;
import com.example.emt.service.BookService;
import com.example.emt.service.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CountryService countryService;
    @Test
    public void createNewBook(){
        Country country=countryService.save("Macedonia","Europe").get();
        Author author=authorService.save("Војдан","Чернодрински",country.getId()).get();
        bookService.save("Македноска Крвава Свадба","DRAMA",author.getId(),10);
        for (int i = 0; i < bookService.findAll().size(); i++) {
            System.out.println(bookService.findAll().get(i));
        }

    }

}
