package com.test.nab;

import com.test.nab.model.Product;
import com.test.nab.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        StartApplication.class,
        TestProfileConfig.class})
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByName() {

        List<Product> zara = productRepository.findByNameColorSize("Zara", null, null);
        assertEquals(4, zara.size());
    }

}
