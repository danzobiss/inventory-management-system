package com.danzobiss.inventory_management_system.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 2, max = 30, message = "The name must contain a minimum of 2 characters and a maximum of 30")
    private String name;

    @Size(min = 10, max = 200, message = "The description must contain a minimum of 10 characters and a maximum of 200")
    private String description;

    @NotNull(message = "The quantity cannot be null")
    @Min(value = 0, message = "The quantity must be greater than or equal to 0")
    private Integer quantity;

    @NotNull(message = "The price cannot be null")
    @DecimalMin(value = "0.01", message = "The price must be at least 1 cent")
    private Double price;

    @NotNull(message = "The category id must be specified")
    private Long categoryId;

}
