package com.example.emt.model.DTO;

import com.example.emt.model.Author;
import com.example.emt.model.enumeration.Category;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class BookDTO {
    String name;
    Category category;
    Long author;
    int availableCopies;

    public BookDTO(String name, Category category, Long author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
