package com.ecommerce.service;

import com.ecommerce.payload.ProductRequest;
import com.ecommerce.payload.ProductResponce;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequest productRequest);

   public List<ProductResponce> getAllProducts();
}
