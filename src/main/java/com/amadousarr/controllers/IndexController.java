package com.amadousarr.controllers;

import com.amadousarr.domain.Category;
import com.amadousarr.domain.UnitOfMeasure;
import com.amadousarr.repositories.CategoryRepository;
import com.amadousarr.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository,UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescriptor("Teaspoon");

        System.out.println("Cat id is: " +categoryOptional.get().getId());
        System.out.println("UOM ID is "+unitOfMeasureOptional.get().getId());

        return "index";
    }
}
