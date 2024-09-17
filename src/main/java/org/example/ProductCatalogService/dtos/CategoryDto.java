package org.example.ProductCatalogService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.ProductCatalogService.models.Category;

@Setter
@Getter

public class CategoryDto {
    private Long id;
    private String name;
    private String description;
}
