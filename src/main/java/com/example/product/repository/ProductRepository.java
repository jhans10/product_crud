package com.example.product.repository;

import com.example.product.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
    public Product findByName(String name) {
        return find("name", name).firstResult();
    }
}
