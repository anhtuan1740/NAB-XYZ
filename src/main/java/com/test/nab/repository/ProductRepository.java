package com.test.nab.repository;

import com.test.nab.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>, ProductCustomRepository {

    List<Product> findByName(String name);
}
