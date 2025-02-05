package com.jgattringer.productsapi.repository;

import com.jgattringer.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, String> {
}
