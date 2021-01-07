package com.example.demo_productpage.repository;

import java.util.List;

import com.example.demo_productpage.dao.ProductpageDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductpageRepository extends JpaRepository<ProductpageDAO, Long> {
    @Query(nativeQuery = true, value = "select p.id, p.prod_code, p.img_path, p.prod_intro, p.create_date, pc.prod_name from productpage p, product_code pc where p.prod_code = pc.prod_code")
    List<ProductpageDAO> findByProdCode();
}
