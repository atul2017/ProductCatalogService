package org.example.ProductCatalogService.repos;

import jakarta.persistence.Id;
import org.example.ProductCatalogService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


}
