package com.master.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.app.entity.ProductDetails;

public interface ProductDetailRepository extends JpaRepository<ProductDetails, Long> {

}
