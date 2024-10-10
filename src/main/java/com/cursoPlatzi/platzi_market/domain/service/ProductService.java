package com.cursoPlatzi.platzi_market.domain.service;

import com.cursoPlatzi.platzi_market.domain.Product;
import com.cursoPlatzi.platzi_market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductService funciona un intermediario entre el controlador y la capa del repositorio
 * para manejar las operaciones CRUD de los productos.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }
    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public void delete(int productId){
        productRepository.delete(productId);
    }
    public boolean exists(int productId) {
        return productRepository.exists(productId);
    }
}
