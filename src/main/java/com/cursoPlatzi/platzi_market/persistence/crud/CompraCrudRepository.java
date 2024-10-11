package com.cursoPlatzi.platzi_market.persistence.crud;

import com.cursoPlatzi.platzi_market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// en el operador de diamante de CrudRepository
//el primer parametro es la clase del objeto que se va a manejar
//el segundo parametro es el tipo de dato del id o de la clave primaria de la clase
public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    //Esto se llama query method
    Optional<List<Compra>> findByIdCliente(String idcliente);
}
