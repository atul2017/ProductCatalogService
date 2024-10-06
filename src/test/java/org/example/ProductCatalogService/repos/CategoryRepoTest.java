package org.example.ProductCatalogService.repos;

import jakarta.transaction.Transactional;
import org.example.ProductCatalogService.models.Category;
import org.example.ProductCatalogService.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchTypes(){
        Category category = categoryRepo.findById(2L).get();
        for(Product product : category.getProducts()){
            System.out.println(product.getDescription());
        }
    }

    @Test
    @Transactional
    public void testFetchModesAndTypes(){
        Category category = categoryRepo.findById(2L).get();
      /*  for(Product product : category.getProducts()){
            System.out.println(product.getDescription());
        }*/
    }

    @Test
    @Transactional
    public void runSubQueries(){
        List<Category> category = categoryRepo.findAll();
        for(Category category1 : category){
            for(Product product : category1.getProducts()){
                System.out.println(product.getDescription());
            }
        }
    }

}