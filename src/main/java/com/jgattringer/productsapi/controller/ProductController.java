package com.jgattringer.productsapi.controller;

import com.jgattringer.productsapi.model.Product;
import com.jgattringer.productsapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    // Constructor
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {

        var id = UUID.randomUUID().toString(); // generate a random id and converts it to string
        product.setId(id); // call the setter and pass the generated id ass a value

        productRepository.save(product); // save our product in our DB

        System.out.println("Product saved with id " + product.getId());

        return product;
    }


    // STOPED HERE============================================
    @GetMapping()
    public Product getProductById(String id) {

      //  Optional<Product> product = productRepository.findById(id);
        //  return product.isPresent() ? product.get() : null;

        return productRepository.findById(id).orElse(null); // using optional
    }
}
