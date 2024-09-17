package com.cursoPlatzi.platzi_market.persistence.crud;

import com.cursoPlatzi.platzi_market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
    //@Query(value = "SELECT * FROM productos WHERE id_categoria =?", nativeQuery = true)
    /**Si tenemos la anotacioon @Query, no es necesario definir el metodo findByIdCategoria
     con ese nombre, ya que el nombre del metodo no importa, solo el nombre de la anotacion.
    Sin embargo, es mejor usar los Query Methods para definir las consultas personalizadas.*/
    List<Producto> findByIdCategoria(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
