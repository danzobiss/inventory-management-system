package com.danzobiss.inventory_management_system.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Category extends BaseEntity{

    private String name;

}
