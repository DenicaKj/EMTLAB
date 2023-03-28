package com.example.emt.service.Impl;

import com.example.emt.model.enumeration.Category;
import com.example.emt.repository.CategoryRepository;
import com.example.emt.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public ImplCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<String> categories() {
        List<String> cat=new ArrayList<>();
        List<Category> categories= List.of(categoryRepository.getAll());
        for (int i = 0; i < categories.size(); i++) {
            cat.add(categories.get(i).toString());
        }
        return cat;
    }
}
