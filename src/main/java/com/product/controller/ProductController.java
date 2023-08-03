package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.models.Product;
import com.product.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/search")
    public ResponseEntity<List<Product>> search(@RequestParam String keyword){
        return new ResponseEntity<List<Product>>(productService.search(keyword), HttpStatus.OK);
    }
}
