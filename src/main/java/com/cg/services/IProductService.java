package com.cg.services;

import com.cg.dto.product.ProductParam;
import com.cg.dto.product.ProductResult;
import com.cg.dto.product.ProductUpdate;
import com.cg.repositories.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);

    List<ProductResult> findAll();

    List<ProductResult> findProductByTitle (String title);

    ProductResult findProductById(Long productId);

    ProductResult createProduct(ProductParam productParam);

    ProductResult updateProduct(ProductUpdate productUpdate);

}
