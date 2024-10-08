package org.example.ProductCatalogService.controllers;

import org.example.ProductCatalogService.dtos.CategoryDto;
import org.example.ProductCatalogService.dtos.ProductDto;
import org.example.ProductCatalogService.models.Category;
import org.example.ProductCatalogService.models.Product;
import org.example.ProductCatalogService.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        if(products == null || !products.isEmpty()) {
            for (Product product : products) {
                ProductDto productDto = from(product);
                productDtos.add(productDto);
            }
           return productDtos;
        }
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
       try{
            if(id<1 || id>20){
                throw new RuntimeException("Product is not found");
            }
            Product product = productService.getProductById(id);
            if(product == null) return null;
            return new ResponseEntity<>(from(product), HttpStatus.OK);
       } catch (RuntimeException e) {
           //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
           throw e;
       }

    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
            Product product = productService.replaceProduct(id,from(productDto));
            return from(product);
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto product){
        Product product1 = productService.createProduct(from(product));
        return from(product1);
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setAmount(productDto.getAmount());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null){
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }


    private ProductDto from (Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setAmount(product.getAmount());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setName(product.getCategory().getName());
            productDto.setCategory(categoryDto);
            productDto.setDescription(product.getCategory().getDescription());
        }
      return productDto;
    }
}
