package com.product.repository;

import java.util.List;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
    
    @Query(value = "from Product p where p.name Like :pattern")
    List<Product> search(String pattern);

} 
