package org.example.ProductCatalogService.repos;

import jakarta.transaction.Transactional;
import org.example.ProductCatalogService.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testQueries(){
//        List<Product> productList = productRepo.findProductsByAmountBetween(100000.0,2000000.0);
//        for(Product product : productList){
//            System.out.println(product.getTitle()+ " "+ product.getAmount());
//        }
        String desc = productRepo.findCategoryNameFromProductId(5000L);
        System.out.println(desc);
    }


}