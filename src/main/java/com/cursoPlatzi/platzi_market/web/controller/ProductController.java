package com.cursoPlatzi.platzi_market.web.controller;

import com.cursoPlatzi.platzi_market.domain.Product;
import com.cursoPlatzi.platzi_market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Esta clase funciona como controlador de productos,
 * es decir, es la encargada de recibir las peticiones HTTP y devolverlas al cliente.
 * Se comunica con la clase ProductService para obtener los productos de la base de datos.
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/id/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/scarse/{quantity}")
    public Optional<List<Product>> getScarseProducts(@PathVariable("quantity") int quantity){
        return productService.getScarseProducts(quantity);
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return  new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity delete(@PathVariable("productId") int productId){
        if(productService.exists(productId)){
            productService.delete(productId);
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
