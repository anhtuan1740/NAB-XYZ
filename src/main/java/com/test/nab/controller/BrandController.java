package com.test.nab.controller;

import com.test.nab.error.ItemNotFoundException;
import com.test.nab.model.Brand;
import com.test.nab.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @Autowired
    private BrandRepository repository;

    // Find
    @GetMapping("/brands/{id}")
    Brand findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }


}
