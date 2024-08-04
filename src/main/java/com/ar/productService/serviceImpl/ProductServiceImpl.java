package com.ar.productService.serviceImpl;

import com.ar.productService.entity.Product;
import com.ar.productService.exception.CustomException;
import com.ar.productService.repository.ProductRepository;
import com.ar.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        Product productResp = new Product();
        productResp.setProductName(product.getProductName());
        productResp.setPrice(product.getPrice());
        productResp.setQuantity(product.getQuantity());

        return repository.save(productResp);
    }

    @Override
    public Product getProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new CustomException("PRODUCT_NOT_FOUND", "Product not found with id: " + id, HttpStatus.NOT_FOUND.value()));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
       List<Product> products = repository.findAll();
        return products;
    }

    @Override
    public Product updateProduct(Long id, Product request) {
        Optional<Product> productById =  repository.findById(id);
        if (!productById.isPresent()){
           throw new CustomException("PRODUCT_NOT_FOUND", "Product not found with id: " + id, HttpStatus.NOT_FOUND.value());
        } else {
            Product product =  productById.get();
            product.setProductName(request.getProductName());
            product.setQuantity(request.getQuantity());
            product.setPrice(request.getPrice());
            return repository.save(product);
        }

    }

    @Override
    public Product updateProductByPatch(Long id, Product request) {
        Optional<Product> productById =  repository.findById(id);
        if (!productById.isPresent()){
            throw new CustomException("PRODUCT_NOT_FOUND", "Product not found with id: " + id, HttpStatus.NOT_FOUND.value());
        }else {
            Product product = productById.get();
            if (request.getProductName() != null){
                product.setProductName(request.getProductName());
            }
            if (request.getPrice() != 0){
                product.setPrice(request.getPrice());
            }
            if (request.getQuantity() != 0){
                product.setQuantity(request.getQuantity());
            }

            return repository.save(product);
        }


    }
}
