package com.store.cake.repository;

import com.store.cake.entity.Cake;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<Cake,Integer> {
    Page<Cake> findByCategoriesId(int categoryId, Pageable pageable);
}
