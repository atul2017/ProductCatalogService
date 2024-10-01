package org.example.ProductCatalogService.TableinheritanceExamples.JoinedClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name="jcc_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    private String email;

    @Id
    private Long id;
}
