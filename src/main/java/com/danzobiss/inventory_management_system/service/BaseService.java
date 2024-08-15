package com.danzobiss.inventory_management_system.service;

import com.danzobiss.inventory_management_system.entity.BaseEntity;
import com.danzobiss.inventory_management_system.exception.ResourceNotFoundException;
import com.danzobiss.inventory_management_system.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.danzobiss.inventory_management_system.util.EntityTransformerUtil.transform;

public abstract class BaseService<T extends BaseEntity, DTO> {

    @Autowired
    BaseRepository<T> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(getEntityClass(), id));
    }

    private T save(T entity) {
        return repository.save(entity);
    }

    public T update(Long id, DTO dto) {
        return save(transformEntity(dto, findById(id)));
    }

    public T create(DTO dto) {
        return save(transformEntity(dto, createEntityInstance()));
    }

    public void deleteById(Long id) {
        repository.delete(findById(id));
    }

    protected T transformEntity(DTO source, T destination) {
        return transform(source, destination);
    }

    protected abstract Class<T> getEntityClass();

    protected abstract T createEntityInstance();
}
