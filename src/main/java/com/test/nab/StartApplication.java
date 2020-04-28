package com.test.nab;

import com.test.nab.model.Brand;
import com.test.nab.model.Product;
import com.test.nab.repository.BrandRepository;
import com.test.nab.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("StartApplication...");
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            brandRepository.save(new Brand("Zara"));
            brandRepository.save(new Brand("Topman"));
            brandRepository.save(new Brand("Topshop"));
            brandRepository.save(new Brand("Cocosin"));

            Iterable<Brand> iterable = brandRepository.findAll();
            List<Brand> brands= new ArrayList<>();
            Iterator<Brand> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                brands.add(iterator.next());
            }

            // Products
            for (int i = 0; i < 10; i++) {
                Product p = new Product();
                p.setName(DUMMY[i % DUMMY.length]);
                if (i % Product.COLOR_TYPE.values().length == 0) {
                    p.setColor(Product.COLOR_TYPE.RED);
                } else if (i % Product.COLOR_TYPE.values().length == 1) {
                    p.setColor(Product.COLOR_TYPE.ORANGE);
                } else if (i % Product.COLOR_TYPE.values().length == 2) {
                    p.setColor(Product.COLOR_TYPE.YELLOW);
                } else {
                    p.setColor(Product.COLOR_TYPE.GREEN);
                }

                p.setSize(40 + (i % 3));
                p.setCreatedBy("admin");
                p.setModifiedBy("admin");
                p.setCreationDate(new Date());
                p.setModifiedDate(new Date());
                p.setBrand(brands.get(Math.min(i % 3, brands.size() - 1)));
                productRepository.save(p);
            }
        };
    }

    private static final String[] DUMMY = {"T-shirt Spring", "Shoes coconut", "Helmes manual"};

}