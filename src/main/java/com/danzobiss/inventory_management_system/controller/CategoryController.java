package com.danzobiss.inventory_management_system.controller;

import com.danzobiss.inventory_management_system.entity.Category;
import com.danzobiss.inventory_management_system.request.CategoryRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category, CategoryRequestDTO>{

    @Override
    protected List<Category> getAllWithParams(Map<String, String> searchParams) {
        throw new UnsupportedOperationException("Search parameters are not supported in CategoryController.");
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
