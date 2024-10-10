package com.cursoPlatzi.platzi_market.persistence;

import com.cursoPlatzi.platzi_market.domain.Product;
import com.cursoPlatzi.platzi_market.domain.repository.ProductRepository;
import com.cursoPlatzi.platzi_market.persistence.crud.ProductoCrudRepository;
import com.cursoPlatzi.platzi_market.persistence.entity.Producto;
import com.cursoPlatzi.platzi_market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
//Este repositorio está orientado al dominio
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository ProductoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) ProductoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional <List<Product>> getByCategory(int categoryId) {
        List <Producto> productos = ProductoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional <List <Producto>> productos = ProductoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return ProductoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(ProductoCrudRepository.save(mapper.toProducto(product)));
    }

    @Override
    public void delete(int productId) {
        ProductoCrudRepository.deleteById(productId);
    }
    @Override
    public boolean exists(int productId){
        return ProductoCrudRepository.existsById(productId);
    }

}
