package com.test.nab.repository;

import com.test.nab.model.Product;

import java.util.List;

public interface ProductCustomRepository {

    List<Product> findByNameColorSize(String name, Integer color, Integer size);
}
