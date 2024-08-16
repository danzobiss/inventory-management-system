package com.danzobiss.inventory_management_system.service;

import com.danzobiss.inventory_management_system.entity.Product;
import com.danzobiss.inventory_management_system.repository.ProductRepository;
import com.danzobiss.inventory_management_system.request.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product, ProductRequestDTO> {

    @Autowired
    private final ProductRepository productRepository = (ProductRepository) repository;

    @Autowired
    CategoryService categoryService;

    public List<Product> getProductsByCategoryId(Long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    protected Product transformEntity(ProductRequestDTO source, Product destination) {
        Product product = super.transformEntity(source, destination);
        product.setCategory(categoryService.findById(source.getCategoryId()));
        return product;
    }

    @Override
    protected Product createEntityInstance() {
        return new Product();
    }
}
