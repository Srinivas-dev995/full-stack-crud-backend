package com.crudApp.fullStack.service;

import com.crudApp.fullStack.entity.Product;
import com.crudApp.fullStack.exception.ProductNotFoundException;
import com.crudApp.fullStack.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> product =  productRepo.findById(Long.valueOf(id));
         if(!product.isPresent()){
             throw new ProductNotFoundException("Product not available");
         }
         return product.get();
    }

    @Override
    public Product editProduct(Product product,Integer id) {
        Product oldProduct = productRepo.findById(Long.valueOf(id)).get();
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setStatus(product.getStatus());
        return productRepo.save(oldProduct);
    }

    @Override
    public String deleteProduct(Integer id) {
        Product p = productRepo.findById(Long.valueOf(id)).get();
        if ( p != null ){
            productRepo.delete(p);
            return "Product Successfully deleted";
        }
        return "something wrong on server";
    }
}
