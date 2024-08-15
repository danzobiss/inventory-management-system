package com.danzobiss.inventory_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Class<?> resourceClass, Long id) {
        super(resourceClass.getSimpleName() + " not found with id " + id);
    }
}
