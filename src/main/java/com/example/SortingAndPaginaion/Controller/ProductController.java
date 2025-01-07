package com.example.SortingAndPaginaion.Controller;

import com.example.SortingAndPaginaion.DTO.APIResponse;
import com.example.SortingAndPaginaion.Entity.Product;
import com.example.SortingAndPaginaion.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public APIResponse<List<Product>> getProducts(){
        List<Product> allProducts= productService.findAllProduct();
        return new APIResponse<>(allProducts.size(), allProducts );
    }
    @DeleteMapping("/delete")
    public String delete(@RequestBody Product product){
        productService.deleteAllProducts(product);
        return "deleted";
    }
    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = productService.findProductsWithShorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = productService.findProductsPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<Product> productsWithPagination = productService.findProductBySortingAndPagination(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
}
