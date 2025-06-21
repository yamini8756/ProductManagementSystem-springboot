package com.tcs.ProductManagementSystem.Controller;

import com.tcs.ProductManagementSystem.Entity.Product;
import com.tcs.ProductManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    public ProductService prodservice;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        System.out.println(product);
        return  prodservice.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return prodservice.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return prodservice.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product){
        return prodservice.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return prodservice.deleteProduct(id);
    }
}
