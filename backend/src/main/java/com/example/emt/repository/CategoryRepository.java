package com.example.emt.repository;

import com.example.emt.model.enumeration.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    public Category[] getAll(){
        return Category.values();
    }
}
