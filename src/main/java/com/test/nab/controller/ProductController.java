package com.test.nab.controller;

import com.test.nab.model.Product;
import com.test.nab.model.ProductDto;
import com.test.nab.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // Find
    @GetMapping("/hello")
    String hello() {
        return "hello";
    }

    @GetMapping("/products")
    @ResponseBody
    List<ProductDto> getProducts(@RequestParam (required = false) String name,
                                 @RequestParam (required = false) Integer color, @RequestParam (required = false) Integer size) {
        List<Product> byNameColorSize = repository.findByNameColorSize(name, color, size);
        return byNameColorSize.stream().map( p -> {
            ProductDto dto = new ProductDto();
            dto.setId(p.getId());
            dto.setBrand(p.getBrand().getName());
            dto.setName(p.getName());
            dto.setSize(p.getSize());
            dto.setColor(p.getColor().name());
            return dto;
        }).collect(Collectors.toList());
    }


}
