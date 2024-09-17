package org.example.ProductCatalogService.services;

import org.example.ProductCatalogService.models.Product;

import java.util.List;

public interface IProductService {


    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);
}
