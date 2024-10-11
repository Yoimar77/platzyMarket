package com.cursoPlatzi.platzi_market.persistence;

import com.cursoPlatzi.platzi_market.domain.Purchase;
import com.cursoPlatzi.platzi_market.domain.repository.PurchaseRepository;
import com.cursoPlatzi.platzi_market.persistence.crud.CompraCrudRepository;
import com.cursoPlatzi.platzi_market.persistence.entity.Compra;
import com.cursoPlatzi.platzi_market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    //ya que CompraRepository debe hablar en terminos del dominio,
    // se usa el PurchaseMapper para mapear los objetos de la base de datos a objetos del dominio
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>)compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        //se va a guardar en cascada, ya que asi lo tuvimos que indicar
        //en el Entity Compra, se guardan los productos en la misma transaccion
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}
