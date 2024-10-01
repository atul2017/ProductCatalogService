package org.example.ProductCatalogService.TableinheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name= "st_ta")
@DiscriminatorValue(value="1")
public class TA extends User {

    private Double ratings;
}
