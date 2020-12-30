package com.example.demo_productpage.repository;

import com.example.demo_productpage.dao.ProductpageDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductpageRepository extends JpaRepository<ProductpageDAO, Long> {
    // @Query(nativeQuery = true, value = "select * from employee where id = ?1")
    // ProductpageDAO findById(Integer id);
}
