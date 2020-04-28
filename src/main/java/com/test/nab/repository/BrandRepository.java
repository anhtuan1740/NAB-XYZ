package com.test.nab.repository;

import com.test.nab.model.Brand;
import com.test.nab.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Long> {

    List<Brand> findByName(String name);

}
