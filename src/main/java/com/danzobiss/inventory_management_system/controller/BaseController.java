package com.danzobiss.inventory_management_system.controller;

import com.danzobiss.inventory_management_system.entity.BaseEntity;
import com.danzobiss.inventory_management_system.exception.InvalidEntityException;
import com.danzobiss.inventory_management_system.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@SuppressWarnings("unused")
@RestController
public abstract class BaseController<T extends BaseEntity, DTO> {

    @Autowired
    BaseService<T, DTO> service;

    @GetMapping
    public ResponseEntity<List<T>> getAll(@RequestParam(required = false) Map<String, String> searchParams) {
        List<T> entitiesList;

        if (searchParams.isEmpty()) {
            entitiesList = service.findAll();
        } else {
            entitiesList = getAllWithParams(searchParams);
        }

        return status(OK).body(entitiesList);
    }

    protected abstract List<T> getAllWithParams(Map<String, String> searchParams);

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Long id) {
        T entity = service.findById(id);
        return status(OK).body(entity);
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody DTO dto, BindingResult bindingResult) {
        checkInvalidEntity(bindingResult);

        T createdEntity = service.create(dto);
        return status(CREATED).body(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Long id, @Valid @RequestBody DTO dto, BindingResult bindingResult) {
        checkInvalidEntity(bindingResult);

        T updatedEntity = service.update(id, dto);
        return status(OK).body(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return status(NO_CONTENT).build();
    }

    protected void checkInvalidEntity(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidEntityException(getEntityClass(), bindingResult);
        }
    }

    protected abstract Class<T> getEntityClass();

}
