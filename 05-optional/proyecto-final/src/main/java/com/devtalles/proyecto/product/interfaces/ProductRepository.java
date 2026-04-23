package com.devtalles.proyecto.product.interfaces;

import com.devtalles.proyecto.product.exception.InvalidProductDataException;
import com.devtalles.proyecto.product.exception.ProductNotFoundException;
import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll() throws InvalidProductDataException;
    Optional<Product> findById(Long id);
    void save(Product product) throws InvalidProductDataException;
    void delete(Long id);
    List<Product> findByCategory(ProductCategory category);
    void update(Optional<Product> product) throws ProductNotFoundException;
    boolean existsById(Long id);
}
