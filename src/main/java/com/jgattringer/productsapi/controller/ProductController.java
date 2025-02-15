package com.jgattringer.productsapi.controller;

import com.jgattringer.productsapi.model.Product;
import com.jgattringer.productsapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    // Constructor recive a repo that con to db
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // CRUDE functions

    //recive a product to save
    @PostMapping
    public Product save(@RequestBody Product product) {

        var id = UUID.randomUUID().toString(); // generate a random id and converts it to string
        product.setId(id); // call the setter and pass the generated id as a value

        productRepository.save(product); // save our product in our DB

        // print the res and return the new product
        System.out.println("Product saved with id " + product.getId());

        return product;
    }


    //get the product
    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") String id) {

      //  Optional<Product> product = productRepository.findById(id);
        //  return product.isPresent() ? product.get() : null;
        return productRepository.findById(id).orElse(null); // using optional


    }

    // delete the product
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") String id) {
        productRepository.deleteById(id);
        System.out.println("Product deleted with id " + id);
    }

    // update a product
    @PutMapping("{id}")
   public void updateProductById(@PathVariable("id") String id, @RequestBody Product product) {
       // use same method as to creat a new product but it gets an id as param
       // so it understand that is a update instead of a create
        product.setId(id);
        productRepository.save(product);

        System.out.println("Product updated with id " + product.getId());
   }

   // get a product by its property
    @GetMapping // no need to pass any param cuz appoint to the root
    public List<Product> getByName(@RequestParam("name") String name) {

        // we use the new function that we create on the ProducRepo
        return productRepository.findByName(name);
    }

}
