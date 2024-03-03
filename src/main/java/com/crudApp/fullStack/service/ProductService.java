package com.crudApp.fullStack.service;

import com.crudApp.fullStack.entity.Product;
import com.crudApp.fullStack.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getProduct();

    Product getProductById(Integer id) throws ProductNotFoundException;

    Product editProduct(Product product,Integer id);

    String deleteProduct(Integer id);
}
