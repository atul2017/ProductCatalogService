package org.example.ProductCatalogService.TableinheritanceExamples.MappedSuperclass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name= "msc_mentor")
@DiscriminatorValue(value="2")
public class Mentor extends User {

    private Long hours;

}
