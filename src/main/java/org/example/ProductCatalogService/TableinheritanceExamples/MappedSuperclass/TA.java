package org.example.ProductCatalogService.TableinheritanceExamples.MappedSuperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name= "msc_ta")
@DiscriminatorValue(value="1")
public class TA extends User {

    private Double ratings;
}
