package com.projet3.hublo.repository;

import com.projet3.hublo.entity.ProductCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommandRepository extends JpaRepository<ProductCommand, Long> {
}
