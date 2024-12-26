package com.store.cake.service.cake;

import com.store.cake.entity.Cake;
import com.store.cake.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class CakeServiceImpl implements CakeService {

    @Autowired
    private  CakeRepository cakeRepository;

    @Override
    public void addCake(Cake cake) {
        cakeRepository.save(cake);
    }

    @Override
    public List<Cake> getAllCake() {
        List<Cake> cakes = cakeRepository.findAll();
        return  cakes.stream().map(this::convertImageToBase64)
                .toList();
    }

    @Override
    public Cake getCake(int id) {
        return cakeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cake not found with id: " + id));
    }

    @Override
    public void deleteCake(int id) {
        cakeRepository.deleteById(id);
    }

    public Page<Cake> getAllCake(Pageable pageable) {
        Page<Cake> cakes = cakeRepository.findAll(pageable);
        return cakes.map(this::convertImageToBase64); //Apply base64 conversion to each Cake
    }

    private Cake convertImageToBase64(Cake cake) {
        if (cake.getImage() != null && cake.getImage().getImage() != null) {
            String base64Image = Base64.getEncoder().encodeToString(cake.getImage().getImage());
            cake.getImage().setImageBase64(base64Image); //add a getter/setter to Image class!
        }
        return cake;
    }

    @Override
    public void updateCake(Cake cake) {
        cakeRepository.save(cake);
    }

    public Page<Cake> getCakesByCategory(int categoryId, Pageable pageable) {
        Page<Cake> cakes = cakeRepository.findByCategoriesId(categoryId, pageable);;
        return cakes.map(this::convertImageToBase64);
    }

}