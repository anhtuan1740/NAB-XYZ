package com.test.nab.repository.impl;

import com.test.nab.model.Brand;
import com.test.nab.model.Product;
import com.test.nab.repository.ProductCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    @Autowired
    EntityManager em;


    @Override
    public List<Product> findByNameColorSize(String name, Integer color, Integer size) {
        System.out.println("Searching");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();

        if (size != null) {
            predicates.add(cb.equal(product.get("size"), size));
        }

        if (color != null) {
            predicates.add(cb.equal(product.get("color"), color));
        }

        if (name != null ) {
            Predicate name1 = cb.like(product.get("name"), "%" + name + "%");

            Join<Product, Brand> brand = product.join("brand", JoinType.LEFT);
            Predicate brandl = cb.like(brand.get("name"), "%" + name + "%");

            Predicate predicateForBrandOrName
                    = cb.or(name1, brandl);
            predicates.add(predicateForBrandOrName);
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
    }
}
