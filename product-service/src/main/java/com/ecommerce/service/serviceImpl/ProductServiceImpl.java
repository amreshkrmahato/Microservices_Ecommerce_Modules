package com.ecommerce.service.serviceImpl;

import com.ecommerce.model.Product;
import com.ecommerce.payload.ProductRequest;
import com.ecommerce.payload.ProductResponce;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private  ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product= Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("product"+ product.getId() +" is saved.");

    }

    @Override
    public List<ProductResponce> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponce mapToProductResponse(Product product){
        return ProductResponce.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
