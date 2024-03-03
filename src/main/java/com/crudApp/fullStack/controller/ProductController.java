package com.crudApp.fullStack.controller;

import com.crudApp.fullStack.entity.Product;
import com.crudApp.fullStack.exception.ProductNotFoundException;
import com.crudApp.fullStack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3002")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product){

        return productService.saveProduct(product);
    }

    @GetMapping("/getProduct")
    public List<Product> getProduct(){
        return productService.getProduct();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable(name = "id") Integer id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PutMapping("/editProduct/{id}")
    public Product editProduct(@RequestBody Product product,@PathVariable(name = "id") Integer id){
        return productService.editProduct(product,id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id){
        return productService.deleteProduct(id);
    }
}
