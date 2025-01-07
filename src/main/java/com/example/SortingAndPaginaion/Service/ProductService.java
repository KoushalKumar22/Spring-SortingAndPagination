package com.example.SortingAndPaginaion.Service;

import com.example.SortingAndPaginaion.Entity.Product;
import com.example.SortingAndPaginaion.Repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
//    @PostConstruct
//    public void initDB(){
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("product"+ i, new Random().nextInt(100), new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        productRepository.saveAll(products);
//    }
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
    public void deleteAllProducts(@RequestBody Product product){
        productRepository.delete(product);
    }
    public List<Product> findProductsWithShorting(String field){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
    public Page<Product> findProductsPagination(int offset, int pageSize){
        Page<Product> products= productRepository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }

    public Page<Product> findProductBySortingAndPagination(int offset , int pageSize, String field){
        Page<Product> products= productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return products;
    }
}