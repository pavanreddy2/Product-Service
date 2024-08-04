package com.ar.productService.service;

import com.ar.productService.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product request);

    Product updateProductByPatch(Long id, Product request);
}
