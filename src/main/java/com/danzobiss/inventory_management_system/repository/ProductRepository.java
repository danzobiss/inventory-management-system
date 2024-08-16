package com.danzobiss.inventory_management_system.repository;

import com.danzobiss.inventory_management_system.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends BaseRepository<Product> {

    List<Product> findByCategoryId(Long id, Pageable pageable);

}
