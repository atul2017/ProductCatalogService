package org.example.ProductCatalogService.repos;

import jakarta.persistence.Id;
import org.example.ProductCatalogService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findProductsByAmountBetween(Double low, Double high);

    List<Product> findProductByIsPrimeSpecificTrue();

    //Position
    @Query("select p.description from Product p where p.id=?1")
    String findProductDescriptionFromProductId(Long id);

    //Name
    @Query("select c.name from Category c join Product p on p.category.id = c.id where p.id=:id")
    String findCategoryNameFromProductId(Long id);

}
