package org.example.ProductCatalogService.TableinheritanceExamples.MappedSuperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name= "msc_instructor")
@DiscriminatorValue(value="3")
public class Instructor extends User {
    private String company;
}
