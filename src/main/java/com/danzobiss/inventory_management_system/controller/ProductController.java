package com.danzobiss.inventory_management_system.controller;

import com.danzobiss.inventory_management_system.entity.Product;
import com.danzobiss.inventory_management_system.request.ProductRequestDTO;
import com.danzobiss.inventory_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/products")
public class ProductController extends BaseController<Product, ProductRequestDTO> {

    @Autowired
    private final ProductService productService = (ProductService) service;

    @Override
    protected List<Product> getAllWithParams(Map<String, String> searchParams, int page, int size) {
        return productService.getProductsByCategoryId(Long.valueOf(searchParams.get("categoryId")), page, size);
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }
}
