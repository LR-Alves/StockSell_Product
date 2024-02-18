package com.stocksellproduct.service;

import com.stocksellproduct.model.Product;
import com.stocksellproduct.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class ProdutcService {

    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProdutcService.class);

    @Autowired
     public ProdutcService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void createProduct(Product product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            logger.error("log4j aqui: -- >", product);
            throw new RuntimeException("Erro ao adicionar a tarefa", e);
        }

    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductByid(Long id) {
        return productRepository.findById(id);

    }

    public void saveProduct(Product saveProduct) {
        productRepository.save(saveProduct);
    }

//    public void updateProduct(Product updateProduct) {
//        try{
//            Product existingProduct = productRepository.getById(id) ;
//            if(updateProduct)
//        productRepository.save(updateProduct);
//    }

    public void deletProduct(Long id) {
        productRepository.deleteById(id);
    }
}

