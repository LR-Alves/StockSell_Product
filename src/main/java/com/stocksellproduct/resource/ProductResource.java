package com.stocksellproduct.resource;

import com.stocksellproduct.model.Product;
import com.stocksellproduct.service.ProdutcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/v1")
public class ProductResource {


    private final  ProdutcService produtcService ;

    @Autowired
    public ProductResource (ProdutcService produtcService){
        this.produtcService = produtcService;
    }
    @GetMapping("/status")
    public ResponseEntity<String> TestServiceEndpoint(String retornoStatus) {
        retornoStatus = "Service is running";
        return  ResponseEntity.ok(retornoStatus);
    }


@GetMapping
public ResponseEntity<List<Product>> getAllProduct() {
    List<Product> products = produtcService.getAllProduct();
    return new ResponseEntity<>(products, HttpStatus.OK);
}

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return produtcService.getProductByid(id).map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PostMapping
//    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//        produtcService.addproduct(product);
//        return new ResponseEntity<>(product, HttpStatus.CREATED);
//    }
//
//    @PutMapping
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, Product updateProduct) {
//        updateProduct.setId(id);
//        produtcService.updateProduct(updateProduct);
//        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> DeleteProduct(@PathVariable Long id) {
        produtcService.deletProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
