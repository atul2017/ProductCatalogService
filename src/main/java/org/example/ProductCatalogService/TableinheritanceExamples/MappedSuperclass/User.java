package org.example.ProductCatalogService.TableinheritanceExamples.MappedSuperclass;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class User {

    private String email;

    @Id
    private Long id;
}
