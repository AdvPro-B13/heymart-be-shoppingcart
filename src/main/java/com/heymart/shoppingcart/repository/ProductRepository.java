package com.heymart.shoppingcart.repository;

import com.heymart.shoppingcart.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Optional<Product> findProductById(String id) {
        Product product = entityManager.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Transactional
    public Product saveProduct(Product product) {
        if (product.getId() == null || findProductById(product.getId()).isEmpty()) {
            entityManager.persist(product);
        } else {
            product = entityManager.merge(product);
        }
        return product;
    }

    @Transactional
    public void deleteProductById(String id) {
        Product product = findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        entityManager.remove(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
}