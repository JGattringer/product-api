package com.jgattringer.productsapi.repository;

import com.jgattringer.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, String> {

    //create a function to return a obj by name
    List<Product> findByName(String name);
}
