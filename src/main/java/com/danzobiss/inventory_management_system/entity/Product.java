package com.danzobiss.inventory_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Product extends BaseEntity{

    private String name;

    private String description;

    private Integer quantity;

    private Double price;

    @ManyToOne
    private Category category;

}
