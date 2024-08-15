package com.danzobiss.inventory_management_system.service;

import com.danzobiss.inventory_management_system.entity.Category;
import com.danzobiss.inventory_management_system.request.CategoryRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, CategoryRequestDTO> {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected Category createEntityInstance() {
        return new Category();
    }
}
