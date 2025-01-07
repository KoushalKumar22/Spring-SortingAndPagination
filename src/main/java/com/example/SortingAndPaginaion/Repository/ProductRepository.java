package com.example.SortingAndPaginaion.Repository;

import com.example.SortingAndPaginaion.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {
}
