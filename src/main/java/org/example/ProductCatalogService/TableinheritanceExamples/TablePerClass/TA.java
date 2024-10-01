package org.example.ProductCatalogService.TableinheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name= "tpc_ta")
public class TA extends User{

    private Double ratings;
}
