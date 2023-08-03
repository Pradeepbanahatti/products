package com.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.models.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


    @Override
    public List<Product> search(String pattern) {
        if(pattern != null) {
            return productRepository.search("%" + pattern + "%");
        } else {
            return productRepository.findAll();
        }
        
    }
    
}
