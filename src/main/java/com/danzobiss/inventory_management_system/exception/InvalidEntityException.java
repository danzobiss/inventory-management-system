package com.danzobiss.inventory_management_system.exception;

import lombok.Getter;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEntityException extends RuntimeException {
    List<String> errorMessages;

    public InvalidEntityException(Class<?> resourceClass, BindingResult bindingResult) {
        super("The " + resourceClass.getSimpleName().toLowerCase() + " entity has inconsistencies in the registration");
        errorMessages = bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }
}
