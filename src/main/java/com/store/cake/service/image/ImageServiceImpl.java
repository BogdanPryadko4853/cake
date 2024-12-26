package com.store.cake.service.image;

import com.store.cake.entity.Image;
import com.store.cake.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void saveImage(Image image) {

    }
}
