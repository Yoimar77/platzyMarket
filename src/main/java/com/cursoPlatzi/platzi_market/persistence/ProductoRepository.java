package com.cursoPlatzi.platzi_market.persistence;

import com.cursoPlatzi.platzi_market.persistence.crud.ProductoCrudRepository;
import com.cursoPlatzi.platzi_market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository {
    private ProductoCrudRepository ProductoCrudRepository;
    public List<Producto> getAll(){
        return (List<Producto>) ProductoCrudRepository.findAll();
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
