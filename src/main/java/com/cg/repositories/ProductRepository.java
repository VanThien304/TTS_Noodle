package com.cg.repositories;

import com.cg.repositories.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByTitleContains (String title);

    List<Product> findAllByOrderByIdDesc ();

}
