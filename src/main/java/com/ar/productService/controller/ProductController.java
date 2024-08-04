package com.ar.productService.controller;

import com.ar.productService.entity.Product;
import com.ar.productService.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productResp = productService.createProduct(product);
        return new ResponseEntity<Product>(productResp, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ("id") Long id){
      Product productResp = productService.getProductById(id);
      return new ResponseEntity<>(productResp,HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
      List<Product> productResponce =  productService.getAllProducts();
      return new ResponseEntity<List<Product>>(productResponce,HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProducts(@PathVariable("id") Long id, @RequestBody Product request){
        Product productResp =  productService.updateProduct(id, request);
        return new ResponseEntity<>(productResp,HttpStatus.CREATED);
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Product> updateProductByPatch(@PathVariable("id") Long id, @RequestBody Product request){
        Product productResp =  productService.updateProductByPatch(id, request);
        return new ResponseEntity<>(productResp,HttpStatus.CREATED);
    }
}
