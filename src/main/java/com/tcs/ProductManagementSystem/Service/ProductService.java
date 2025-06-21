package com.tcs.ProductManagementSystem.Service;

import com.tcs.ProductManagementSystem.Entity.Product;
import com.tcs.ProductManagementSystem.Exception.ProductNotFoundException;
import com.tcs.ProductManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository repo;
    public Product addProduct(Product product) {
        System.out.println(product);
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Optional<Product> getProductById(Long id)  {
        return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found")));
    }

    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> prodext=repo.findById(id);
        if (prodext.isPresent()){
            Product product1=prodext.get();
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setReview(product.getReview());
            return repo.save(product1);
        }
        else {
            return null;
        }
    }

    public String deleteProduct(@PathVariable Long id) {
         if(repo.existsById(id)){
             repo.deleteById(id);
             return "Deleted Successfully " +id;
         }
         else{
             return "Deletion not successful " +id;
         }
    }
}
