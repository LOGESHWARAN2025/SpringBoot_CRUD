package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.service.ProductService;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/product")
public class EcommerceController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createUser(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.status( HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateproduct(@RequestBody Product product,@PathVariable int id){
        Product updateProduct = productService.updateProduct(product, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")   
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product with id " + id + " deleted successfully.");
    }

    

}