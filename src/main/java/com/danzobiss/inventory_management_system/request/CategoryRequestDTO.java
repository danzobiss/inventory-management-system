package com.danzobiss.inventory_management_system.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequestDTO {

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, max = 30, message = "The name must contain a minimum of 2 characters and a maximum of 30")
    private String name;

}
