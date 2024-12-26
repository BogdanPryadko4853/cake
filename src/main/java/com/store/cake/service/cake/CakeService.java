package com.store.cake.service.cake;

import com.store.cake.entity.Cake;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CakeService {

    public void addCake(Cake cake);

    public List<Cake> getAllCake();

    public Cake getCake(int id);

    public void deleteCake(int id);

    public Page<Cake> getAllCake(Pageable pageable);

    public void updateCake(Cake cake);
}
