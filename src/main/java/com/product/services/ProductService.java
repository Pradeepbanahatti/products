package com.product.services;

import java.util.List;

import com.product.models.Product;

public interface ProductService {

    public Product addProduct(Product product);
    

    public List<Product> search(String pattern);
}
