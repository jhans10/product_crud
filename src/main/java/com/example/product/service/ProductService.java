package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {


    @Inject
    ProductRepository repository;

    public List<Product> listAll() {
        return repository.listAll();
    }

    @Transactional
    public Product create(Product product) {
        if (repository.findByName(product.name) != null) {
            throw new IllegalArgumentException("El producto ya existe");
        }
        repository.persist(product);
        return product;
    }

    @Transactional
    public Product update(Long id, Product data) {
        Product entity = repository.findById(id);
        if (entity == null) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        entity.name = data.name;
        entity.price = data.price;
        entity.description = data.description;
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new IllegalArgumentException("No se pudo eliminar, no existe");
        }
    }
}
