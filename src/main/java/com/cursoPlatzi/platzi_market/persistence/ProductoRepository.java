package com.cursoPlatzi.platzi_market.persistence;

import com.cursoPlatzi.platzi_market.domain.Product;
import com.cursoPlatzi.platzi_market.persistence.crud.ProductoCrudRepository;
import com.cursoPlatzi.platzi_market.persistence.entity.Producto;
import com.cursoPlatzi.platzi_market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository ProductoCrudRepository;
    private ProductMapper mapper;
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) ProductoCrudRepository.findAll();
        return mapper.toProducts(productos);git
    }
    public List<Producto> getByCategoria(int idCategoria){
        return ProductoCrudRepository.findByIdCategoria(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return ProductoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }
    public Optional<Producto> getProducto(int idProducto){
        return ProductoCrudRepository.findById(idProducto);
    }
    public Producto saveProducto(Producto producto){
        return ProductoCrudRepository.save(producto);
    }
    public void deleteProducto(int idProducto){
        ProductoCrudRepository.deleteById(idProducto);
    }
}
